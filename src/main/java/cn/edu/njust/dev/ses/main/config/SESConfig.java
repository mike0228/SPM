package cn.edu.njust.dev.ses.main.config;

import cn.edu.njust.dev.ses.main.filter.SessionLoginFilter;
import cn.edu.njust.dev.ses.main.listener.SessionCollectionListener;
import cn.edu.njust.dev.ses.main.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SESConfig implements WebMvcConfigurer {
    @Autowired
    AccountManagementService accountManagement;
    @Bean
    public ServletListenerRegistrationBean listenerRegist(){
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new SessionCollectionListener());
        return srb;
    }
    @Bean
    public FilterRegistrationBean filterRegist(){
        FilterRegistrationBean frb = new FilterRegistrationBean(new SessionLoginFilter(accountManagement));
        frb.addUrlPatterns("/*");
        frb.setOrder(Integer.MIN_VALUE);
        return frb;
    }
}
