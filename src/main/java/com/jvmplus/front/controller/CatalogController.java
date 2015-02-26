package com.jvmplus.front.controller;

import com.jvmplus.service.ICatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by andy on 2/27/15.
 */
@Controller
@RequestMapping("cata")
public class CatalogController {

    @Resource
    private ICatalogService catalogService;

    @ResponseBody
    @RequestMapping("save")
    public String save(String name){
        catalogService.saveCatalog(name);
        return "editor";
    }
}
