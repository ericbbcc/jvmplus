package com.jvmplus.front.controller;

import com.jvmplus.vo.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by andy on 2/22/15.
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    @RequestMapping("add")
    @ResponseBody
    public String insert(Model model,Blog blog){
        return "";
    }
}
