package cn.edu.njust.dev.ses.main.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

public class SessionCollectionListener implements HttpSessionListener {
    private static final List<HttpSession> sessionList = new ArrayList<>();

    @Override
    public void sessionCreated(HttpSessionEvent se){
        sessionList.add(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se){
        sessionList.remove(se.getSession());
    }

    public static List<HttpSession> getList(){
        return sessionList;
    }
}
