package com.spike.my.shop.web.admin.web.controller;

import com.spike.my.shop.commons.constants.ConstantUtils;
import com.spike.my.shop.domain.TbUser;
import com.spike.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private final TbUserService tbUserService;

    public LoginController(TbUserService tbUserService) {
        this.tbUserService = tbUserService;
    }

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest, Model model) {
        TbUser tbUser = tbUserService.login(email, password);

        if (tbUser == null) {
            model.addAttribute("message", "用户名或密码错误，请重新输入");
            return "login";
        }
        else {
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:/main";
        }
    }
}
