package cn.edu.njust.dev.ses.main.controller;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.dto.api.LoginCredentialsDTO;
import cn.edu.njust.dev.ses.main.dto.api.LoginResponseDTO;
import cn.edu.njust.dev.ses.main.mapper.UserMapper;
import cn.edu.njust.dev.ses.main.model.User;
import cn.edu.njust.dev.ses.main.service.AccountManagementService;
import cn.edu.njust.dev.ses.main.service.AccountService;
import cn.edu.njust.dev.ses.main.util.Utils;
import org.jetbrains.annotations.TestOnly;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("rawtypes")
@Controller
public class UserSessionController {
    final private AccountService accountService;
    final private AccountManagementService accountManagementService;
    final private UserMapper userMapper;

    public UserSessionController(AccountService accountService, AccountManagementService accountManagementService, UserMapper userMapper) {
        this.accountService = accountService;
        this.accountManagementService = accountManagementService;
        this.userMapper = userMapper;
    }

    @GetMapping("/test/testAJAX")
    @TestOnly
    public String testLogin(){
        return "test-ajax";
    }

    @PostMapping("/api/json/login")
    @ResponseBody
    @CrossOrigin
    public ResultDTO<?> doLogin(@RequestBody LoginCredentialsDTO credentialsDTO, HttpSession session, HttpServletResponse response){
        if(session.getAttribute("logged_in_as") != null){
            return ResultDTO.errorOf(0, "你已经登录，刷新首页来继续。");
        }
        if(StringUtils.isBlank(credentialsDTO.getLogin())){
            return ResultDTO.errorOf(0, "No username.");
        }
        if(StringUtils.isBlank(credentialsDTO.getPassword())){
            return ResultDTO.errorOf(0, "No password.");
        }
        User pendingUser = new User();
        pendingUser.setPassword(credentialsDTO.getPassword());
        pendingUser.setAccount(credentialsDTO.getLogin());
        boolean loggedIn = accountService.logInAs(session, pendingUser);
        if(loggedIn){
            User loggedInUser = (User) session.getAttribute("logged_in_as");
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
            switch (loggedInUser.getType()) {
                case "student":
                    loginResponseDTO.setNext("/student/main");
                    break;
                case "teacher":
                    loginResponseDTO.setNext("/teacher/admin");
                    break;
                case "associate":
                    loginResponseDTO.setNext("/associate/main");
            }
            if(credentialsDTO.getRememberMe() != null && credentialsDTO.getRememberMe().equals("on"))
                accountManagementService.logInAsRememberme(response, session);
            return ResultDTO.okOf(loginResponseDTO);
        }
        return ResultDTO.errorOf(0, "登录名或密码错误。");
    }

    @RequestMapping("/api/logout")
    @CrossOrigin
    public String doLogOut(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("logged_in_as") == null){
            return "redirect:/";
        }
        accountManagementService.logoutAndInvalidateSession(request, response);
        return "redirect:/";
    }

    @RequestMapping("/api/json/change_password")
    @ResponseBody
    @CrossOrigin
    public ResultDTO changePassword(HttpServletRequest request, HttpServletResponse response, @RequestParam String password, @RequestParam String oldPassword){
        User loggedInAs = (User) request.getSession().getAttribute("logged_in_as");
        if(loggedInAs == null){
            return ResultDTO.errorOf(0, "登录失效，请重新登录。");
        }
        if(!Utils.isValidPwd(password)) {
            return ResultDTO.errorOf(0, "新密码无效。");
        }
        User targetInDatabase = userMapper.selectByPrimaryKey(loggedInAs.getUid());
        if(targetInDatabase == null) return ResultDTO.errorOf(0, "错误，请重新登录");
        if(!targetInDatabase.getPassword().equals(oldPassword))
            return ResultDTO.errorOf(0, "旧密码错误。");
        targetInDatabase.setPassword(password);
        userMapper.updateByPrimaryKey(targetInDatabase);
        return ResultDTO.okOf();
    }


}
