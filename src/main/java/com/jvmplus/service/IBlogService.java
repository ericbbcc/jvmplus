package com.jvmplus.service;

import com.jvmplus.bo.BlogEditorBO;
import com.jvmplus.bo.PaginationBO;
import com.jvmplus.vo.Blog;
import com.jvmplus.vo.Catalog;
import com.jvmplus.vo.User;

import java.util.List;

/**
 * Created by andy on 2/22/15.
 */
public interface IBlogService {
    public void saveBlogEditorBO(BlogEditorBO blogEditorBO);
    public Blog findTheLastOne();
    public Blog findById(String id);
    public PaginationBO<Blog> listBlogByCatalog(User user, Catalog catalog, PaginationBO<Blog> paginationBO);
    public void delById(String blogId);
    public Blog nextBlog(User user, String blogId);
    public Blog beforeBlog(User user, String blogId);
}
