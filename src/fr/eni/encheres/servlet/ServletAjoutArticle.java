package fr.eni.encheres.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajoutArticle")
public class ServletAjoutArticle extends HttpServlet {
public static final long serialVersionUID = 1L;

    public ServletAjoutArticle() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ICI --> GET");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{

        }catch (Exception e){
            e.getStackTrace();
        }

        System.out.println("ICI ---> POST");
        RequestDispatcher rd = req.getRequestDispatcher("/userConnect/venteArticle.jsp");
        System.out.println(rd);
        rd.forward(req, resp);
    }
}
