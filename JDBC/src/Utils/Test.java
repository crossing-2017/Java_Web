package Utils;

import java.net.URL;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.getConnect();
    }
    public void getConnect(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource("jdbc.properties");
        String path = resource.getPath();
        System.out.println(path);
    }
}
