package jsoup;

import jdk.nashorn.internal.runtime.JSONFunctions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Document/Element对象功能
 * @author Crossing
 * @date 2019-05-09
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
        //1.获取student.xml的path
        String path = Demo03.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象了。
        //3.1获取所有student对象
        Elements student = document.getElementsByTag("student");
        System.out.println(student);


        System.out.println("-----------");


        //3.2 获取属性名为id的元素对象们
        Elements elements = document.getElementsByAttribute("id");
        System.out.println(elements);


        System.out.println("-----------");


        //3.2获取 number属性值为douby_0001的元素对象
        Elements value = document.getElementsByAttributeValue("number", "douby_0001");
        System.out.println(value);

        System.out.println("-----------");


        //3.3获取id属性值的元素对象
        Element douby = document.getElementById("douby");
        System.out.println(douby);

    }
}
