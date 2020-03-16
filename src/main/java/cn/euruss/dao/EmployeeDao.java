package cn.euruss.dao;

import cn.euruss.domain.Department;
import cn.euruss.domain.Employee;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project：demo
 * Date：2020/1/11
 * Time：19:05
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */
//雇员dao
@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentdao;


    private  static Map<Integer, Employee> employees = null;

    //Initialize data
    static {
        employees = new HashMap<>();
        employees.put(100, new Employee(1001,"阿强","22222222@qq.com",0,new Department(101,"后勤部")));
        employees.put(101, new Employee(1002,"阿珍","22222222@qq.com",0,new Department(101,"后勤部")));
        employees.put(102, new Employee(1003,"阿东","22222222@qq.com",0,new Department(101,"后勤部")));
        employees.put(103, new Employee(1004,"阿犀","22222222@qq.com",0,new Department(101,"后勤部")));
        employees.put(104, new Employee(1005,"阿到","22222222@qq.com",0,new Department(101,"后勤部")));

    }

    //the primary key from the increase
    private static Integer initId = 1006;

    //Add a Employee
    public void addEmployee(Employee employee){
        //not null
        if (null == employee.getId()){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentdao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //Delete a employee
    public void deleteEmployee(Integer id){
        employees.remove(id);
    }

    //Get all employees
    public Collection<Employee> getDepartments(){
        return employees.values();
    }

    //Get employee by id
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }



}
