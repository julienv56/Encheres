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

    private static final String GET = "SELECT * FROM ENCHERES WHERE no_article = ?";

    public Encheres getEnchere(ArticlesVendus articlesVendus) throws SQLException {
        Encheres encheres = new Encheres();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(GET);
            pstmt.setInt(1, articlesVendus.getNoArticle());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                encheres = encheresBuilder(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return encheres;
    }

    private Encheres encheresBuilder(ResultSet rs) throws SQLException {
        Encheres encheres = new Encheres();
        encheres.getArticle().setNoArticle(rs.getInt("no_article"));
        //encheres.getUser().setNo_utilisateur();
        return encheres;
    }

}

