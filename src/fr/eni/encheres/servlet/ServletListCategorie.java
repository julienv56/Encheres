package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.CategoriesManager;
import fr.eni.encheres.bo.Categories;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/ServletListCategorie")

public class ServletListCategorie extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public ServletListCategorie() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null)
        {
            RequestDispatcher rd = req.getRequestDispatcher("/connectToi.jsp");
            rd.forward(req, resp);
        }else {
            try {
                CategoriesManager categorieManager = new CategoriesManager();
                List<Categories> listeCategorie;
                listeCategorie = categorieManager.selectionnerToutesLesCategories();

                req.setAttribute("lstCategorie", listeCategorie);


            } catch (Exception e) {
                e.printStackTrace();
            }
            RequestDispatcher rd = req.getRequestDispatcher("/userConnect/venteArticle.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
