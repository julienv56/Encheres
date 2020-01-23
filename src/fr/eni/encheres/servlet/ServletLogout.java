package fr.eni.encheres.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    loginCookie = cookie;
                    //System.out.println("JSESSIONID=" + cookie.getValue());
                    break;
                }
            }
            loginCookie.setMaxAge(0);
            response.addCookie(loginCookie);
        }
        //invalidate the session if exists
        HttpSession session = request.getSession(false);
        //System.out.println("User=" + session.getAttribute("user"));
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("index.jsp");
    }

}