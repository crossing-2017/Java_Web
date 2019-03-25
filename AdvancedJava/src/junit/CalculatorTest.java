package junit;

/**
 * 测试的通常方法
 * @author Crossing
 * @date 2019-03-25
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        //加法测试
        int add = calculator.add(1, 2);
        System.out.println(add);

        //减法测试
        int sub = calculator.sub(2, 1);
        System.out.println(sub);
    }
}
