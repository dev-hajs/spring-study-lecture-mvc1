package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.service(req, resp);

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // request
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // response
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); // euc-kr 은 옛날 encoding 방식이다. 2020년이 지난 지금은 utf-8 을 사용하면 된다.
        response.getWriter().write("hello " + username);
    }
}
