package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *Cookie的快速入门
 * @author Crossing
 * @date 2019-05-22
 */
@WebServlet("/cookieDemo02")
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cs = request.getCookies();
        if (cs != null) {
            for (Cookie c : cs) {
                String value = c.getValue();
                String name = c.getName();
                System.out.println(name +":"+ value);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
