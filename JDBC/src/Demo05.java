import Utils.JDBCUtils;
import domain.Emp;

import java.sql.*;
import java.util.ArrayList;

/**
 * 将数据库中的表封装到类中再对其进行操作
 * @author Crossing
 * @date 2019-04-18
 */
public class Demo05 {
    public static void main(String[] args) {
        Demo05 demo05 = new Demo05();
        ArrayList<Emp> allList = demo05.getAllList();
        System.out.println(allList);
        System.out.println(allList.size());
    }

    /**
     * 返回所有的表中数据，用一个List存下来
     * @return
     */
    public ArrayList<Emp> getAllList(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet= null;
        ArrayList<Emp> emps = new ArrayList<>();
        try {
            connection =  JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "Select * from emp";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){

                //获取数据
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                // 创建emp对象,并赋值
                Emp emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                emps.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return emps;
    }
}
