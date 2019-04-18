import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试数据库插入语句
 * @author Crossing
 * @date 2019-04-09
 */
public class Demo02 {
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "update dept set dname = '研发部' where id = 40";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/douby?useUnicode=true&characterEncoding=UTF-8", "root", "111111");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println("影响的行数是：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
