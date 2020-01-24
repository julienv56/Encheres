package fr.eni.encheres.servlet;

import com.sun.beans.decoder.ValueObject;
import fr.eni.encheres.bll.UtilisateursManager;
import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
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
        //System.out.println(request.getParameter("pseudo"));
        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("MotDePasse");
        users = usersManager.selectionnerTousLesUtilisateurs(pseudo, mdp);
        request.setAttribute("users", users);
        String bddPseudo = users.getPseudo();
        //System.out.println(bddPseudo);
        if (bddPseudo == null) {
            response.sendRedirect("loginFailed.jsp");
        } else {
            //Session part
            HttpSession session = request.getSession();
            session.setAttribute("user", pseudo);
            session.setMaxInactiveInterval(10 * 60); //setting session to expiry in 10 min
            //Cookie part
            Cookie loginCookie = new Cookie("pseudo", pseudo);
            loginCookie.setMaxAge(10 * 60); //setting cookie to expiry in 10 min
            response.addCookie(loginCookie);
            response.sendRedirect("loginSuccess.jsp");
        }
    }
}