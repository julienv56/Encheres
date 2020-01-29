package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.ArticlesVendusManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/ServletAjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public ServletAjoutArticle() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("je suis au début du POST ServletAjoutArticle");
            String nom_article = req.getParameter("titre");
            String description = req.getParameter("description");
            LocalDate date_debut_enchere = LocalDate.parse(req.getParameter("date_debut_enchere"));
            LocalDate date_fin_enchere = LocalDate.parse(req.getParameter("date_fin_enchere"));
            int prix_initial = Integer.parseInt(req.getParameter("miseAPrix"));
            HttpSession session = req.getSession();
            int no_utilisateur = ((Utilisateurs) session.getAttribute("user")).getNo_utilisateur();
            int categorySelected = Integer.parseInt(req.getParameter("categorie"));
            int no_categorie = categorySelected;

            String rueRetrait = req.getParameter("rue");
            String codePostalRetrait = req.getParameter("code_postal");
            String villeRetrait = req.getParameter("ville");
            ArticlesVendusManager articleManager = new ArticlesVendusManager();
            System.out.println("Je vais appeler le insert");
            ArticlesVendus article = articleManager.ajouter(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie);

            RetraitManager retraitManager = new RetraitManager();
            retraitManager.ajouter(article,rueRetrait,codePostalRetrait,villeRetrait);
        } catch (Exception e) {
            e.getMessage();
        }

        resp.sendRedirect("ServletListCategorie");
    }
}
