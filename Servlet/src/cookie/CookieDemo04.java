package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie存活时间
 * @author Crossing
 * @date 2019-05-22
 */
@WebServlet("/cookieDemo04")
public class CookieDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("msg", "setMaxAge");
        //2.设置cookie的存活时间
        cookie.setMaxAge(30);//将cookie持久化到硬盘，30秒后会自动删除cookie文件
        //cookie.setMaxAge(0);//删除Cookie
        //3.发送Cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
