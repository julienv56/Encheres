package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.ArticlesVendusManager;
import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bll.UtilisateursManager;
import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/encheres")
public class ServletEncheres extends HttpServlet {

    public static final long serialVersionUID = 1L;

    public ServletEncheres() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            int oldCredit = ((Utilisateurs) session.getAttribute("user")).getCredit();
            String pseudo = ((Utilisateurs) session.getAttribute("user")).getPseudo();
            String nom = ((Utilisateurs) session.getAttribute("user")).getNom();
            String prenom = ((Utilisateurs) session.getAttribute("user")).getPrenom();
            String email = ((Utilisateurs) session.getAttribute("user")).getEmail();
            String telephone = ((Utilisateurs) session.getAttribute("user")).getTelephone();
            String rue = ((Utilisateurs) session.getAttribute("user")).getRue();
            String code_postal = ((Utilisateurs) session.getAttribute("user")).getCode_postal();
            String ville = ((Utilisateurs) session.getAttribute("user")).getVille();
            String mot_de_passe = ((Utilisateurs) session.getAttribute("user")).getMot_de_passe();
            int no_utilisateur = ((Utilisateurs) session.getAttribute("user")).getNo_utilisateur();

            int prix = ((Retrait) session.getAttribute("retrait")).getArticle().getPrixVente();
            String proposition = request.getParameter("proposition");
            int propositionInt = Integer.parseInt(proposition);

            if (oldCredit < propositionInt) {
                System.out.println("Credit inférieur à la proposition");
            } else if (oldCredit < prix) {
                System.out.println("Fond insuffisant");
            } else if (propositionInt <= prix) {
                System.out.println("Proposition insuffisante");
            } else {
                int credit = (oldCredit - propositionInt);
                UtilisateursManager usersManager = new UtilisateursManager();
                Utilisateurs users = usersManager.modifier(no_utilisateur, pseudo, prenom, nom, email, telephone, rue, code_postal, ville, mot_de_passe, credit);
                EncheresManager encheresManager = new EncheresManager();
                ArticlesVendus art = ((Retrait) session.getAttribute("retrait")).getArticle();
                Utilisateurs user = ((Utilisateurs) session.getAttribute("user"));
                Date date = new Date(System.currentTimeMillis());
                int noArt = ((Retrait) session.getAttribute("retrait")).getArticle().getNoArticle();
                ArticlesVendusManager articlesVendusManager = new ArticlesVendusManager();
                if (((Retrait) session.getAttribute("retrait")).getArticle().getPrixVente() == 0) {

                    ArticlesVendus articlesVendus = articlesVendusManager.modifierPrixVente(propositionInt, noArt);
                    Encheres encheres = encheresManager.ajouter(user, art, date, propositionInt);

                } else if (((Retrait) session.getAttribute("retrait")).getArticle().getPrixVente() < propositionInt) {
                    ArticlesVendus articlesVendus = articlesVendusManager.modifierPrixVente(propositionInt, noArt);
                    ArticlesVendus crediterOld = encheresManager.crediterOld(art);
                    Encheres encheresUpdate = encheresManager.modifierEnchere(user, date, propositionInt, art);
                } else {
                    System.out.println("no");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("ServletDetailArticle");
    }
}