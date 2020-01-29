package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.ArticlesVendusManager;
import fr.eni.encheres.bll.CategoriesManager;
import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Categories;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/TrierParAchats")
public class ServletTriAchats extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public ServletTriAchats() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String achatsSelected = req.getParameter("option");
        String ventesEnCours = req.getParameter("ventesEnCours");
        String ventesNonDeb = req.getParameter("ventesNonDeb");
        String ventesTerm = req.getParameter("ventesTerm");

        try {
            CategoriesManager categorieManager = new CategoriesManager();
            ArrayList<ArticlesVendus> lesArticles = new ArrayList<>();
            ArticlesVendusManager articleManager = new ArticlesVendusManager();
            lesArticles = (ArrayList<ArticlesVendus>) articleManager.listerParFiltre(achatsSelected);

            req.setAttribute("lstArticles", lesArticles);

        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println(achatsSelected);
        RequestDispatcher rd = req.getRequestDispatcher("test.jsp");
        rd.forward(req, resp);
    }
}
