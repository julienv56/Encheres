package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Categories;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendusDAOJdbcImpl implements ArticlesVendusDAO {

    private static final String SELECT_ARTICLE_DU_JOUR = "SELECT no_article, nom_article, description, date_debut_enchere";

    @Override
    public List<ArticlesVendus> listeArticleDuJour() {
        ArrayList<ArticlesVendus> listeArticle = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ARTICLE_DU_JOUR);
            ArticlesVendus article = new ArticlesVendus();
            while (rs.next()) {

                    article = articleBuilder(rs);
                    listeArticle.add(article);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listeArticle;
    }

    private ArticlesVendus articleBuilder(ResultSet rs) throws SQLException {
        ArticlesVendus article = new ArticlesVendus();
        article.setNoArticle(rs.getInt("no_article"));
        article.setNomArticle(rs.getString("nom_article"));
        return article;
    }
}
