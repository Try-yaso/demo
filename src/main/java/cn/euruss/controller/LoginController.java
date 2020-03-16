package cn.euruss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Project：demo
 * Date：2020/1/11
 * Time：19:49
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    private String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){

        // service logic
        //登录成功则需要在session保存用户信息 然后重定向到后台页面
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("LoginUser",username);
            return "redirect:/main.html";
        //登录失败则需要回写数据
        }else{
            model.addAttribute("msg","用户名或者密码错误!");
            return "index";
        }

    }
}
