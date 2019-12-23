package cn.edu.njust.dev.ses.main.config;

import cn.edu.njust.dev.ses.main.filter.SessionLoginFilter;
import cn.edu.njust.dev.ses.main.interceptor.AssociationLoginInterceptor;
import cn.edu.njust.dev.ses.main.interceptor.StudentLoginInterceptor;
import cn.edu.njust.dev.ses.main.interceptor.TeacherLoginInterceptor;
import cn.edu.njust.dev.ses.main.listener.SessionCollectionListener;
import cn.edu.njust.dev.ses.main.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
    @Bean
    public  WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new AssociationLoginInterceptor())
                        .excludePathPatterns("/")
                        .addPathPatterns("/associate/**");

                registry.addInterceptor(new TeacherLoginInterceptor())
                        .excludePathPatterns("/")
                        .addPathPatterns("/teacher/**");

                registry.addInterceptor(new StudentLoginInterceptor())
                        .excludePathPatterns("/")
                        .addPathPatterns("/student/**");
            }
        };
    }
}
