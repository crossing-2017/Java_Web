package com.itheima.dao.impl;

import com.itheima.dao.ItermDao;
import com.itheima.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库连接接口实现类
 * @author Crossing
 * @date 2019-05-23
 */
public class ItermDaoImpl implements ItermDao {
    public List<Items> findAll() {


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        ArrayList<Items> itemsList = new ArrayList<Items>();



        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/douby", "root", "111111");
            String sql = "select * from dept";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Items items = new Items();
                int id = resultSet.getInt("id");
                items.setId(id);
                String dname = resultSet.getString("dname");
                items.setDname(dname);
                String loc = resultSet.getString("loc");
                items.setLoc(loc);
                itemsList.add(items);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return itemsList;
    }
}
