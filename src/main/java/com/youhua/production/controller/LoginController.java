package com.youhua.production.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class LoginController {


    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        String result;
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", username);
            result = "redirect:/main.html";
        } else {
            //登陆失败
            map.put("msg", "用户名密码错误");
            result = "login";
        }

        return result;
    }

    @GetMapping(value ="/logout")
    public String logout(HttpServletRequest request) {
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }

        return "login";
    }

}
