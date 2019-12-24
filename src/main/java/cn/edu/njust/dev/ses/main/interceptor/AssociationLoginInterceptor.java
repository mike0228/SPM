package cn.edu.njust.dev.ses.main.interceptor;

import cn.edu.njust.dev.ses.main.model.Student;
import cn.edu.njust.dev.ses.main.model.User;
import com.sun.nio.sctp.Association;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AssociationLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User sessionUser = (User)request.getSession().getAttribute("logged_in_as");
        if(sessionUser == null|| !sessionUser.getType().equals("associate")){
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        else{
            return true;
        }
    }
}
