package jdbc;

import java.sql.*;
import java.util.stream.StreamSupport;

/**
 * 用RsultSet遍历整张表，输出表中数据
 * @author Crossing
 * @date 2019-04-18
 */
public class Demo04 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/douby?useUnicode=true&characterEncoding=UTF-8", "root", "111111");
            String sql = "select * from dept";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");

                System.out.println(id + ", " + dname + ", " + loc);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
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
