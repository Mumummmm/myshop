package com.spike.my.shop.web.admin.web.controller;

import com.spike.my.shop.domain.TbContentCategory;
import com.spike.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "content/category")
public class TbContentCategoryController {

    private final TbContentCategoryService tbContentCategoryService;

    public TbContentCategoryController(TbContentCategoryService tbContentCategoryService) {
        this.tbContentCategoryService = tbContentCategoryService;
    }

    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id) {
        TbContentCategory tbContentCategory = null;

        if (id != null) {
            tbContentCategory = tbContentCategoryService.getById(id);
        }
        else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> tbContentCategories = tbContentCategoryService.selectAll();
        model.addAttribute("tbContentCategories", tbContentCategories);
        return "content_category_list";
    }

    @RequestMapping(value = "tree/data", method = RequestMethod.POST)
    @ResponseBody
    public List<TbContentCategory> treeData(Long id) {
        if (id == null) {
            id = 0L;
        }

        return tbContentCategoryService.selectByPid(id);
    }
}
