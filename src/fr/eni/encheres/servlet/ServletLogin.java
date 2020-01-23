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
        try {
            UtilisateursManager usersManager = new UtilisateursManager();
            Utilisateurs users = new Utilisateurs();
            System.out.println(request.getParameter("pseudo"));
            String pseudo = request.getParameter("pseudo");
            String mdp = request.getParameter("MotDePasse");
            System.out.println(pseudo);
            System.out.println(mdp);
            users = usersManager.selectionnerTousLesUtilisateurs(pseudo, mdp);
            request.setAttribute("users", users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
}