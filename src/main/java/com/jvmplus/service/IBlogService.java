package com.jvmplus.service;

import com.jvmplus.bo.BlogEditorBO;
import com.jvmplus.vo.Blog;

/**
 * Created by andy on 2/22/15.
 */
public interface IBlogService {
    public void saveBlogEditorBO(BlogEditorBO blogEditorBO);
    public Blog findTheLastOne();
}
