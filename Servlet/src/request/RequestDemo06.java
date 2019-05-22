package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 对Request请求中中文的处理
 * @author Crossing
 * @date 2019-05-22
 */
@WebServlet("/requestDemo06")
public class RequestDemo06 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.设置流的编码
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        System.out.println(username);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get获取请求参数

        this.doPost(request, response);
    }
}
