package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.UtilisateursManager;
import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        UtilisateursManager usersManager = new UtilisateursManager();
        Utilisateurs users = new Utilisateurs();
        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("MotDePasse");
        String remind = request.getParameter("remind");
        users = usersManager.selectionnerTousLesUtilisateurs(pseudo, mdp);
        String bddPseudo = users.getPseudo();
        if (bddPseudo == null) {
            response.sendRedirect("loginFailed.jsp");
        } else {
            //Session part
            HttpSession session = request.getSession();
            session.setAttribute("user", users);
            session.setMaxInactiveInterval(10 * 60); //setting session to expiry in 10 min
            //Cookie part
            Cookie loginCookie = new Cookie("pseudo", pseudo);
            loginCookie.setMaxAge(10 * 60); //setting cookie to expiry in 10 min
            response.addCookie(loginCookie);
            response.sendRedirect("loginSuccess.jsp");
        }
    }
}