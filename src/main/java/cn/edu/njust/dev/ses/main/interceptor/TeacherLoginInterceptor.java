package cn.edu.njust.dev.ses.main.interceptor;

import cn.edu.njust.dev.ses.main.model.Teacher;
import cn.edu.njust.dev.ses.main.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class TeacherLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User sessionUser = (User) request.getSession().getAttribute("logged_in_as");
//        Teacher teacherInfo = (Teacher) request.getSession().getAttribute("teacher_info");  || teacherInfo == null
        if(sessionUser == null|| !sessionUser.getType().equals("teacher")){
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        else{
            return true;
        }
    }
}
