package com.itheima.dao;

import com.itheima.domain.Items;

import java.util.List;

/**
 * 连接数据库接口
 * @author Crossing
 * @date 2019-05-23
 */
public interface ItermDao {

    public List<Items> findAll() ;
}
