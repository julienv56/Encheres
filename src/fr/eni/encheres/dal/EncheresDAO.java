package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Encheres;

import java.sql.SQLException;

public interface EncheresDAO {
    public void insert(Encheres encheres) throws SQLException;

    public void updateEnchere(Encheres encheres) throws SQLException;

    public void crediter(ArticlesVendus articlesVendus) throws SQLException;
}
