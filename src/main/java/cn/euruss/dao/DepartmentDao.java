package cn.euruss.dao;

import cn.euruss.domain.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Project：demo
 * Date：2020/1/11
 * Time：14:03
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */
//部门dao
@Repository
public class DepartmentDao {

    //模拟数据库中的数据 一般将数据库中的表抽象成Map
    private  static Map<Integer, Department> department = null;

    //用静态代码块抽象初始化数据  初始化部门表
    static {
        department = new HashMap<>();
        department.put(1000, new Department(101,"后勤部"));
        department.put(1001, new Department(102,"教研部"));
        department.put(1002, new Department(103,"前端部"));
        department.put(1003, new Department(104,"后端部"));
    }

    //数据库的操作 获得所有部门信息  不理解
    public Collection<Department> getDepartments(){
        return department.values();
    }

    //通过id获得部门
    public Department getDepartmentById(Integer id){
        return department.get(id);
    }
}
