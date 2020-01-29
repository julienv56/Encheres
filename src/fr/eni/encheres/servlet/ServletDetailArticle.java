package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.ArticlesVendusManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.CategoriesDAOJdbcImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            RetraitManager retraitManager = new RetraitManager();
            Retrait retrait = new Retrait();
            retrait = retraitManager.getDetailArticle(noArticle);
            req.setAttribute("retrait", retrait);
        } catch (Exception e) {
            e.getMessage();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/userConnect/enchereArticle.jsp");
        rd.forward(req, resp);


    }
}
