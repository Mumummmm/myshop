package com.spike.my.shop.web.admin.service.impl;

import com.spike.my.shop.commons.dto.BaseResult;
import com.spike.my.shop.commons.utils.RegexpUtils;
import com.spike.my.shop.commons.validator.BeanValidator;
import com.spike.my.shop.domain.TbUser;
import com.spike.my.shop.web.admin.dao.TbUserDao;
import com.spike.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbUserServiceImpl implements TbUserService {
    private final TbUserDao tbUserDao;

    public TbUserServiceImpl(TbUserDao tbUserDao) {
        this.tbUserDao = tbUserDao;
    }

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser != null) {
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        else {
            tbUser.setUpdated(new Date());
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));

            if (tbUser.getId() == null) {
                tbUser.setCreated(new Date());
                tbUserDao.insertTbUser(tbUser);
            }
            else {
                tbUserDao.update(tbUser);
            }
        }

        return BaseResult.success("保存用户信息成功");
    }

    @Override
    public TbUser getTbUser(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void delete(String[] idArray) {
        tbUserDao.delete(idArray);
    }

    @Override
    public List<TbUser> page(Integer start, Integer length, TbUser tbUser) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("start", start);
        params.put("length", length);
        params.put("tbUser", tbUser);
        return tbUserDao.page(params);
    }

    @Override
    public Integer count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }
}
