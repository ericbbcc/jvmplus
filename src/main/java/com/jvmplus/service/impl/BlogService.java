package com.jvmplus.service.impl;

import com.jvmplus.bo.BlogEditorBO;
import com.jvmplus.dao.BlogMapper;
import com.jvmplus.service.IBlogService;
import com.jvmplus.util.IDgenerator;
import com.jvmplus.util.SessionUtils;
import com.jvmplus.vo.Blog;
import com.jvmplus.vo.BlogExample;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
        if(!StringUtils.hasText(blogEditorBO.getBlog().getBlogId())){
            blogEditorBO.getBlog().setBlogId(IDgenerator.blogId());
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
        List<Blog> blogList = blogMapper.selectByExample(example);
        if(blogList.size() == 0)
            blogList.add(new Blog());
        return blogMapper.selectByPrimaryKey(blogList.get(0).getBlogId());
    }

    @Override
    public Blog findById(String id) {
        return blogMapper.selectByPrimaryKey(id);
    }
}
