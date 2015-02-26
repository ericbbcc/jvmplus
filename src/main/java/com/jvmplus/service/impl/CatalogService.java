package com.jvmplus.service.impl;

import com.jvmplus.dao.CatalogMapper;
import com.jvmplus.service.ICatalogService;
import com.jvmplus.util.IDgenerator;
import com.jvmplus.util.SessionUtils;
import com.jvmplus.vo.Catalog;
import com.jvmplus.vo.CatalogExample;
import com.jvmplus.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by andy on 2/22/15.
 */
@Component
public class CatalogService implements ICatalogService {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogService.class);

    @Resource(name="catalogDao")
    private CatalogMapper catalogMapper;
    @Override
    public List<Catalog> findCatalogsByUser(User user) {
        String userId = user.getUserId();
        Assert.hasText(userId,"userId must not be null!");
        CatalogExample example = new CatalogExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return catalogMapper.selectByExample(example);
    }

    @Override
    public void saveCatalog(String name) {
        Catalog catalog = new Catalog();
        catalog.setCatalogId(IDgenerator.catalogId());
        catalog.setCatalogName(name);
        catalog.setCreateDate(new Date());
        catalog.setUserId(SessionUtils.getCurrentUser().getUserId());
        catalogMapper.insert(catalog);
    }
}
