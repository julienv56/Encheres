package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Encheres;

import java.sql.SQLException;

public interface EncheresDAO {
    public void insert(Encheres encheres) throws SQLException;
}
