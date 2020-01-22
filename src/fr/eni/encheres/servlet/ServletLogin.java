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

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudo;
        String mot_de_passe;

        try {
            pseudo = request.getParameter("pseudo");
            mot_de_passe = request.getParameter("MotDePasse");
            UtilisateursManager usersManager = new UtilisateursManager();
            Utilisateurs users = usersManager.checkLogIn(pseudo, mot_de_passe);

        } catch (
                NumberFormatException e) {
            e.getCause();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }
}