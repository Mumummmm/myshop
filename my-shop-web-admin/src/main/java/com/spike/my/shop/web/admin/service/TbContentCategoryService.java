package com.spike.my.shop.web.admin.service;

import com.spike.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService {
    List<TbContentCategory> selectAll();
    TbContentCategory getById(Long id);
    List<TbContentCategory> selectByPid(Long id);
}
