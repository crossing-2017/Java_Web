package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 选择器查询
 * @author Crossing
 * @date 2019-05-09
 */
public class Demo05 {
    public static void main(String[] args) throws IOException {
        //1.获取student.xml的path
        String path = Demo05.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.查询name标签
        Elements elements = document.select("name");
        System.out.println(elements);

        System.out.println("---------------");
        //4.查询id值为douby的元素

        Elements douby = document.select("#douby");
        System.out.println(douby);

        System.out.println("---------------");
        //5.获取student标签并且number属性值为douby_0001的age子标签
        //5.1.获取student标签并且number属性值为heima_0001
        Elements element = document.select("student[number=\"douby_0001\"]");
        System.out.println("---------------");

        //5.2获取student标签并且number属性值为douby_0001的age子标签
        Elements age  = document.select("student[number=\"douby_0001\"] > age");
        System.out.println(age);
    }
}
