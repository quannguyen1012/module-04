package com.cg.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/convert")
    public String convert(@RequestParam(required = false) Integer number,
                          @RequestParam(required = false) String currency, Model model){
        if (number != null) {
            switch (currency) {
                case "VND":
                    model.addAttribute("result", number * 23000);
                    break;
                case "USD":
                    model.addAttribute("result", number / 23000);
                    break;
            }
        }
        return "/index";
    }

}
