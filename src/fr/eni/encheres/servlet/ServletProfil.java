package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.UtilisateursManager;
import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletProfil")
public class ServletProfil extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfil() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            response.sendRedirect("profil.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int id = ((Utilisateurs) session.getAttribute("user")).getNo_utilisateur();
            String pseudo = ((Utilisateurs) session.getAttribute("user")).getPseudo();
            UtilisateursManager usersManager = new UtilisateursManager();
            Utilisateurs users = new Utilisateurs();

            Cookie loginCookie = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    loginCookie = cookie;
                    loginCookie.setMaxAge(0);
                    response.addCookie(loginCookie);
                }
            }
            users = usersManager.supprimerProfilUtilisateurs(id);
            response.sendRedirect("/Encheres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
