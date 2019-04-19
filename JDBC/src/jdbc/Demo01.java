package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 快速入门JDBC
 * @author Crossing
 * @date 2019-04-07
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //1. 导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/douby", "root", "111111");
        //4.定义sql语句
        String sql = "update emp set salary=10000 where id = 1001";
        //5.获取执行sql的对象 Statement
        Statement statement = connection.createStatement();
        //6.执行sql
        int i = statement.executeUpdate(sql);
        //7.处理结果
        System.out.println(i);
        //8.释放资源
        statement.close();
        connection.close();
    }
}
