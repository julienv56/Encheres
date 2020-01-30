package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Encheres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}

