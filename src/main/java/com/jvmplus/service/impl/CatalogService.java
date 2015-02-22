package com.jvmplus.service.impl;

import com.jvmplus.dao.CatalogMapper;
import com.jvmplus.service.ICatalogService;
import com.jvmplus.vo.Catalog;
import com.jvmplus.vo.CatalogExample;
import com.jvmplus.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by andy on 2/22/15.
 */
@Component
public class CatalogService implements ICatalogService {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogService.class);

    @Resource(name="calalogDao")
    private CatalogMapper catalogMapper;
    @Override
    public List<Catalog> findCatalogsByUser(User user) {
        String userId = user.getUserId();
        Assert.hasText(userId,"userId must not be null!");
        CatalogExample example = new CatalogExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return catalogMapper.selectByExample(example);
    }
}
