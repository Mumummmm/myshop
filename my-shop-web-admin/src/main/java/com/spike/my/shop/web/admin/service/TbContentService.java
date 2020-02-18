package com.spike.my.shop.web.admin.service;

import com.spike.my.shop.commons.dto.BaseResult;
import com.spike.my.shop.domain.TbContent;
import com.spike.my.shop.domain.TbUser;

import java.util.List;

public interface TbContentService {
    List<TbContent> selectAll();
    BaseResult save(TbContent tbContent);
    TbContent getTbContent(Long id);
    void delete(String[] idArray);
    List<TbContent> page(Integer start, Integer length, TbContent tbContent);
    Integer count(TbContent tbContent);
}
