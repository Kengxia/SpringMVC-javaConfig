package com.my.work.home.controller;

import com.my.framework.page.PageInfo;
import com.my.work.home.serive.IHomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 华安  mashuai_bj@si-tech.com.cn
 * @Title:
 * @Date: Create in 17:35 2018/7/18
 * @Description:
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Resource
    IHomeService homeService;

    @RequestMapping("/index")
    public String index(){
        return "home";
    }

    @RequestMapping(value="/pageList",method= RequestMethod.GET)
    @ResponseBody
    public Object pageList(HttpServletRequest request, HttpServletResponse response){
        int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        int pageSize = 5;
        if (currentPage <= 0) {
            currentPage = 1;
        }
        int currentResult = (currentPage - 1) * pageSize;
        PageInfo page = new PageInfo();
        page.setShowCount(pageSize);
        page.setCurrentResult(currentResult);
        return  homeService.pageList(page);
    }
} 