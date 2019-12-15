package cn.edu.njust.dev.ses.main.filter;

import cn.edu.njust.dev.ses.main.service.AccountManagementService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionLoginFilter extends OncePerRequestFilter {
    private final AccountManagementService accountManagementService;
    public SessionLoginFilter(AccountManagementService accountManagement){
        this.accountManagementService = accountManagement;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getSession().getAttribute("logged_in_as") == null && request.getSession().getAttribute("quick_validate_performed") == null) {
            accountManagementService.quickValidate(request);
            request.getSession().setAttribute("quick_validate_performed", true);
        }
        filterChain.doFilter(request, response);
    }
}
