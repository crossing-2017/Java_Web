package jdbctemplate;

import domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils2;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * JDBCTemplate练习
 * @author Crossing
 * @date 2019-04-24
 */
public class Demo02 {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils2.getDataSource());

    /**
     * 1. 修改1号数据的 salary 为 10000
     */
    @Test
    public void test01(){
        String sql = "update emp set salary = 10000 where id = ?";
        jdbcTemplate.update(sql, 1001);
    }

    /**
     * 2. 添加一条记录
     */
    @Test
    public void test02(){
        String sql = "insert into emp(id, ename, dept_id) values(?, ?, ?)";
        jdbcTemplate.update(sql, 1015, "郭靖", 10);
    }

    /**
     * 3.删除刚才添加的记录
     */
    @Test
    public void test03(){
        String sql = "delete from emp where id = ?";
        jdbcTemplate.update(sql, 1015);
    }

    /**
     * 4.查询id为1001的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test04(){
        String sql = "Select * from emp where id = ?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 1001);
        System.out.println(stringObjectMap);
    }

    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test05(){
        String sql = "select * from emp";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map :
        maps){
            System.out.println(map);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test06(){
        String sql = "select * from emp";
        List<Emp> empList = jdbcTemplate.query(sql, (resultSet, i) -> {
            Emp emp = new Emp();
            int id = resultSet.getInt("id");
            String ename = resultSet.getString("ename");
            int job_id = resultSet.getInt("job_id");
            int mgr = resultSet.getInt("mgr");
            Date joindate = resultSet.getDate("joindate");
            double salary = resultSet.getDouble("salary");
            double bonus = resultSet.getDouble("bonus");
            int dept_id = resultSet.getInt("dept_id");

            emp.setId(id);
            emp.setEname(ename);
            emp.setJob_id(job_id);
            emp.setMgr(mgr);
            emp.setJoindate(joindate);
            emp.setSalary(salary);
            emp.setBonus(bonus);
            emp.setDept_id(dept_id);
            return emp;
        });

        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    /**
     * 6.1 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test07(){
        String sql= "select * from emp";
        List<Emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    /**
     * 7. 查询总记录数
     */
    @Test
    public void test08(){
        String sql = "select count(id) from emp";
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }
}
