package com.controller;

import com.model.Product;
import com.service.IProductService;
import com.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    public final IProductService productService = new ProductService();

    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product){
        product.setId((int) (Math.random() * 100));
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable Integer id){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product product){
       productService.update(product.getId(), product);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String showViewDelete(Model model, @PathVariable Integer id){
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product) {
        productService.remove(product.getId());
        return "redirect:/";
    }

    @GetMapping("view/{id}")
    public String view(Model model, @PathVariable Integer id){
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam("search") String search) {
        List<Product> products = productService.findAll();
        List<Product> listSearch = new ArrayList<>();
        if (!search.equals("")) {
            for (Product product : products) {
                if (product.getName().equals(search)) {
                    listSearch.add(product);
                }
            }
            model.addAttribute("products", listSearch);
            return "index";
        }

//        model.addAttribute("product", productService.findAll());
        return "redirect:/";
    }
}
