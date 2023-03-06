package com.sandwich;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String loadIndex() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam("condiment") String condiment, Model model) {
        model.addAttribute("result", condiment);
        return "index";
    }

}