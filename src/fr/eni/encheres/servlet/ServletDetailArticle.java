package fr.eni.encheres.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDetailArticle")
public class ServletDetailArticle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int noArticle = Integer.parseInt(req.getParameter("noArticle"));
        System.out.println(noArticle);
        RequestDispatcher rd = req.getRequestDispatcher("/userConnect/venteArticle.jsp");
        rd.forward(req, resp);
    }
}
