package reflect;

import domain.Person;

import java.lang.reflect.Method;

/**
 * 关于反射机制的第四个测试,获取成员方法测试
 * @author Crossing
 * @date 2019-03-26
 */
public class Test4 {
    public static void main(String[] args) throws Exception{
        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
          3. 获取成员方法们：
             * Method[] getMethods()
             * Method getMethod(String name, 类<?>... parameterTypes)

             * Method[] getDeclaredMethods()
             * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         */

        //获取类中的全部成员方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //获取指定名称的方法
        Method method = personClass.getMethod("eat", String.class);
        System.out.println(method);
        //执行方法
        Person person = new Person();
        method.invoke(person, "苹果");
    }
}
