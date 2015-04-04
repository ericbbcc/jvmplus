package com.jvmplus.service.impl;

import com.jvmplus.bo.BlogEditorBO;
import com.jvmplus.bo.PaginationBO;
import com.jvmplus.dao.BlogMapper;
import com.jvmplus.service.IBlogService;
import com.jvmplus.util.IDgenerator;
import com.jvmplus.util.SessionUtils;
import com.jvmplus.vo.Blog;
import com.jvmplus.vo.BlogExample;
import com.jvmplus.vo.Catalog;
import com.jvmplus.vo.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by andy on 2/22/15.
 */
@Component
public class BlogService implements IBlogService {

    @Resource(name="blogDao")
    private BlogMapper blogMapper;
    @Override
    public void saveBlogEditorBO(BlogEditorBO blogEditorBO) {
        Assert.notNull(blogEditorBO.getBlog(), "blog must not be null.");
        completeBlogInfo(blogEditorBO);
        blogMapper.insert(blogEditorBO.getBlog());
    }


    private void completeBlogInfo(BlogEditorBO blogEditorBO){
        if(!StringUtils.hasText(blogEditorBO.getBlog().getUserId())){
            blogEditorBO.getBlog().setUserId(blogEditorBO.getUser().getUserId());
        }
        if(null == blogEditorBO.getBlog().getCreateDate()){
            blogEditorBO.getBlog().setCreateDate(new Date());
        }
        if(!StringUtils.hasText(blogEditorBO.getBlog().getCatalogId()))
            blogEditorBO.getBlog().setUserId(blogEditorBO.getCatalog().getCatalogId());
    }

    @Override
    public Blog findTheLastOne() {
        BlogExample example = new BlogExample();
        example.createCriteria().andUserIdEqualTo(SessionUtils.getCurrentUser().getUserId());
        example.setOrderByClause("create_date desc");
        example.setLimitStart(0);
        example.setLimitEnd(1);
        List<Blog> blogs = blogMapper.selectByExampleWithBLOBs(example);
        return blogs.size() > 0 ? blogs.get(0) : new Blog();
    }

    @Override
    public Blog findById(String id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PaginationBO<Blog> listBlogByCatalog(User user, Catalog catalog, PaginationBO<Blog> paginationBO) {
        Assert.notNull(paginationBO, "paginationBO must not be null.");
        Assert.state(paginationBO.getPage() >= 0, "page must be right.");
        Assert.state(paginationBO.getPageSize() > 0, "pageSize must be right.");
        BlogExample example = new BlogExample();
        example.setLimitStart((paginationBO.getPage() -1) * paginationBO.getPage() - 1);
        example.setLimitEnd(paginationBO.getPageSize());
        example.createCriteria()
                .andUserIdEqualTo(user.getUserId())
                .andCatalogIdEqualTo(catalog.getCatalogId());
        List<Blog> blogs = blogMapper.selectByExampleWithBLOBs(example);
        paginationBO.setDataList(blogs);
        paginationBO.setTotal((blogs.size() / paginationBO.getPageSize()) + 1);
        return paginationBO;
    }

    @Override
    public void delById(String blogId) {
        blogMapper.deleteByPrimaryKey(blogId);
    }

    @Override
    public Blog nextBlog(User user, String blogId) {
        BlogExample example = new BlogExample();
        example.createCriteria().andUserIdEqualTo(user.getUserId());
        List<Blog> blogs = blogMapper.selectByExample(example);
        if(blogs.size() < 1)
            return null;
        Iterator<Blog> blogIterator = blogs.iterator();
        while (blogIterator.hasNext()){
            if(blogIterator.next().getBlogId().equals(blogId))
                break;
        }
        if(blogIterator.hasNext())
            return blogIterator.next();
        else
            return blogs.get(0);
    }


    @Override
    public Blog beforeBlog(User user, String blogId) {
        BlogExample example = new BlogExample();
        example.createCriteria().andUserIdEqualTo(user.getUserId());
        List<Blog> blogs = blogMapper.selectByExample(example);
        Collections.reverse(blogs);
        if(blogs.size() < 1)
            return null;
        Iterator<Blog> blogIterator = blogs.iterator();
        while (blogIterator.hasNext()){
            if(blogIterator.next().getBlogId().equals(blogId))
                break;
        }
        if(blogIterator.hasNext())
            return blogIterator.next();
        else
            return blogs.get(0);
    }
}
