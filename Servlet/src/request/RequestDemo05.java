package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 对Request请求的其他方法的分析
 * @author Crossing
 * @date 2019-05-22
 */
@WebServlet("/requestDemo05")
public class RequestDemo05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // post获取请求参数

        //根据参数名称获取参数值
        String username = request.getParameter("username");


        //根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
//        for (String hobby : hobbies) {
//            System.out.println(hobby);
//        }


        Map<String, String[]> parameterMap = request.getParameterMap();

        Set<String> names = parameterMap.keySet();
        for (String name : names) {
            System.out.println(name);
            String[] values = parameterMap.get(name);
            for (String value : values) {
                System.out.println(value);
            }


            System.out.println("-------------");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get获取请求参数

        this.doPost(request, response);
    }
}
