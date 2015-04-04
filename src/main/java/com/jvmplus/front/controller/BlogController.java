package com.jvmplus.front.controller;

import com.jvmplus.bo.BlogDetailBO;
import com.jvmplus.bo.BlogEditorBO;
import com.jvmplus.bo.PaginationBO;
import com.jvmplus.builder.BlogDetailBOBuilder;
import com.jvmplus.builder.BlogEditorBOBuilder;
import com.jvmplus.service.IBlogService;
import com.jvmplus.service.ICatalogService;
import com.jvmplus.util.IDgenerator;
import com.jvmplus.util.SessionUtils;
import com.jvmplus.vo.Blog;
import com.jvmplus.vo.Catalog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String insert(Blog blog, Catalog catalog){
        String blogId = IDgenerator.blogId();
        blog.setBlogId(blogId);
        BlogEditorBO blogEditorBO = BlogEditorBOBuilder
                .me()
                .setBlog(blog)
                .setCatalog(catalog)
                .setUser(SessionUtils.getCurrentUser()).build();
        blogService.saveBlogEditorBO(blogEditorBO);
        return "/blog/view/" + blogId;
    }

    @RequestMapping("editor")
    public String editor(Model model){
        List<Catalog> catalogList = catalogService.findCatalogsByUser(SessionUtils.getCurrentUser());
        model.addAttribute("catalogList",catalogList);
        return "editor";
    }

    @RequestMapping("view/{id}")
    public String viewDetail(Model model, @PathVariable String id){
        Blog blog = null;
        if(StringUtils.hasText(id)){
            blog = blogService.findById(id);
        }
        if(blog == null){
            blog = blogService.findTheLastOne();
        }
        List<Catalog> catalogs = catalogService.findCatalogsByUser(SessionUtils.getCurrentUser());
        BlogDetailBO blogDetailBO = BlogDetailBOBuilder
                .me()
                .setBlog(blog)
                .setCatalogList(catalogs)
                .setUser(SessionUtils.getCurrentUser()).build();
        model.addAttribute("detail", blogDetailBO);
        model.addAttribute("catalogList",catalogs);
        return "index";
    }

    @RequestMapping("next/{blogId}")
    public String nextItem(@PathVariable String blogId){
        Blog  blog = blogService.nextBlog(SessionUtils.getCurrentUser(),blogId);
        return "redirect:/blog/view/"  + blog.getBlogId();
    }


    @RequestMapping("before/{blogId}")
    public String beforeItem(@PathVariable String blogId){
        Blog  blog = blogService.beforeBlog(SessionUtils.getCurrentUser(), blogId);
        return "redirect:/blog/view/"  + blog.getBlogId();
    }


}
