package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Utilisateurs;

import java.sql.*;

public class EncheresDAOJdbcImpl implements EncheresDAO {

    private static final String INSERT = "INSERT INTO ENCHERES(no_utilisateur, no_article,date_enchere, montant_enchere ) VALUES(?,?,?,?) SELECT no_utilisateur FROM UTILISATEURS SELECT no_article FROM RETRAITS;";

    public void insert(Encheres encheres) throws SQLException {

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT);
            pstmt.setInt(1, encheres.getUser().getNo_utilisateur());
            pstmt.setInt(2, encheres.getArticle().getNoArticle());
            pstmt.setDate(3, encheres.getDate_enchere());
            pstmt.setInt(4, encheres.getMontant_enchere());
            pstmt.executeUpdate();
        }
    }

    private static final String UPDATE_ENCHERE = "UPDATE ENCHERES SET no_utilisateur = ?, date_enchere = ?, montant_enchere = ? WHERE no_article = ?";

    public void updateEnchere(Encheres encheres) throws SQLException {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ENCHERE);
            pstmt.setInt(1, encheres.getUser().getNo_utilisateur());
            pstmt.setDate(2, encheres.getDate_enchere());
            pstmt.setInt(3, encheres.getMontant_enchere());
            pstmt.setInt(4, encheres.getArticle().getNoArticle());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String CREDITER = "UPDATE UTILISATEURS " +
            "SET credit = credit + montant_enchere " +
            "FROM UTILISATEURS JOIN ENCHERES E on UTILISATEURS.no_utilisateur = E.no_utilisateur " +
            "WHERE no_article = ?";

    public void crediter(ArticlesVendus articlesVendus) throws SQLException {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(CREDITER);
            pstmt.setInt(1, articlesVendus.getNoArticle());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

