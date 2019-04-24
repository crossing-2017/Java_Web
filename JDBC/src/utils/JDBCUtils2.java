package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import datasource.druid.DruidDemo;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC用Druid连接池技术的工具类
 */
public class JDBCUtils2 {


    //1.定义成员变量 DataSource
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        ClassLoader classLoader = DruidDemo.class.getClassLoader();
        URL resource = classLoader.getResource("druid.properties");
        String path = resource.getPath();
        try {
            properties.load(new FileReader(path));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnect() throws SQLException {
        return dataSource.getConnection();
    }
}
