package cn.euruss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project：demo
 * Date：2020/1/9
 * Time：15:12
 * Description：TODO
 *
 * @author 海龙王
 * @version 1.0
 */

//部门表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
