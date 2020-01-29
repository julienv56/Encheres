package fr.eni.encheres.bll;

import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.RetraitDAO;
import fr.eni.encheres.dal.RetraitDAOJdbcImpl;

public class RetraitManager {
    private RetraitDAO retraitDAO = new RetraitDAOJdbcImpl();

    public Retrait getDetailArticle(int no_article) {
        return retraitDAO.selectionnerArticleParId(no_article);
    }
}
