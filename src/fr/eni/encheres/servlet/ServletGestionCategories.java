package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.CategoriesManager;
import fr.eni.encheres.bo.Categories;

import javax.imageio.IIOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/categorie")
public class ServletGestionCategories extends HttpServlet {

    public static final long serialVersionUID = 1L;

    public ServletGestionCategories() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CategoriesManager categorieManager = new CategoriesManager();
            List<Categories> listeCategorie = null;
            System.out.println("HELLO");
            listeCategorie = categorieManager.selectionnerToutesLesCategories();

            request.setAttribute("lstCategorie", listeCategorie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }



}
