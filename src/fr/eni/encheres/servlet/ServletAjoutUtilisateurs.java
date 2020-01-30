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
import java.io.PrintWriter;

@WebServlet("/register")
public class ServletAjoutUtilisateurs extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutUtilisateurs() {
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
        int credit;
        boolean administrateur;

        try {
            pseudo = request.getParameter("pseudo");
            nom = request.getParameter("nom");
            prenom = request.getParameter("prenom");
            email = request.getParameter("email");
            telephone = request.getParameter("telephone");
            rue = request.getParameter("rue");
            codePostal = request.getParameter("codePostal");
            ville = request.getParameter("ville");
            mot_de_passe = request.getParameter("MotDePasse");


            UtilisateursManager usersManager = new UtilisateursManager();
            Utilisateurs users = usersManager.ajouter(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mot_de_passe, 0, false);

        } catch (NumberFormatException ignored) {
        }
        RequestDispatcher rd = request.getRequestDispatcher("/login");
        rd.forward(request, response);
    }
}
