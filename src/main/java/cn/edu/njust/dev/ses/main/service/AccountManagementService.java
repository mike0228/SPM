package cn.edu.njust.dev.ses.main.service;

import cn.edu.njust.dev.ses.main.listener.SessionCollectionListener;
import cn.edu.njust.dev.ses.main.mapper.StudentMapper;
import cn.edu.njust.dev.ses.main.mapper.TeacherMapper;
import cn.edu.njust.dev.ses.main.mapper.UserMapper;
import cn.edu.njust.dev.ses.main.model.*;
import cn.edu.njust.dev.ses.main.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.*;
import java.security.SecureRandom;
import java.util.Date;

@Service
final public class AccountManagementService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;


    public void quickValidate(HttpServletRequest requestSession){
        Cookie[] cookies = requestSession.getCookies();
        String token = null;
        if(cookies == null) return;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("user_token")){
                token = cookie.getValue();
                break;
            }
        }
        if(token != null){
            requestSession.getSession().setAttribute("logged_in_as", accountService.getUidByToken(token));

        }
    }

    public void logInAsRememberme(HttpServletResponse response, HttpSession session){
        User loggedInUser = (User) session.getAttribute("logged_in_as");
        if(loggedInUser == null)
            return;
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        Cookie tokenCookie = new Cookie("user_token", token);
        tokenCookie.setMaxAge(60 * 60 * 24 * 15);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);
        UserSession userSession = new UserSession();
        userSession.setToken(token);
        userSession.setUid(loggedInUser.getUid());
        userSession.setExpires(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 15 * 1000));
        accountService.registerToken(userSession);
    }

    public void logoutAndInvalidateSession(HttpServletRequest requestSession, HttpServletResponse response){

        Cookie[] cookies = requestSession.getCookies();
        String token = null;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("user_token")){
                token = cookie.getValue();
                break;
            }
        }
        if(token!=null){
            accountService.invalidateToken(token);

            Cookie removeCookie = new Cookie("user_token", null);
            removeCookie.setMaxAge(0);
            removeCookie.setPath("/");
            response.addCookie(removeCookie);
        }

        requestSession.getSession().removeAttribute("logged_in_as");
        requestSession.getSession().removeAttribute("teacher_info");
        requestSession.getSession().removeAttribute("student_info");
    }

    public void updateAllSessionsForUser(Integer uid){
        User user = userMapper.selectByPrimaryKey(uid);
        if(user == null)
            throw new IllegalArgumentException("Non-existent user id provided.");
        for(HttpSession session: SessionCollectionListener.getList()){
            User logged_in_as = (User) session.getAttribute("logged_in_as");
            if(logged_in_as != null&& logged_in_as.getUid().equals(user.getUid())){
                session.setAttribute("logged_in_as", user);
                if(logged_in_as.getType().equals("student")){
                    StudentExample studentExample = new StudentExample();
                    studentExample.createCriteria().andUidEqualTo(logged_in_as.getUid());
                    session.setAttribute("student_info", studentMapper.selectByExample(studentExample));
                }else if(logged_in_as.getType().equals("teacher")){
                    TeacherExample teacherExample = new TeacherExample();
                    teacherExample.createCriteria().andUidEqualTo(logged_in_as.getUid());
                    session.setAttribute("teacher_info", teacherMapper.selectByExample(teacherExample));
                }
            }

        }
    }
    public void logoutUserFromAllSessions(Integer uid){
        if(uid == null) return;
        for(HttpSession session: SessionCollectionListener.getList()){
            User logged_in_as = (User) session.getAttribute("logged_in_as");
            if(logged_in_as != null&& logged_in_as.getUid().equals(uid)){
                session.removeAttribute("logged_in_as");
            }
        }
    }
}
