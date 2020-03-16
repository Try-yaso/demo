package cn.euruss.controller;

import cn.euruss.dao.DepartmentDao;
import cn.euruss.dao.EmployeeDao;
import cn.euruss.domain.Department;
import cn.euruss.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.PortUnreachableException;
import java.util.Collection;

/**
 * Project：demo
 * Date：2020/2/15
 * Time：1:20
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */
@Controller
public class EmployeeController {

    /*
    * 正常写一个controller
    * 1.注入service层对象
    * 2.写路径
    * 3.调用service层方法获取数据
    * 4.封装数据返回前端
    * 5.返回视图(路径)
    * */

    //1.注入service层对象
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //2.写路径
    @RequestMapping("/employees")
    public String list(Model model){

        //3.调用service层方法获取数据
        Collection<Employee> employees = employeeDao.getDepartments();

        //4.封装数据返回前端
        model.addAttribute("employees",employees);


        return "employee/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //需要查出所有部门的信息 不能再前端展示1-5这样的数字
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "employee/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加的操作
        /*
        * 在参数里接受前端传回的数据 前端的字段里有name属性 对应了实体类的属性 post方法封装 走action对应路径传递数据到后端 接收
        * 调用dao层方法保存就可以
        * 如果注入失败就是前端传回的字段名和后端实体类的字段名不一致 前端/前端 前端/后端
        * */
        System.out.println(employee);
        employeeDao.addEmployee(employee);
        //添加完成后 需要重定向回首页
        return "redirect:/employees";
    }

    @GetMapping("/emp/{id}")
    public  String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //修改的操作
        /*
        * 需要前端写路径的时候 就应该把要修改的员工id携带在路径上
        * 后端接受的时候用@PathVariable("id")取出
        * 在调用service层方法查询到员工信息 在提交数据 返回前端
        * 在调用service层方法修改信息 在提交数据
        * */
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("employeeById",employeeById);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "employee/update";
    }
}
