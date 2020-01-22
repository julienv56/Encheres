package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOJdbcImpl implements CategoriesDAO {
    private static final String SELECT_ALL = "SELECT no_categorie,libelle FROM CATEGORIES";

    public List<Categories> findAll() {
        List<Categories> lst = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            Categories categorie = new Categories();
            while (rs.next()) {
                if (rs.getInt("no_categorie") != categorie.getNo_categorie()) {
                    categorie = categorieBuilder(rs);
                    lst.add(categorie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return lst;
    }

    private Categories categorieBuilder(ResultSet rs) throws SQLException {
        Categories categorie = new Categories();
        categorie.setNo_categorie(rs.getInt("no_categorie"));
        categorie.setLibelle(rs.getString("libelle"));
        return categorie;
    }

}
