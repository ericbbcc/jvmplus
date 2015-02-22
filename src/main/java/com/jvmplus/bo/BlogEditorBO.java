package com.jvmplus.bo;

import com.jvmplus.vo.Blog;
import com.jvmplus.vo.Catalog;
import com.jvmplus.vo.User;

/**
 * Created by andy on 2/22/15.
 */
public class BlogEditorBO {
    private Blog blog;
    private Catalog catalog;
    private User user;

    public void setBlog(Blog blog){
        this.blog = blog;
    }

    public void setCatalog(Catalog catalog){
        this.catalog = catalog;
    }
    public void setUser(User user){
        this.user = user;
    }

    public Blog getBlog(){
        return blog;
    }
    public Catalog getCatalog(){
        return catalog;
    }
    public User getUser(){
        return user;
    }
}
