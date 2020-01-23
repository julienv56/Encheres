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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listeArticles")
public class ServletListerArticle extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            ArticlesVendusManager articlesVendusManager = new ArticlesVendusManager();
            List<ArticlesVendus> listeArticles;
            listeArticles = articlesVendusManager.selectionnerTousLesArticles();
            req.setAttribute("lstArticles", listeArticles);
        }catch (Exception e){
            e.getStackTrace();
        }
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }
}
