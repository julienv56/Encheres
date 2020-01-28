package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.UtilisateursManager;
import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/edit")
public class ServletEditProfil extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditProfil() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudo;
        String nom;
        String prenom;
        String email;
        String telephone;
        String rue;
        String codePostal;
        String ville;
        String mot_de_passe;

        try {
            HttpSession session = request.getSession();
            int no_utilisateur = ((Utilisateurs) session.getAttribute("user")).getNo_utilisateur();
            pseudo = request.getParameter("pseudoEdited");
            nom = request.getParameter("nomEdited");
            prenom = request.getParameter("prenomEdited");
            email = request.getParameter("emailEdited");
            telephone = request.getParameter("telephoneEdited");
            rue = request.getParameter("rueEdited");
            codePostal = request.getParameter("codePostalEdited");
            ville = request.getParameter("villeEdited");
            mot_de_passe = request.getParameter("newPasswordEdited");

            UtilisateursManager usersManager = new UtilisateursManager();
            Utilisateurs users = usersManager.modifier(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mot_de_passe);

        } catch (NumberFormatException ignored) {
        }
        RequestDispatcher rd = request.getRequestDispatcher("/profil.jsp");
        rd.forward(request, response);
    }

}
