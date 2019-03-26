package reflect;

import domain.Person;

/**
 * 关于反射机制的第一个测试,获取Class类的方法
 * @author Crossing
 * @date 2019-03-25
 */
public class Test1 {

    /**
     获取Class对象的方式：
     1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
     2. 类名.class：通过类名的属性class获取
     3. 对象.getClass()：getClass()方法在Object类中定义着。

     */
    public static void main(String[] args) throws ClassNotFoundException {

        //1.Class.forName("全类名")
        Class class1 = Class.forName("domain.Person");
        System.out.println(class1);

        //2.类名.class
        Class class2 = Person.class;
        System.out.println(class2);

        //3.对象.getClass()
        Person p = new Person();
        Class class3 = p.getClass();
        System.out.println(class3);


        //== 比较三个对象
        System.out.println(class1 == class2);   //true
        System.out.println(class1 == class3);   //true

    }
}
