package com.controller;

import com.service.ITranslate;
import com.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Translate {
    @Autowired
    private ITranslate translateService;

    @GetMapping("/translate")
    public String viewIndex(){
        return "index";
    }


    @PostMapping("/translate")
    public ModelAndView translated(@RequestParam("word") String word){
        Integer idx = translateService.findIdName(word);
        String result = translateService.findNameByIdx(idx);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
