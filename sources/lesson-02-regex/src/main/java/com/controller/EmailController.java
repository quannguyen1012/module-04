package com.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Controller
public class EmailController {
    private static final String EMAIL_REGEX= "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

//    public EmailController(){
//        pattern = Pattern.compile(EMAIL_REGEX);
//    }


    @GetMapping("/")
    String getIndex() {
        return "index";
    }

    @PostMapping("/")
    String validateEmail(@RequestParam("email") String email, Model model){
         pattern = Pattern.compile(EMAIL_REGEX);
         matcher = pattern.matcher(email);
        Boolean isValid =  matcher.find();
//        boolean isValid = this.validate(email);
        if (!isValid){
            model.addAttribute("message", "Email is inValid");
            return "index";
        }
        model.addAttribute("email", email);
        return "success";
    }

//    private Boolean validate(String regex) {
//        matcher = pattern.matcher(regex);
//        return matcher.matches();
//    }

}
