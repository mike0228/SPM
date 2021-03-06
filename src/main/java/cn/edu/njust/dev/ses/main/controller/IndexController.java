package cn.edu.njust.dev.ses.main.controller;


import cn.edu.njust.dev.ses.main.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping("/")
    public String processIndex(HttpSession userSession){
        User sessionUser = (User) userSession.getAttribute("logged_in_as");//获取登陆用户信息
        if(sessionUser != null){
            String type = sessionUser.getType();//根据用户类型返回不同的主页面
            if(type.equals("student")) return "redirect:/student/main";
            if(type.equals("associate")) return "redirect:/associate/main";
            if(type.equals("teacher")) return "redirect:/teacher/admin";
        }
        return "login";
    }
}
