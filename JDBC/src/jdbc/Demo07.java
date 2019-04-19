package jdbc;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 解决SQL注入问题测试
 * @author Crossing
 * @date 2019-04-19
 */
public class Demo07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        boolean flag = new Demo07().login(username, password);
        if(flag){
            System.out.println("登录成功！");
        }else{
            System.out.println("用户名或密码错误！");
        }
    }

    public boolean login(String username, String password){


        if(username == null || password == null){
            return false;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from user where name = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return false;
    }
}
