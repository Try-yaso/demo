package cn.euruss.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Project：demo
 * Date：2020/1/11
 * Time：23:56
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */
//国际化解析器
public class MyLocaleResolver implements LocaleResolver {

    //重写方法  照着 AcceptHeaderLocaleResolver 这个类重写里面的方法
    //两个方法 resolveLocale 有返回值 需要重写 下面set方法没有返回值就不需要重写
    //国际化解析器写完之后需要放在spring的bean中 需要在自配的视图解析器中写入
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String language = request.getParameter("language");
        Locale locale = Locale.getDefault();//对着原来接口的方法写,没有就使用默认的
        //进行判断 如果请求的链携带了国际化的参数
        if(!StringUtils.isEmpty(language)){
            //language是键值对 就需要对字符串进行分割  l='zh_CN'
            String[] split = language.split("_");
            //如果携带了参数就构造一个自己的新对象
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
