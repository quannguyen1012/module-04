package com.cg.productmanager.controller;

import com.cg.productmanager.model.Product;
import com.cg.productmanager.service.ProductService;
import com.cg.productmanager.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping({"/","/product"})
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();

    @GetMapping("")
    public ModelAndView showlist(Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public String showView(@PathVariable Integer id, Model model){
//        ModelAndView modelAndView = new ModelAndView("view");
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

//    @GetMapping("/{id}")
//    public ModelAndView create(@PathVariable Integer id, Model model){
//        ModelAndView modelAndView = new ModelAndView("create");
//        Product product = productService.save();
//        model.addAttribute("product", product);
//        return modelAndView;
//    }
//
//
//    @GetMapping("/{id}")
//    public ModelAndView showView(@PathVariable Integer id, Model model){
//        ModelAndView modelAndView = new ModelAndView("view");
//        Product product = productService.findById(id);
//        model.addAttribute("product", product);
//        return modelAndView;
//    }@GetMapping("/{id}")
//    public ModelAndView showView(@PathVariable Integer id, Model model){
//        ModelAndView modelAndView = new ModelAndView("view");
//        Product product = productService.findById(id);
//        model.addAttribute("product", product);
//        return modelAndView;
//    }@GetMapping("/{id}")
//    public ModelAndView showView(@PathVariable Integer id, Model model){
//        ModelAndView modelAndView = new ModelAndView("view");
//        Product product = productService.findById(id);
//        model.addAttribute("product", product);
//        return modelAndView;
//    }


}
