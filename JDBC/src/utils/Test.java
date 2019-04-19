package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        Properties properties = new Properties();
        ClassLoader classLoader = Test.class.getClassLoader();
        URL resource = classLoader.getResource("jdbc.properties");
        String path = resource.getPath();
        try {
            properties.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a = 3;
    }

}
