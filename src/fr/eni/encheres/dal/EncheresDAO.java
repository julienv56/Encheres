package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Utilisateurs;

import java.sql.SQLException;

public interface EncheresDAO {
    public void insert(Encheres encheres) throws SQLException;

    Encheres getEnchere(ArticlesVendus articlesVendus) throws SQLException;
}
