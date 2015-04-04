package com.jvmplus.front.controller;

import com.jvmplus.bo.PaginationBO;
import com.jvmplus.service.IBlogService;
import com.jvmplus.service.ICatalogService;
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
 * Created by andy on 2/24/15.
 */
@RequestMapping("blog")
@Controller
public class ListController {

    @Resource
    private ICatalogService catalogService;
    @Resource
    private IBlogService blogService;

    @RequestMapping("list/{catalogId}")
    public String list(Model model, @PathVariable String catalogId, String page, String paseSize){
        PaginationBO<Blog> paginationBO = new PaginationBO<>();
        if(StringUtils.isEmpty(page) || StringUtils.isEmpty(paseSize)){
            paginationBO.setPage(0);
            paginationBO.setPageSize(10);
        }else{
            paginationBO.setPageSize(Integer.valueOf(paseSize));
            paginationBO.setPage(Integer.valueOf(page));
        }
        Catalog catalog = new Catalog();
        catalog.setCatalogId(catalogId);
        blogService.listBlogByCatalog(SessionUtils.getCurrentUser(), catalog, paginationBO);
        List<Catalog> catalogs = catalogService.findCatalogsByUser(SessionUtils.getCurrentUser());
        model.addAttribute("paginationBO",paginationBO);
        model.addAttribute("listcatalog",true);
        model.addAttribute("catalogList",catalogs);
        model.addAttribute("user", SessionUtils.getCurrentUser());
        model.addAttribute("catalogId",catalogId);
        return "list";
    }

    @RequestMapping("del/{blogId}")
    @ResponseBody
    public String delItem(@PathVariable String blogId){
        if(StringUtils.isEmpty(blogId))
            return "error";
        blogService.delById(blogId);
        return "success";
    }

    @RequestMapping("nextYe/{catalogId}/{page}/{pageSize}")
    public String nextYe(Model model, @PathVariable String catalogId,@PathVariable String page, @PathVariable String pageSize){
        Catalog catalog = new Catalog();
        catalog.setCatalogId(catalogId);
        PaginationBO<Blog> paginationBO = new PaginationBO<>();
        paginationBO.setPage(Integer.valueOf(page));
        paginationBO.setPageSize(Integer.valueOf(pageSize));
        blogService.listBlogByCatalog(SessionUtils.getCurrentUser(),catalog,paginationBO);
        List<Catalog> catalogs = catalogService.findCatalogsByUser(SessionUtils.getCurrentUser());
        model.addAttribute("paginationBO",paginationBO);
        model.addAttribute("listcatalog",true);
        model.addAttribute("catalogList",catalogs);
        model.addAttribute("user", SessionUtils.getCurrentUser());
        model.addAttribute("catalogId",catalogId);
        return "list";
    }

    @RequestMapping("beforeYe/{catalogId}/{page}/{pageSize}")
    public String beforeYe(Model model, @PathVariable String catalogId,@PathVariable String page, @PathVariable String pageSize){
        Catalog catalog = new Catalog();
        catalog.setCatalogId(catalogId);
        PaginationBO<Blog> paginationBO = new PaginationBO<>();
        paginationBO.setPage(Integer.valueOf(page) - 1);
        paginationBO.setPageSize(Integer.valueOf(pageSize));
        blogService.listBlogByCatalog(SessionUtils.getCurrentUser(),catalog,paginationBO);
        List<Catalog> catalogs = catalogService.findCatalogsByUser(SessionUtils.getCurrentUser());
        model.addAttribute("paginationBO",paginationBO);
        model.addAttribute("listcatalog",true);
        model.addAttribute("catalogList",catalogs);
        model.addAttribute("user", SessionUtils.getCurrentUser());
        model.addAttribute("catalogId",catalogId);
        return "list";
    }

}
