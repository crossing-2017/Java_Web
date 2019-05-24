package com.itheima.domain;

import lombok.Data;

/**
 * 数据库连接属性
 * @author Crossing
 * @date 2019-05-23
 */
@Data
public class Items {
    /**
     * id
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String dname;
    /**
     * 部门地址
     */
    private String loc;
}
