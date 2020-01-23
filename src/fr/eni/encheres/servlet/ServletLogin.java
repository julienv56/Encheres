package fr.eni.encheres.servlet;

import com.sun.beans.decoder.ValueObject;
import fr.eni.encheres.bll.UtilisateursManager;
import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        UtilisateursManager usersManager = new UtilisateursManager();
        Utilisateurs users = new Utilisateurs();
        System.out.println(request.getParameter("pseudo"));
        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("MotDePasse");
        users = usersManager.selectionnerTousLesUtilisateurs(pseudo, mdp);
        request.setAttribute("users", users);
        String bddPseudo = users.getPseudo();
        System.out.println(bddPseudo);
        if (bddPseudo == null) {
            response.sendRedirect("loginFailed.jsp");
        } else {
            //Cookie part
            Cookie loginCookie = new Cookie("pseudo", pseudo);
            loginCookie.setMaxAge(5 * 60); //setting cookie to expiry in 30 min
            response.addCookie(loginCookie);
            response.sendRedirect("loginSuccess.jsp");
        }
    }
}