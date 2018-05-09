package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("index")
    public String index(ModelMap model){
        model.addAttribute("name","www.imooc.com");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center(){
        return "thymeleaf/center/center";
    }

}
