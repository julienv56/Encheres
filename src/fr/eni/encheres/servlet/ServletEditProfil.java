package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.UtilisateursManager;
import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            pseudo = request.getParameter("pseudoEdited");
            nom = request.getParameter("nomEdited");
            prenom = request.getParameter("prenomEdited");
            email = request.getParameter("emailEdited");
            telephone = request.getParameter("telephoneEdited");
            rue = request.getParameter("rueEdited");
            codePostal = request.getParameter("codePostalEdited");
            ville = request.getParameter("villeEdited");
            mot_de_passe = request.getParameter("newPasswordEdited");

            System.out.println(pseudo);

//            UtilisateursManager usersManager = new UtilisateursManager();
//            Utilisateurs users = usersManager.modifier(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mot_de_passe);

        } catch (NumberFormatException ignored) {
        }
        RequestDispatcher rd = request.getRequestDispatcher("/profilEdit.jsp");
        rd.forward(request, response);
    }

}
