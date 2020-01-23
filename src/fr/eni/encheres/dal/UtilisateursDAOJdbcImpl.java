package fr.eni.encheres.dal;

import java.sql.*;
import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;

class UtilisateursDAOJdbcImpl implements UtilisateursDAO {


    //    private static final String INSERT = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    private static final String INSERT = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?);";

    public void insert(Utilisateurs users) {

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, users.getPseudo());
            pstmt.setString(2, users.getNom());
            pstmt.setString(3, users.getPrenom());
            pstmt.setString(4, users.getEmail());
            pstmt.setString(5, users.getTelephone());
            pstmt.setString(6, users.getRue());
            pstmt.setString(7, users.getCode_postal());
            pstmt.setString(8, users.getVille());
            pstmt.setString(9, users.getMot_de_passe());
            pstmt.setInt(10, users.getCredit());
            pstmt.setBoolean(11, users.isAdministrateur());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                users.setNo_utilisateur(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String GETUSERS = "SELECT pseudo, mot_de_passe FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";

    public void findAll(Utilisateurs users) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(GETUSERS);
            pstmt.setString(1, users.getPseudo());
            pstmt.setString(2, users.getNom());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}