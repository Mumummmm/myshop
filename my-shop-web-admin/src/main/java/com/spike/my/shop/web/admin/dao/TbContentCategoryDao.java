package com.spike.my.shop.web.admin.dao;

import com.spike.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao {
    List<TbContentCategory> selectAll();
    TbContentCategory getById(Long id);
    List<TbContentCategory> selectByPid(Long id);
}
