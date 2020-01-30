package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateurs;

import java.sql.*;
import java.time.LocalDate;

public class RetraitDAOJdbcImpl implements RetraitDAO {
    private static final String SELECT_BY_ID = "SELECT r.no_article as no_article, r.rue as rue, r.code_postal as code_postal, r.ville as ville, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, a.no_utilisateur as a_no_utilisateur, a.no_categorie as a_no_categorie, pseudo, c.libelle as c_libelle FROM RETRAITS r " +
            "JOIN ARTICLES_VENDUS a ON a.no_article = r.no_article " +
            "JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur " +
            "JOIN CATEGORIES c ON c.no_categorie = a.no_categorie " +
            "WHERE r.no_article = ?";

    private static final String INSERT = "INSERT INTO RETRAITS VALUES (?,?,?,?)";
    @Override
    public Retrait selectionnerArticleParId(int no_article) {
        Retrait retrait = new Retrait();
        ArticlesVendus article = new ArticlesVendus();
        Categories categorie = new Categories();
        Utilisateurs user = new Utilisateurs();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, no_article);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                retrait = RetraitBuilder(rs);
                article = ArticleBuilder(rs);
                user.setNo_utilisateur(rs.getInt("a_no_utilisateur"));
                user.setPseudo(rs.getString("pseudo"));
                categorie.setNo_categorie(rs.getInt("a_no_categorie"));
                categorie.setLibelle(rs.getString("c_libelle"));
                article.setUtilisateur(user);
                article.setCategorie(categorie);
                retrait.setArticle(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retrait;
    }

    @Override
    public void insert(ArticlesVendus article, String rueRetrait, String codePostalRetrait, String villeRetrait) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT);
            pstmt.setString(1, String.valueOf(article.getNoArticle()));
            pstmt.setString(2, rueRetrait);
            pstmt.setString(3, codePostalRetrait);
            pstmt.setString(4, villeRetrait);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private ArticlesVendus ArticleBuilder(ResultSet rs) throws SQLException {
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

    private Retrait RetraitBuilder(ResultSet rs) throws  SQLException {
        Retrait retrait = new Retrait();
        retrait.setRue(rs.getString("rue"));
        retrait.setCode_postal(rs.getString("code_postal"));
        retrait.setVille(rs.getString("ville"));
        return retrait;

    }
}
