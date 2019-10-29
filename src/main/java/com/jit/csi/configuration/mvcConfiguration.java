package com.jit.csi.configuration;

import com.jit.csi.configuration.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-08-02 - 10:24
 */
@Configuration
public class mvcConfiguration implements WebMvcConfigurer {
    private static final List<String> EXCLUDE_PATH= Arrays.asList("/","/login*","/register*","/static/**",
            "/chinasofti/**","/audio/**","/photo/**","/error","/favicon.ico");
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/menu.html").setViewName("menu");
        registry.addViewController("/editpassword.html").setViewName("editpassword");
        registry.addViewController("/audioSet.html").setViewName("audioSet");
        registry.addViewController("/comment.html").setViewName("comment");
        registry.addViewController("/myComment.html").setViewName("myComment");
        registry.addViewController("/myPost.html").setViewName("myPost");
        registry.addViewController("/perSet.html").setViewName("perSet");
        registry.addViewController("/post.html").setViewName("post");
        registry.addViewController("/uploadHead.html").setViewName("uploadHead");
        registry.addViewController("/userManage.html").setViewName("userManage");
    }


    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**"); 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).excludePathPatterns(EXCLUDE_PATH).addPathPatterns("/**");
        //super.addInterceptors(registry);    //较新Spring Boot的版本中这里可以直接去掉，否则会报错

    }
//    //跨域问题
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .allowedOrigins("*")
//                .allowCredentials(true);
//    }


}
