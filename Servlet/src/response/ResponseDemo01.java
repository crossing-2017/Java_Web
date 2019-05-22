package response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * response响应的第一个案例
 * @author Crossing
 * @date 2019-05-22
 */
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1........");
        //访问/responseDemo1，会自动跳转到/responseDemo2资源
        /*//1. 设置状态码为302
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location", "/servlet/responseDemo02");*/

        request.setAttribute("msg", "HelloWorld");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();


        //简单的重定向方法
        response.sendRedirect(contextPath + "/responseDemo02");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
