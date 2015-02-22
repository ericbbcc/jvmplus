package com.jvmplus.builder;

import com.jvmplus.bo.BlogDetailBO;
import com.jvmplus.vo.Blog;
import com.jvmplus.vo.Catalog;
import com.jvmplus.vo.User;

import java.util.List;

/**
 * Created by andy on 2/22/15.
 */
public class BlogDetailBOBuilder {
    private Blog blog;
    private List<Catalog> catalogList;
    private User user;

    public static BlogDetailBOBuilder me(){
        return new BlogDetailBOBuilder();
    }

    public Blog getBlog() {
        return blog;
    }

    public BlogDetailBOBuilder setBlog(Blog blog) {
        this.blog = blog;
        return this;
    }

    public List<Catalog> getCatalogList() {
        return catalogList;
    }

    public BlogDetailBOBuilder setCatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
        return this;
    }

    public User getUser() {
        return user;
    }

    public BlogDetailBOBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public BlogDetailBO build(){
        BlogDetailBO blogDetailBO = new BlogDetailBO();
        blogDetailBO.setBlog(blog);
        blogDetailBO.setCatalogList(catalogList);
        blogDetailBO.setUser(user);
        return blogDetailBO;
    }
}
