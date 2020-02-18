package com.spike.my.shop.web.admin.dao;

import com.spike.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao {
    List<TbUser> selectAll();

    TbUser getByEmail(String email);

    void insertTbUser(TbUser tbUser);

    void update(TbUser tbUser);

    TbUser getById(Long id);

    void delete(String[] idArray);

    List<TbUser> page(Map<String, Object> params);

    Integer count(TbUser tbUser);
}
