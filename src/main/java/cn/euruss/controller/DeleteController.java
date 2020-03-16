package cn.euruss.controller;

import cn.euruss.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * Project：demo
 * Date：2020/2/15
 * Time：2:34
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */
@Controller
public class DeleteController {
    /*
     * 正常写一个controller
     * 1.注入service层对象
     * 2.写路径
     * 3.调用service层方法获取数据
     * 4.封装数据返回前端
     * 5.返回视图(路径)
     * */

    @Autowired
    private EmployeeDao employeeDao;

    @DeleteMapping("/delete")
    private String delete(int id){
        employeeDao.deleteEmployee(id);
        return "employee/list";
    }
}
