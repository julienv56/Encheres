package fr.eni.encheres.bll;


import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.dal.ArticleVendusDAOJdbcImpl;
import fr.eni.encheres.dal.ArticlesVendusDAO;

import java.util.List;

public class ArticlesVendusManager {
    private ArticlesVendusDAO articlesVendusDAO = new ArticleVendusDAOJdbcImpl();

    public List<ArticlesVendus> selectionnerTousLesArticles() {
        return articlesVendusDAO.listeArticleDuJour();
    }
}
