package com.cg.maytinh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class greetingController {

    @GetMapping("/coculator")
    public String coculator(@RequestParam(required = false) Integer fisrtN,
                            @RequestParam(required = false) Integer secondN,
                            @RequestParam(required = false) String addition,Model model){

        Integer result=null;
        switch (addition){
            case "cong":
                result = fisrtN + secondN;
                break;
            case "tru":
                result = fisrtN - secondN;
                break;
            case "nhan":
                result = fisrtN * secondN;
                break;
            case "chia":
                result = fisrtN / secondN;
                break;
        }

        model.addAttribute("result", result);
        return "index";
    }
}
