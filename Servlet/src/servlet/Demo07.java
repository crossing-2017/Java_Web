package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet多种路径的选择
 * @author Crossing
 * @date 2019-05-21
 */
//@WebServlet({"/demo07", "/d07", "/dd07"})
//@WebServlet("/user/demo07")
@WebServlet("*.do")     //http://localhost:8080/demo07.do
public class Demo07 extends HttpServlet {

    /**
     * 继承doGet方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet....");
    }

}
