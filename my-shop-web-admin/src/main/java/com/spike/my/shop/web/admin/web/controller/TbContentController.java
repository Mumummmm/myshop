package com.spike.my.shop.web.admin.web.controller;

import com.spike.my.shop.commons.constants.ConstantUtils;
import com.spike.my.shop.commons.dto.BaseResult;
import com.spike.my.shop.commons.dto.PageInfo;
import com.spike.my.shop.domain.TbContent;
import com.spike.my.shop.domain.TbUser;
import com.spike.my.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "content")
public class TbContentController {

    private final TbContentService tbContentService;

    public TbContentController(TbContentService tbContentService) {
        this.tbContentService = tbContentService;
    }

    @ModelAttribute
    public TbContent get(Long id) {
        TbContent tbContent;
        if (id != null) {
            tbContent = tbContentService.getTbContent(id);
        }
        else {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "content_list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String userForm(TbContent tbContent, Model model) {
        model.addAttribute(ConstantUtils.SESSION_CONTENT, tbContent);
        return "content_form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbContentService.save(tbContent);
        if (baseResult.getStatus() == BaseResult.STATUS_FAIL) {
            model.addAttribute(ConstantUtils.BASE_RESULT, baseResult);
            return "user_form";
        }

        redirectAttributes.addFlashAttribute(ConstantUtils.BASE_RESULT, baseResult);
        return "redirect:/content/list";
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult;
        if (ids != null) {
            String[] idArray = ids.split(",");
            tbContentService.delete(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        else {
            baseResult = BaseResult.fail();
        }

        return baseResult;
    }

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest httpServletRequest, TbContent tbContent) {
        String strDraw = httpServletRequest.getParameter("draw");
        String strStart = httpServletRequest.getParameter("start");
        String strLength = httpServletRequest.getParameter("length");

        Integer draw = Integer.parseInt(strDraw);
        Integer start = Integer.parseInt(strStart);
        Integer length = Integer.parseInt(strLength);

        List<TbContent> tbContents = tbContentService.page(start, length, tbContent);
        Integer count = tbContentService.count(tbContent);
        PageInfo<TbContent> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbContents);
        pageInfo.setError("");

        return pageInfo;
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String userDetail(TbContent tbContent) {
        return "user_detail";
    }
}
