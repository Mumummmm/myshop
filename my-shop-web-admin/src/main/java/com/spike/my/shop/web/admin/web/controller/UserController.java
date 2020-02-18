package com.spike.my.shop.web.admin.web.controller;

import com.spike.my.shop.commons.constants.ConstantUtils;
import com.spike.my.shop.commons.dto.BaseResult;
import com.spike.my.shop.commons.dto.PageInfo;
import com.spike.my.shop.domain.TbUser;
import com.spike.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {


    private final TbUserService tbUserService;

    public UserController(TbUserService tbUserService) {
        this.tbUserService = tbUserService;
    }

    @ModelAttribute
    public TbUser get(Long id) {
        TbUser tbUser;
        if (id != null) {
            tbUser = tbUserService.getTbUser(id);
        }
        else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user_list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String userForm(TbUser tbUser, Model model) {
        model.addAttribute(ConstantUtils.SESSION_USER, tbUser);
        return "user_form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbUserService.save(tbUser);
        if (baseResult.getStatus() == BaseResult.STATUS_FAIL) {
            model.addAttribute(ConstantUtils.BASE_RESULT, baseResult);
            return "user_form";
        }

        redirectAttributes.addFlashAttribute(ConstantUtils.BASE_RESULT, baseResult);
        return "redirect:/user/list";
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult;
        if (ids != null) {
            String[] idArray = ids.split(",");
            tbUserService.delete(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        else {
            baseResult = BaseResult.fail();
        }

        return baseResult;
    }

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest httpServletRequest, TbUser tbUser) {
        String strDraw = httpServletRequest.getParameter("draw");
        String strStart = httpServletRequest.getParameter("start");
        String strLength = httpServletRequest.getParameter("length");

        Integer draw = Integer.parseInt(strDraw);
        Integer start = Integer.parseInt(strStart);
        Integer length = Integer.parseInt(strLength);

        List<TbUser> tbUsers = tbUserService.page(start, length, tbUser);
        Integer count = tbUserService.count(tbUser);
        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbUsers);
        pageInfo.setError("");

        return pageInfo;
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String userDetail(TbUser tbUser) {
        return "user_detail";
    }
}
