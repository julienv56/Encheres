package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.ArticlesVendusManager;
import fr.eni.encheres.bo.ArticlesVendus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletDetailArticle")
public class ServletDetailArticle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int noArticle = Integer.parseInt(req.getParameter("noArticle"));
        try {
            ArticlesVendusManager articlesVendusmanager = new ArticlesVendusManager();
            ArticlesVendus article = new ArticlesVendus();
            article = articlesVendusmanager.getArticle(noArticle);

            req.setAttribute("article", article);
        } catch (Exception e) {
            e.getMessage();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/userConnect/enchereArticle.jsp");
        rd.forward(req, resp);
    }
}
