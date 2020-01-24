package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.UtilisateursManager;
import fr.eni.encheres.bo.Utilisateurs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

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
            UtilisateursManager usersManager = new UtilisateursManager();
            Utilisateurs users = new Utilisateurs();
            String pseudo = ((String) session.getAttribute("user"));
            System.out.println("hello");
            System.out.println(pseudo);
            //users = usersManager.selectionnerProfilDuPseudo(pseudo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
