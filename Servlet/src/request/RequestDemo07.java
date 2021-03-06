package request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对Request请求中中文的处理
 * @author Crossing
 * @date 2019-05-22
 */
@WebServlet("/requestDemo07")
public class RequestDemo07 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo07被访问了");


        request.setAttribute("msg", "HelloWorld");
        //转发到demo8资源
        request.getRequestDispatcher("/requestDemo08").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get获取请求参数

        this.doPost(request, response);
    }
}
