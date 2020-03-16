package cn.euruss.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Project：demo
 * Date：2020/1/9
 * Time：15:15
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */
//员工表
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //0 女 1 男
    private Department department;
    private Date birth;

    //有参构造去掉时间参数
    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认的创建日期
        this.birth = new Date();
    }
}
