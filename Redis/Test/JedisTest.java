import jedis.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis测试类
 * @author Crossing
 * @date 2019-05-23
 */
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test01(){
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        jedis.set("username", "zhangsan");
        //3. 关闭连接
        jedis.close();
    }

    /**
     * String 数据结构操作
     */
    @Test
    public void test02(){
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379); //如果使用空参构造，默认值 "localhost",6379端口

        //2. 操作
        //存储
        jedis.set("username","zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的 key value

        String setex = jedis.setex("activecode", 20, "hehe");   //将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对

        System.out.println(setex);

        //3. 关闭连接
        jedis.close();
    }


    /**
     * hash 数据结构操作
     */
    @Test
    public void test03(){
        //1. 获取连接
        Jedis jedis = new Jedis();

        //2. 操作
        //存储
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "male");


        //获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);


        // 获取hash的所有map中的数据

        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keys = user.keySet();
        for (String key : keys) {
            String value = user.get(key);
            System.out.println(key +" -- "+ value);
        }

        //3. 关闭连接
        jedis.close();
    }


    /**
     * list 数据结构操作
     */
    @Test
    public void test04(){
        //1. 获取连接
        Jedis jedis = new Jedis();

        //list存储
        jedis.lpush("mylist", "a", "b", "f", "d");  //从左边存
        jedis.rpush("mylist", "a", "b", "f", "d");  //从右边存


        // list 范围获取
        List<String> mylists = jedis.lrange("mylist", 0, -1);

        for (String mylist : mylists) {
            System.out.println(mylist);
        }


        System.out.println("--------------");

        // list 弹出

        //从左边弹出
        String lpop = jedis.lpop("mylist");
        System.out.println(lpop);

        //从右边弹出
        String rpop = jedis.rpop("mylist");
        System.out.println(rpop);


        //3. 关闭连接
        jedis.close();
    }


    /**
     * set 数据结构操作
     */
    @Test
    public void test05(){
        //1. 获取连接
        Jedis jedis = new Jedis();

        //2.操作

        jedis.sadd("myset", "a", "b", "c", "a");


        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        //3. 关闭连接
        jedis.close();
    }


    /**
     * sortedset 数据结构操作
     */
    @Test
    public void test06(){
        //1. 获取连接
        Jedis jedis = new Jedis();

        //2.操作
        jedis.zadd("mysort",60, "张三");
        jedis.zadd("mysort",50, "李四");
        jedis.zadd("mysort",80, "王五");


        Set<String> mysort = jedis.zrange("mysort", 0, -1);
        System.out.println(mysort);

        //3. 关闭连接
        jedis.close();
    }


    /**
     * Jedis连接池使用
     */
    @Test
    public void test07(){

        //0.创建一个配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);


        //1.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);

        //2.获取连接
        Jedis jedis = jedisPool.getResource();

        //3. 使用
        jedis.set("hehe","heihei");


        //4. 关闭 归还到连接池中
        jedis.close();
    }


    /**
     * Jedis连接池工具类使用
     */
    @Test
    public void test08(){

        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("hehe", "haha");

        String hehe = jedis.get("hehe");
        System.out.println(hehe);


        //4. 关闭 归还到连接池中
        jedis.close();
    }
}
