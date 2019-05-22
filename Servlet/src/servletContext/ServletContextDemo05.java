package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * servletContext获取服务器目录
 * @author Crossing
 * @date 2019-05-22
 */
@WebServlet("/servletContextDemo05")
public class ServletContextDemo05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //2. 通过HttpServlet获取
        ServletContext context = this.getServletContext();//web目录下资源访问
        String realPath = context.getRealPath("/b.txt");

        System.out.println(realPath);
        File file = new File(realPath);


        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(c);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问

        System.out.println(a);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
