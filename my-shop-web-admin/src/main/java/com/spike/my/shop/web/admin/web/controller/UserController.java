package com.spike.my.shop.web.admin.web.controller;

import com.spike.my.shop.commons.constants.ConstantUtils;
import com.spike.my.shop.commons.dto.BaseResult;
import com.spike.my.shop.domain.TbUser;
import com.spike.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private final TbUserService tbUserService;

    public UserController(TbUserService tbUserService) {
        this.tbUserService = tbUserService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);

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
            model.addAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "user_form";
        }

        redirectAttributes.addFlashAttribute(ConstantUtils.BASE_RESULT, baseResult);
        return "redirect:/user/list";
    }
}
