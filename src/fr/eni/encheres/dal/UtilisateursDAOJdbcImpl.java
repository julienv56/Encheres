package fr.eni.encheres.dal;

import java.sql.*;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;

import javax.rmi.CORBA.Util;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {

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

    private static final String GETUSERS = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";

    public Utilisateurs findPseudo(String pseudo, String mot_de_passe) {
        Utilisateurs users = new Utilisateurs();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(GETUSERS);
            pstmt.setString(1, pseudo);
            pstmt.setString(2, mot_de_passe);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users = utilisateurBuilder(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private Utilisateurs utilisateurBuilder(ResultSet rs) throws SQLException {
        Utilisateurs users = new Utilisateurs();
        users.setNo_utilisateur(rs.getInt("no_utilisateur"));
        users.setPseudo(rs.getString("pseudo"));
        users.setMot_de_passe(rs.getString("mot_de_passe"));
        users.setNom(rs.getString("nom"));
        users.setPrenom(rs.getString("prenom"));
        users.setEmail(rs.getString("email"));
        users.setTelephone(rs.getString("telephone"));
        users.setRue(rs.getString("rue"));
        users.setCode_postal(rs.getString("code_postal"));
        users.setVille(rs.getString("ville"));
        users.setCredit(rs.getInt("credit"));
        return users;
    }

    private static final String GETPROFIL = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";

    public Utilisateurs getProfil(String pseudo) {
        Utilisateurs users = new Utilisateurs();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(GETPROFIL);
            pstmt.setString(1, pseudo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users = profilBuilder(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private Utilisateurs profilBuilder(ResultSet rs) throws SQLException {
        Utilisateurs users = new Utilisateurs();
        users.setPseudo(rs.getString("pseudo"));
        return users;
    }

    private static final String SUPPPROFIL = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";

    public void supprimerProfil(Utilisateurs users) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SUPPPROFIL);
            pstmt.setInt(1, users.getNo_utilisateur());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}