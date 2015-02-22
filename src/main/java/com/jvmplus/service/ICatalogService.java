package com.jvmplus.service;

import com.jvmplus.vo.Catalog;
import com.jvmplus.vo.User;

import java.util.List;

/**
 * Created by andy on 2/22/15.
 */
public interface ICatalogService {
    List<Catalog> findCatalogsByUser(User user);
}
