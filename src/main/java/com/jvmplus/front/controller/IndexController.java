package com.jvmplus.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("front")
@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}

    @RequestMapping("editor")
    public String editor(){
        return "editor";
    }

}
