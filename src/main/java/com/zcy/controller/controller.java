package com.zcy.controller;

import com.zcy.domain.User;
import com.zcy.service.IaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
* web层  账户控制器
*
* */
@Controller
@RequestMapping(path = "/account")
public class controller {
    @Autowired
    private IaccountService accountService;

    @RequestMapping(path = "/findall")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户");
        //调用service中的方法
        List<User> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping(path = "/save")
    public void saveAccount(User user,HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层：保存账户");
        accountService.saveAccount(user);
        response.sendRedirect(request.getContextPath()+"/user/findAll");//定向到上面的方法   查询所有  name



        return;
    }
}
