package com.spike.my.shop.web.admin.service;

import com.spike.my.shop.commons.dto.BaseResult;
import com.spike.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {
    List<TbUser> selectAll();
    TbUser login(String email, String password);
    BaseResult save(TbUser tbUser);
    TbUser getTbUser(Long id);
    void delete(String[] idArray);
    List<TbUser> page(Integer start, Integer length, TbUser tbUser);
    Integer count(TbUser tbUser);
}
