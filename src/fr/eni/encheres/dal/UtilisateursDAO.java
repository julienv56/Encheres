package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateurs;

import java.sql.SQLException;
import java.util.List;

public interface UtilisateursDAO {
    public void insert(Utilisateurs users);
    public void findAll() throws SQLException;
}