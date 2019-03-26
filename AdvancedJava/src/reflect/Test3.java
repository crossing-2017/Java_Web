package reflect;

import domain.Person;

import java.lang.reflect.Constructor;

/**
 * 关于反射机制的第三个测试,获取构造方法测试
 * @author Crossing
 * @date 2019-03-26
 */
public class Test3 {
    public static void main(String[] args) throws Exception {

        //0.获取Person的Class对象
        Class personClass = Person.class;

        /*
            2. 获取构造方法们
                 * Constructor<?>[] getConstructors()
                 * Constructor<T> getConstructor(类<?>... parameterTypes)

                 * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
                 * Constructor<?>[] getDeclaredConstructors()
         */



        //遍历所有个构造器
        Constructor[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //获取单一属性的构造器
        Constructor constructor = personClass.getConstructor(String.class, int.class);

        //创建对象
        Object aPerson = constructor.newInstance("zhangsan", 23);
        System.out.println(constructor);
        System.out.println(aPerson);

        //直接用类对象来创建新的目标对象，这样只能获得无参对象
        Object o = personClass.newInstance();
        System.out.println(o);
    }
}
