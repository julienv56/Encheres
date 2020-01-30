package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendusDAOJdbcImpl implements ArticlesVendusDAO {

    private static final String SELECT_ARTICLE_DU_JOUR = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, " +
            "prix_initial, prix_vente, a.no_utilisateur as a_no_utilisateur, a.no_categorie as a_no_categorie, pseudo, c.libelle as c_libelle " +
            "FROM ARTICLES_VENDUS a " +
            "JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur " +
            "JOIN CATEGORIES c ON c.no_categorie = a.no_categorie " +
            "WHERE date_debut_encheres = CONVERT(varchar, getdate(), 23) ";

    private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, " +
            "prix_initial, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?)";

    private static final String LISTER_BY_CATEGORIE = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, " +
            "prix_initial, prix_vente, a.no_utilisateur as a_no_utilisateur, a.no_categorie as a_no_categorie, pseudo, c.libelle as c_libelle " +
            "FROM ARTICLES_VENDUS a " +
            "JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur " +
            "JOIN CATEGORIES c ON c.no_categorie = a.no_categorie " +
            "WHERE date_debut_encheres = CONVERT(varchar, getdate(), 23) " +
            "AND a.no_categorie = ?";

    private static final String LISTER_BY_ACHATS = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, " +
            "prix_initial, prix_vente, a.no_utilisateur as a_no_utilisateur, a.no_categorie as a_no_categorie, pseudo, c.libelle as c_libelle " +
            "FROM ARTICLES_VENDUS a " +
            "JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur " +
            "JOIN CATEGORIES c ON c.no_categorie = a.no_categorie ";

    private static final String SELECT_BY_ID = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, " +
            "prix_initial, prix_vente, a.no_utilisateur as a_no_utilisateur, a.no_categorie as a_no_categorie, pseudo, c.libelle as c_libelle " +
            "FROM ARTICLES_VENDUS a " +
            "JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur " +
            "JOIN CATEGORIES c ON c.no_categorie = a.no_categorie " +
            "JOIN RETRAITS ON r.no_article = r.no_article " +
            "WHERE no_article = ?";

    public List<ArticlesVendus> trierParCategorie(int no_categorie) {
        ArrayList<ArticlesVendus> listeArticle = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            if (no_categorie == 0) {
                PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE_DU_JOUR);
                ResultSet rs = pstmt.executeQuery();
                ArticlesVendus article = new ArticlesVendus();
                while (rs.next()) {
                    article = articleBuilder(rs);
                    listeArticle.add(article);
                }
            } else {
                PreparedStatement pstmt = cnx.prepareStatement(LISTER_BY_CATEGORIE);
                pstmt.setInt(1, no_categorie);
                ResultSet rs = pstmt.executeQuery();
                ArticlesVendus article = new ArticlesVendus();
                while (rs.next()) {
                    article = articleBuilder(rs);
                    listeArticle.add(article);
                }
            }

        } catch (Exception e) {

        }
        return listeArticle;
    }

    @Override
    public List<ArticlesVendus> trierParFiltre(String achatsSelected) throws SQLException {
        List<ArticlesVendus> result;
        if (achatsSelected == null) {
            result = listeTrierParFiltre(SELECT_ARTICLE_DU_JOUR);
        } else {
            result = listeTrierParFiltre(LISTER_BY_ACHATS);
        }
        return result;
    }

    private List<ArticlesVendus> listeTrierParFiltre(String query) throws SQLException {
        ArrayList<ArticlesVendus> listeArticle = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            ArticlesVendus article = new ArticlesVendus();
            while (rs.next()) {
                article = articleBuilder(rs);
                listeArticle.add(article);
            }
        }
        return listeArticle;
    }

    @Override
    public List<ArticlesVendus> listeArticleDuJour() throws SQLException {
        List<ArticlesVendus> result;
        result = listeTrierParFiltre(SELECT_ARTICLE_DU_JOUR);
        return result;

    }

    @Override
    public void insert(ArticlesVendus article) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, article.getNomArticle());
            pstmt.setString(2, article.getDescription());
            pstmt.setDate(3, Date.valueOf((LocalDate) article.getDateDebutEncheres()));
            pstmt.setDate(4, Date.valueOf((LocalDate) article.getDateFinEncheres()));
            pstmt.setInt(5, article.getMiseAPrix());
            pstmt.setInt(6, article.getUtilisateur().getNo_utilisateur());
            pstmt.setInt(7, article.getCategorie().getNo_categorie());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                article.setNoArticle(rs.getInt(1));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
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
        user.setNo_utilisateur(rs.getInt("a_no_utilisateur"));
        user.setPseudo(rs.getString("pseudo"));
        categorie.setNo_categorie(rs.getInt("a_no_categorie"));
        categorie.setLibelle(rs.getString("c_libelle"));

        return article;
    }

    private static final String INSERT_PRIX = "UPDATE ARTICLES_VENDUS SET prix_vente = ? WHERE no_article = ?";

    public void insertPrix(ArticlesVendus articlesVendus) throws SQLException {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT_PRIX);
            pstmt.setInt(1, articlesVendus.getPrixVente());
            pstmt.setInt(2, articlesVendus.getNoArticle());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
