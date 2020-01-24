package fr.eni.encheres.servlet;

import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletAjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
public static final long serialVersionUID = 1L;

    public ServletAjoutArticle() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String nom_article = req.getParameter("titre");
            String description = req.getParameter("description");
            String date_debut_enchere = req.getParameter("date_debut_enchere");
            String date_fin_enchere = req.getParameter("date_fin_enchere");
            String prix_initial = req.getParameter("miseAPrix");
            HttpSession session = req.getSession();
            int no_utilisateur = ((Utilisateurs) session.getAttribute("user")).getNo_utilisateur();
            //int no_categorie = req.getParameter("categoryId");




        }catch (Exception e){
            e.getStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("/userConnect/venteArticle.jsp");
        rd.forward(req, resp);
    }
}
