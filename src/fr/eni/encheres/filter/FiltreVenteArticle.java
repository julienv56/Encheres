package fr.eni.encheres.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebFilter("/userConnect/*")
public class FiltreVenteArticle implements Filter {

    public void destroy(){

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();
        if(session.getAttribute("user") != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            RequestDispatcher rd = req.getRequestDispatcher("/connectToi.jsp");
            rd.forward(req, resp);
        }
    }
}
