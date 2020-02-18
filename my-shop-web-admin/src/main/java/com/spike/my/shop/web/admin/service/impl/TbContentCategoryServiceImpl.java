package com.spike.my.shop.web.admin.service.impl;

import com.spike.my.shop.domain.TbContentCategory;
import com.spike.my.shop.web.admin.dao.TbContentCategoryDao;
import com.spike.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    private final TbContentCategoryDao tbContentCategoryDao;

    public TbContentCategoryServiceImpl(TbContentCategoryDao tbContentCategoryDao) {
        this.tbContentCategoryDao = tbContentCategoryDao;
    }

    @Override
    public List<TbContentCategory> selectAll() {
        List<TbContentCategory> tbContentCategories = tbContentCategoryDao.selectAll();
        List<TbContentCategory> targetList = new ArrayList<>();
        sort(tbContentCategories, targetList, 0L);
        return targetList;
    }

    @Override
    public TbContentCategory getById(Long id) {
        return tbContentCategoryDao.getById(id);
    }

    @Override
    public List<TbContentCategory> selectByPid(Long id) {
        return tbContentCategoryDao.selectByPid(id);
    }

    private void sort(List<TbContentCategory> sourceList, List<TbContentCategory> targetList, Long parentId) {
        for (TbContentCategory tbContentCategory : sourceList) {
            if (parentId.equals(tbContentCategory.getParentId())) {
                targetList.add(tbContentCategory);
                if (tbContentCategory.getIsParent()) {
                    sort(sourceList, targetList, tbContentCategory.getId());
                }
            }
        }
    }
}
