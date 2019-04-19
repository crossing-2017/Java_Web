package jdbc;

import java.sql.*;

/**
 * 测试JDBC返回的结果集
 * @author Crossing
 * @date 2019-04-18
 */
public class Demo03 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/douby?useUnicode=true&characterEncoding=UTF-8", "root", "111111");
            //3.定义sql
            String sql = "select  * from dept";
            //4.获取执行sql对象
            statement = connection.createStatement();
            //5.执行sql
            resultSet = statement.executeQuery(sql);
            //6.处理结果
            //6.1 让游标向下移动一行
            resultSet.next();
            //6.2 获取数据
            int id = resultSet.getInt(1);
            String dname = resultSet.getString("dname");
            String loc = resultSet.getString(3);
            System.out.println(id + ", " + dname + ", " + loc);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
