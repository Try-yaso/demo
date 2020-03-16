package cn.euruss.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project：demo
 * Date：2020/1/11
 * Time：23:33
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */
//拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后, 应该有用户的session; 如果获取到了session 就表明已经登录了
        Object loginUser = request.getSession().getAttribute("LoginUser");

        //进行判断是否登录 即loginUser值是否非空
        if(loginUser == null){
            //会写消息 转发回原来页面 否 不放行
            request.setAttribute("msg","没有权限,请先登录!");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }

    }
}
