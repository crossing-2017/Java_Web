package datasource.druid;

import utils.JDBCUtils;
import utils.JDBCUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用工具类来调用连接池技术
 * @author Crossing
 * @date 2019-04-24
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /*
         * 完成添加操作：给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String sql = "select * from dept where dname=? and loc=?";

        try {
            conn = JDBCUtils2.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "研发部");
            pstmt.setString(2, "杭州");
            resultSet = pstmt.executeQuery();
            System.out.println(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, pstmt, resultSet);
        }
    }
}
