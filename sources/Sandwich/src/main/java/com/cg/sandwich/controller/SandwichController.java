package com.cg.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SandwichController {
    @GetMapping("list")
    public String save(@PathVariable("condiment") String[] condiment, Model model) {
        ModelMap modelMap = new ModelMap();
        for (String c : condiment) {
            System.out.println(c);
        }
        model.addAttribute("condiment", c);
        return "list";
    }

}

