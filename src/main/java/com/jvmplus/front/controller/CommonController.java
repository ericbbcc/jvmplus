package com.jvmplus.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by andy on 2/23/15.
 */
@Controller
public class CommonController {

    @RequestMapping("/")
    public String main(){
        return "redirect:/blog/view/hello";
    }

}
