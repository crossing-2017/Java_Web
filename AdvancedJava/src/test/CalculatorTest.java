package test;

import junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 使用Junit测试类方法
 * @author Crossing
 * @date 2019-03-25
 */
public class CalculatorTest {

    /**
     * 初始化方法：
     *  用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("测试类开始");
    }

    /**
     * 测试add方法
     */
    @Test
    public void testAdd(){

        //1.创建计算器对象
        Calculator calculator = new Calculator();
        //2.调用add方法
        int add = calculator.add(1, 2);
        //System.out.println(add);

        //3.断言  我断言这个结果是3
        Assert.assertEquals(3, add);
    }

    /**
     * 释放资源方法：
     *  在所有测试方法执行完后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("测试类结束");
    }
}
