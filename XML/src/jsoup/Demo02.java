package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup的对象功能
 * @author Crossing
 * @date 2019-05-09
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        String path = Demo02.class.getClassLoader().getResource("student.xml").getPath();
/*        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);*/

        //2.parse​(String html)：解析xml或html字符串
        /*String str = "<!--?xml version=\"1.0\" encoding=\"UTF-8\" ?-->\n" +
                "<html>\n" +
                " <head></head>\n" +
                " <body>\n" +
                "  <students> \n" +
                "   <student number=\"douby_0001\"> \n" +
                "    <name>\n" +
                "     张三\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     23\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     male\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "   <student number=\"douby_0002\"> \n" +
                "    <name>\n" +
                "     lisi\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     24\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     female\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "  </students>\n" +
                " </body>\n" +
                "</html>";


        Document document = Jsoup.parse(str);
        System.out.println(document);*/


        //3.parse​(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");//代表网络中的一个资源路径
        Document parse = Jsoup.parse(url, 1000);
        System.out.println(parse);
    }
}
