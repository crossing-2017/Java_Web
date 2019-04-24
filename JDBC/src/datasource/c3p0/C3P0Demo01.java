package datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0的演示
 * @author Crossing
 * @date 2019-04-24
 */
public class C3P0Demo01 {
    public static void main(String[] args) {
        // 1.获取DataSource，使用默认配置
        //ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        // 1.1 获取DataSource，使用指定名称配置
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("otherc3p0");
        //2.获取连接
        for (int i = 0; i < 10; i++) {
            try {
                Connection connection = comboPooledDataSource.getConnection();
                // 连接池中配置了是个连接，全部打印显示
                System.out.println(i+1 + ":" + connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
