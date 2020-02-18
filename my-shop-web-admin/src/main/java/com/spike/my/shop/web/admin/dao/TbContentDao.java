package com.spike.my.shop.web.admin.dao;

import com.spike.my.shop.domain.TbContent;
import com.spike.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbContentDao {
    List<TbContent> selectAll();

    void insertTbContent(TbContent tbContent);

    void update(TbContent tbContent);

    TbContent getById(Long id);

    void delete(String[] idArray);

    List<TbContent> page(Map<String, Object> params);

    Integer count(TbContent tbContent);
}
