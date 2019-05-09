package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * XPath查询
 * @author Crossing
 * @date 2019-05-09
 */
public class Demo06 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1.获取student.xml的path
        String path = Demo06.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);

        //4.结合xpath语法查询
        //4.1查询所有student标签
        List<JXNode> students = jxDocument.selN("//student");
        for (JXNode student :
                students) {
            System.out.println(student);
        }

        System.out.println("----------------");

        //4.2查询所有student标签下的name标签
        List<JXNode> names = jxDocument.selN("//student/name");
        for (JXNode name :
                names) {
            System.out.println(name);
        }

        System.out.println("----------------");

        //4.3查询student标签下带有id属性的name标签
        List<JXNode> ids = jxDocument.selN("//student/name[@id]");
        for (JXNode id :
                ids) {
            System.out.println(id);
        }

        System.out.println("----------------");

        //4.4查询student标签下带有id属性的name标签 并且id属性值为douby
        List<JXNode> doubys = jxDocument.selN("//student/name[@id='douby']");
        for (JXNode douby :
                doubys) {
            System.out.println(doubys);
        }
    }
}
