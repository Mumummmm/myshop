package com.spike.my.shop.web.admin.service.impl;

import com.spike.my.shop.commons.dto.BaseResult;
import com.spike.my.shop.commons.utils.RegexpUtils;
import com.spike.my.shop.domain.TbUser;
import com.spike.my.shop.web.admin.dao.TbUserDao;
import com.spike.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

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
        BaseResult baseResult = checkTbUser(tbUser);
        tbUser.setUpdated(new Date());
        tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));

        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            if (tbUser.getId() == null) {
                tbUser.setCreated(new Date());
                tbUserDao.insertTbUser(tbUser);
                baseResult.setMessage("新增成功");
            }
            else {
                tbUserDao.update(tbUser);
                baseResult.setMessage("保存成功");
            }
        }

        return baseResult;
    }

    private BaseResult checkTbUser(TbUser tbUser) {
        BaseResult baseResult = BaseResult.success();

        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空");
            return baseResult;
        }
        if (RegexpUtils.checkEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式不对");
            return baseResult;
        }
        if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空");
            return baseResult;
        }
        if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空");
            return baseResult;
        }
        if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机不能为空");
            return baseResult;
        }
        if (RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机格式不对");
            return baseResult;
        }

        return baseResult;
    }
}
