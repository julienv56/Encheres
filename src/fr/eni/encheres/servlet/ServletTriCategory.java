package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.ArticlesVendusManager;
import fr.eni.encheres.bll.CategoriesManager;
import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Categories;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/TrierParCategory")
public class ServletTriCategory extends ServletListCategorie {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int categorySelected = Integer.parseInt(req.getParameter("categorie"));
        int no_categorie = categorySelected;

        try {
            CategoriesManager categorieManager = new CategoriesManager();
            List<Categories> listeCategorie;
            listeCategorie = categorieManager.selectionnerToutesLesCategories();
            req.setAttribute("lstCategorie", listeCategorie);

            ArrayList<ArticlesVendus> lesArticles = new ArrayList<>();
            ArticlesVendusManager articleManager = new ArticlesVendusManager();
            lesArticles = (ArrayList<ArticlesVendus>) articleManager.listerParCategorie(categorySelected);

            req.setAttribute("lstArticles", lesArticles);

        } catch (Exception e) {

            e.getMessage();
        }

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }
}
