package com.cg.controller;

import com.cg.model.Cart;
import com.cg.model.Product;
import com.cg.model.ProductForm;
import com.cg.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Value("${file-upload}")
    private String fileUpload;

    @ModelAttribute("cart")
    public Cart setCart(){
        return new Cart();
    }

    @GetMapping("shop")
    public ModelAndView showShop(@RequestParam("search")Optional<String> search,
                                 @RequestParam("page")Optional<Integer> p){
        Page<Product> products;
        Pageable firstPageWithFiveElement = PageRequest.of(p.orElse(0),5);
        if (search.isPresent()) {
            products =  productService.findAllByNameContaining(search.get(), firstPageWithFiveElement);
        }else {
            products =productService.findAll(firstPageWithFiveElement);
        }
        ModelAndView modelAndView = new ModelAndView("product/shop");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart,
                            @RequestParam("action") String action){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            return "error.404";
        }
        if (action.equals("add")){
            cart.addProduct(productOptional.get());
            return "shopping/cart";
        }
        if (action.equals("minus")){
            cart.minusProduct(productOptional.get());
            return "shopping/cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("create-product")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

//    @PostMapping("create-product")
//    public ModelAndView create(@ModelAttribute("product") Product product){
//        productService.save(product);
//        ModelAndView modelAndView = new ModelAndView("product/create");
//        modelAndView.addObject("product", new Product());
//        modelAndView.addObject("message", "created Successfully");
//        return modelAndView;
//    }

    @PostMapping("create-product")
    public ModelAndView saveProduct(@ModelAttribute("productForm") ProductForm productForm) {
        Product product = handleFile(productForm);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

    @GetMapping("edit-product/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        ModelAndView modelAndView;
        if (productOptional.isPresent()){
            modelAndView  = new ModelAndView("product/edit");
            modelAndView.addObject("product",productOptional.get());
        }else {
            modelAndView = new ModelAndView("error.404");
        }
        return modelAndView;
    }

    @PostMapping("edit-product")
    public ModelAndView edit(@ModelAttribute("product") ProductForm productForm){
        Product product = handleFile(productForm);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("massage", "Edited Successfully");
        return modelAndView;
    }


    private Product handleFile(ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new Product(productForm.getId(), productForm.getName(), productForm.getPrice(),
                productForm.getDescription(), fileName);
    }

    @GetMapping("delete-product/{id}")
    public ModelAndView showViewDelete(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        ModelAndView modelAndView;
        if (product.isPresent()){
            modelAndView = new ModelAndView("product/delete");
            modelAndView.addObject("product",product.get());
        }else {
            modelAndView = new ModelAndView("error.404");
        }
        return modelAndView;
    }

    @PostMapping("delete-product")
    public String delete(@ModelAttribute("product")Product product){
        productService.remove(product.getId());
        return "redirect:shop";
    }

}
