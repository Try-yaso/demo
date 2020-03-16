package cn.euruss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Project：demo
 * Date：2020/1/8
 * Time：20:37
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */
//接管mvc配置
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //在WebMvcConfigurer的配置能重写方法配置的 重写方法 不能的就注入bean

    //Access pathMap
    //自定义路由 比自己写controller更快
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //向spring注入自定义国际化解析器
    @Bean
    public LocaleResolver localeResolver(){ //相当于返回了一个实现类对象
        return new MyLocaleResolver();
    }

    //添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                //拦截所有路径
                .addPathPatterns("/**")
                //排除拦截请求        登录页       首页   自定义请求      静态资源
                .excludePathPatterns("/index.html","/","/user/login","/css/**","/img/**","/js/**");
    }
}