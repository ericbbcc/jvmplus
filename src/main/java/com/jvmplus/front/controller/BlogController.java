package com.jvmplus.front.controller;

import com.jvmplus.bo.BlogEditorBO;
import com.jvmplus.builder.BlogEditorBOBuilder;
import com.jvmplus.service.IBlogService;
import com.jvmplus.service.ICatalogService;
import com.jvmplus.util.SessionUtils;
import com.jvmplus.vo.Blog;
import com.jvmplus.vo.Catalog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by andy on 2/22/15.
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    @Resource
    private ICatalogService catalogService;
    @Resource
    private IBlogService blogService;

    @RequestMapping("add")
    @ResponseBody
    public String insert(Model model,Blog blog, Catalog catalog){
        BlogEditorBO blogEditorBO = BlogEditorBOBuilder.me().setBlog(blog).setCatalog(catalog).build();
        blogService.saveBlogEditorBO(blogEditorBO);
        return "success";
    }

    @RequestMapping("editor")
    public String editor(Model model){
        List<Catalog> catalogList = catalogService.findCatalogsByUser(SessionUtils.getCurrentUser());
        model.addAttribute("catalogList",catalogList);
        return "editor";
    }
}
