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

@WebServlet("/register")
public class ServletAjoutUtilisateurs extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutUtilisateurs() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
		rd.forward(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudo;
        String nom;
        String prenom;
        String email;
        String telephone;
        String rue;
        String code_postal;
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
            code_postal = request.getParameter("code_postal");
            ville = request.getParameter("ville");
            mot_de_passe = request.getParameter("mot_de_passe");
            credit = Integer.parseInt(request.getParameter("credit"));
            administrateur = Boolean.parseBoolean(request.getParameter("administrateur"));
            UtilisateursManager usersManager = new UtilisateursManager();
            Utilisateurs users = usersManager.ajouter(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, true);
//            request.setAttribute("utilisateurs", users);
        } catch (NumberFormatException e) {
        	System.out.println(e);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
        rd.forward(request, response);
    }
}
