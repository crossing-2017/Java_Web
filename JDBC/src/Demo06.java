import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 查询数据库登陆情况
 * @author Crossing
 * @date 2019-0419
 */
public class Demo06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        boolean flag = new Demo06().login(username, password);
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
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from user where name = '"+username+"' and password = '"+password+"' ";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return false;
    }
}
