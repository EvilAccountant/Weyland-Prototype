package com.weyland.prototype.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/16 16:53
 * \* Description:
 */

@Configuration
public class LoginConfig extends WebMvcConfigurerAdapter{
    
    public final static String SESSION_KEY = "user";
    
    public SecurityInterceptor getSecurityInterceptor(){
        return new SecurityInterceptor();
    }
    
    //拦截器配置
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        
        //设置不拦截的路径
        addInterceptor.excludePathPatterns("/login**");
        addInterceptor.excludePathPatterns("/signUp**");
        
        //设置拦截的路径
        addInterceptor.addPathPatterns("/**");
    }
    
    //拦截类及其方法配置
    private class SecurityInterceptor extends HandlerInterceptorAdapter{

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            HttpSession session = request.getSession();//获取session
            if(session.getAttribute(SESSION_KEY)!=null){
                return true;
            }
            //session为空则拦截
            String url = "/weyland/login";
            response.sendRedirect(url);
            return false;
        }
    }

}
