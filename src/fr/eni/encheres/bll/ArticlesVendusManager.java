package fr.eni.encheres.bll;


import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.ArticleVendusDAOJdbcImpl;
import fr.eni.encheres.dal.ArticlesVendusDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticlesVendusManager {
    private ArticlesVendusDAO articlesVendusDAO = new ArticleVendusDAOJdbcImpl();

    public List<ArticlesVendus> selectionnerTousLesArticles() throws SQLException {
        return articlesVendusDAO.listeArticleDuJour();
    }

    public ArticlesVendus ajouter(String nom_article, String description, LocalDate date_debut_encheres, LocalDate date_fin_encheres, int prix_initial,
                                  int no_utilisateur, int no_categorie) {
        ArticlesVendus article = new ArticlesVendus();
        Utilisateurs user = new Utilisateurs();
        Categories categorie = new Categories();

        article.setNomArticle(nom_article);
        article.setDescription(description);
        article.setDateDebutEncheres(date_debut_encheres);
        article.setDateFinEncheres(date_fin_encheres);
        article.setMiseAPrix(prix_initial);
        user.setNo_utilisateur(no_utilisateur);
        categorie.setNo_categorie(no_categorie);
        article.setUtilisateur(user);
        article.setCategorie(categorie);
        System.out.println(article);
        this.articlesVendusDAO.insert(article);
        return article;
    }

    public List<ArticlesVendus> listerParCategorie(int no_categorie) {
        return articlesVendusDAO.trierParCategorie(no_categorie);
    }

    public List<ArticlesVendus> listerParFiltre(String achatsSelected) throws SQLException {
        return articlesVendusDAO.trierParFiltre(achatsSelected);
    }

    public ArticlesVendus modifierPrixVente(int prixVente, int noArt) throws SQLException {
        ArticlesVendus articlesVendus = new ArticlesVendus();
        articlesVendus.setPrixVente(prixVente);
        articlesVendus.setNoArticle(noArt);

        this.articlesVendusDAO.insertPrix(articlesVendus);
        return articlesVendus;
    }
}
