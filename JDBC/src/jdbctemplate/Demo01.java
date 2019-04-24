package jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils2;

/**
 * JDBCTemplate入门
 * @author Crossing
 * @date 2019-04-24
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils2.getDataSource());

        //3.调用方法
        String sql = "update user set name = 'zhangsan' where id = ?";
        int update = jdbcTemplate.update(sql, 1);
        System.out.println(update);


    }
}
