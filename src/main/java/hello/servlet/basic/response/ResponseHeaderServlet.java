package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK); // HttpServletResponse.SC_BAD_REQUEST

        // [response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        // [Header 편의 메서드]
//        content(response);
//        cookie(response);
//        redirect(response);

        // [message body]
        response.getWriter().println("OK");
    }


    private void content(HttpServletResponse response) {
//        response.setHeader("Content-Type", "text/plain;charset=utf-8"); // 이거 대신 사용이 가능함
//        response.setContentLength(2); // (생략시 자동 생성)
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

     private void cookie(HttpServletResponse response) {
//        response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600"); // 이거 대신 사용이 가능함
         Cookie cookie = new Cookie("myCookie", "good");
         cookie.setMaxAge(600);
         response.addCookie(cookie);
     }

     private void redirect(HttpServletResponse response) throws IOException {
//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location", "/basic/hello-form.html"); // 이거 대신 사용이 가능함
        response.sendRedirect("/basic/hello-form.html");
     }
}
