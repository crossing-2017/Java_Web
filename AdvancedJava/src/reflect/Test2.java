package reflect;

import domain.Person;

import java.lang.reflect.Field;

/**
 * 关于反射机制的第一个测试,获取成员变量测试
 * @author Crossing
 * @date 2019-03-25
 */
public class Test2 {

    /**
     Class对象功能：
     * 获取功能：
     1. 获取成员变量们
     * Field[] getFields()
     * Field getField(String name)

     * Field[] getDeclaredFields()
     * Field getDeclaredField(String name)
     2. 获取构造方法们
     * Constructor<?>[] getConstructors()
     * Constructor<T> getConstructor(类<?>... parameterTypes)

     * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
     * Constructor<?>[] getDeclaredConstructors()
     3. 获取成员方法们：
     * Method[] getMethods()
     * Method getMethod(String name, 类<?>... parameterTypes)

     * Method[] getDeclaredMethods()
     * Method getDeclaredMethod(String name, 类<?>... parameterTypes)

     4. 获取类名
     * String getName()



     */
    public static void main(String[] args) throws Exception {

        //0.获取Person的Class对象
        Class personClass = Person.class;

        /*
             1. 获取成员变量们
                 * Field[] getFields()
                 * Field getField(String name)

                 * Field[] getDeclaredFields()
                 * Field getDeclaredField(String name)

         */
        //1.Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("----------");

        //2.Field getField(String name)

        Field a = personClass.getField("a");

        //获取成员变量a 的值
        Person person = new Person();
        Object o = a.get(person);
        System.out.println(o);

        //设置a的值
        Person p1 = new Person();
        a.set(p1, 12);
        System.out.println(p1);

        //Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Field name = personClass.getDeclaredField("name");

        //忽略访问权限修饰符的安全检查
        name.setAccessible(true);//暴力反射
        Object zhangsan = name.get(new Person("zhangsan", 12));
        System.out.println(zhangsan);
    }
}
