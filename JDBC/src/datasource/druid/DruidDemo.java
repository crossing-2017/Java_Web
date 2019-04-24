package datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid演示
 * @author Crossing
 * @date 2019-04-24
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception{
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties properties = new Properties();
        ClassLoader classLoader = DruidDemo.class.getClassLoader();
        URL resource = classLoader.getResource("druid.properties");
        String path = resource.getPath();
        properties.load(new FileReader(path));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        for (int i = 0; i < 5; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        }
    }
}
