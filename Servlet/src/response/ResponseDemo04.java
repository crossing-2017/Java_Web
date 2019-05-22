package response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 获取输出字节流
 * @author Crossing
 * @date 2019-05-22
 */
@WebServlet("/responseDemo04")
public class ResponseDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //简单的形式，设置编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //2.输出数据
        outputStream.write("你好".getBytes(StandardCharsets.UTF_8));


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
