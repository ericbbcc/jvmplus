package com.jvmplus.builder;

import com.jvmplus.bo.BlogEditorBO;
import com.jvmplus.vo.Blog;
import com.jvmplus.vo.Catalog;
import com.jvmplus.vo.User;

/**
 * Created by andy on 2/22/15.
 */
public class BlogEditorBOBuilder {
    private Blog blog;
    private Catalog catalog;
    private User user;

    public static BlogEditorBOBuilder me(){
        return new BlogEditorBOBuilder();
    }

    public BlogEditorBOBuilder setBlog(Blog blog){
        this.blog = blog;
        return this;
    }

    public BlogEditorBOBuilder setCatalog(Catalog catalog){
        this.catalog = catalog;
        return this;
    }

    public BlogEditorBOBuilder setUser(User user){
        this.user = user;
        return this;
    }

    public BlogEditorBO build(){
        BlogEditorBO blogEditorBO = new BlogEditorBO();
        blogEditorBO.setCatalog(catalog);
        blogEditorBO.setBlog(blog);
        blogEditorBO.setUser(user);
        return blogEditorBO;
    }
}
