package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendusDAOJdbcImpl implements ArticlesVendusDAO {

    private static final String SELECT_ARTICLE_DU_JOUR = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, " +
                                                         "prix_initial, prix_vente, a.no_utilisateur as a_no_utilisateur, a.no_categorie as a_no_categorie, pseudo, c.libelle as c_libelle " +
                                                         "FROM ARTICLES_VENDUS a " +
                                                         "JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur " +
                                                         "JOIN CATEGORIES c ON c.no_categorie = a.no_categorie ";
//                                                         "WHERE date_debut_encheres = GETDATE() ";

    @Override
    public List<ArticlesVendus> listeArticleDuJour() {
        ArrayList<ArticlesVendus> listeArticle = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE_DU_JOUR);
            ResultSet rs = pstmt.executeQuery();
            ArticlesVendus article = new ArticlesVendus();
            while (rs.next()) {
                    article = articleBuilder(rs);
                    listeArticle.add(article);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println(listeArticle);
        return listeArticle;
    }

    private ArticlesVendus articleBuilder(ResultSet rs) throws SQLException {
        ArticlesVendus article = new ArticlesVendus();
        Utilisateurs user = new Utilisateurs();
        Categories categorie = new Categories();

        article.setNoArticle(rs.getInt("no_article"));
        article.setNomArticle(rs.getString("nom_article"));
        article.setDescription(rs.getString("description"));
        article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
        article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
        article.setMiseAPrix(rs.getInt("prix_initial"));
        System.out.println(article);
        user.setNo_utilisateur(rs.getInt("a_no_utilisateur"));
        System.out.println(user);
        user.setPseudo(rs.getString("pseudo"));
        categorie.setNo_categorie(rs.getInt("a_no_categorie"));
        categorie.setLibelle(rs.getString("c_libelle"));
        article.setUtilisateur(user);
        article.setCategorie(categorie);
        System.out.println(article);

        return article;
    }
}
