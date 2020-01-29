package fr.eni.encheres.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TrierParAchats")
public class ServletTriAchats extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public ServletTriAchats() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo
        String achatsSelected = req.getParameter("option");
        System.out.println(achatsSelected);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String achatsSelected = req.getParameter("option");
        System.out.println(achatsSelected);
    }
}
