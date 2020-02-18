package com.spike.my.shop.web.admin.service.impl;

import com.spike.my.shop.commons.dto.BaseResult;
import com.spike.my.shop.commons.utils.RegexpUtils;
import com.spike.my.shop.domain.TbContent;
import com.spike.my.shop.domain.TbUser;
import com.spike.my.shop.web.admin.dao.TbContentDao;
import com.spike.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbContentServiceImpl implements TbContentService {

    private final TbContentDao tbContentDao;

    public TbContentServiceImpl(TbContentDao tbContentDao) {
        this.tbContentDao = tbContentDao;
    }

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        BaseResult baseResult = checkTbContent(tbContent);

        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbContent.setUpdated(new Date());

            if (tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                tbContentDao.insertTbContent(tbContent);
                baseResult.setMessage("新增成功");
            }
            else {
                tbContentDao.update(tbContent);
                baseResult.setMessage("保存成功");
            }
        }

        return baseResult;
    }

    @Override
    public TbContent getTbContent(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void delete(String[] idArray) {
        tbContentDao.delete(idArray);
    }

    @Override
    public List<TbContent> page(Integer start, Integer length, TbContent tbContent) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("start", start);
        params.put("length", length);
        params.put("tbContent", tbContent);
        return tbContentDao.page(params);
    }

    @Override
    public Integer count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }

    private BaseResult checkTbContent(TbContent tbContent) {
        BaseResult baseResult = BaseResult.success();

        if (StringUtils.isBlank(tbContent.getTitle())) {
            baseResult = BaseResult.fail("标题不能为空");
            return baseResult;
        }
        if (!RegexpUtils.checkEmail(tbContent.getSubTitle())) {
            baseResult = BaseResult.fail("子标题不能为空");
            return baseResult;
        }
        if (StringUtils.isBlank(tbContent.getTitleDesc())) {
            baseResult = BaseResult.fail("标题简介不能为空");
            return baseResult;
        }
        if (StringUtils.isBlank(tbContent.getUrl())) {
            baseResult = BaseResult.fail("url不能为空");
            return baseResult;
        }
        if (StringUtils.isBlank(tbContent.getPic())) {
            baseResult = BaseResult.fail("图片1不能为空");
            return baseResult;
        }
        if (!RegexpUtils.checkPhone(tbContent.getPic2())) {
            baseResult = BaseResult.fail("图片2不能为空");
            return baseResult;
        }
        if (!RegexpUtils.checkPhone(tbContent.getContent())) {
            baseResult = BaseResult.fail("内容不能为空");
            return baseResult;
        }

        return baseResult;
    }
}
