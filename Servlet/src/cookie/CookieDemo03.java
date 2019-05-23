package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie案例一
 * @author Crossing
 * @date 2019-05-22
 */
@WebServlet("/cookieDemo03")
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("msg", "hello");
        Cookie cookie2 = new Cookie("name", "zhangsan");
        //2.发送Cookie
        response.addCookie(cookie);
        response.addCookie(cookie2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
