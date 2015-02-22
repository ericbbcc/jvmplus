package com.jvmplus.bo;

import com.jvmplus.vo.Blog;
import com.jvmplus.vo.Catalog;
import com.jvmplus.vo.User;

import java.util.List;

/**
 * Created by andy on 2/22/15.
 */
public class BlogDetailBO {
    private Blog blog;
    private List<Catalog> catalogList;
    private User user;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Catalog> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
