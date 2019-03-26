package reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

/**
 * Reflect的综合测试
 * @author Crossing
 * @date 2019-03-26
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {

        //1.1加载配置文件方法一
/*        Properties pro = new Properties();
        pro.load(new FileReader("AdvancedJava/src/pro.properties"));*/

        //1.2加载配置文件方法二
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        //这里直接填写文件名即可，不用和上面那样填写路径
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        properties.load(is);

        //2.获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //3.加载该类进内存
        Class aClass = Class.forName(className);

        //4.创建对象
        Object o = aClass.newInstance();

        //5.获取方法对象
        Method method = aClass.getMethod(methodName);

        //6.执行方法
        method.invoke(o);


    }
}
