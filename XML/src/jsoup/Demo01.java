package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup的第一个测试
 * @author Crossing
 * @date 2019-05-09
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
         //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        ClassLoader loader = Demo01.class.getClassLoader();
        URL resource = loader.getResource("student.xml");
        String path = resource.getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象 Element
        Elements name = document.getElementsByTag("name");
        //3.1遍历Elements
        for (Element e :
                name) {
            //3.2获取数据
            System.out.println(e.text());
        }
    }
}
