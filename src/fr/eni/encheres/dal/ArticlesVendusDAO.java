package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;

import java.sql.SQLException;
import java.util.List;

public interface ArticlesVendusDAO {

    List<ArticlesVendus> trierParCategorie(int no_categorie);
    List<ArticlesVendus> trierParFiltre(String achatsSelected) throws SQLException;

    List<ArticlesVendus> listeArticleDuJour() throws SQLException;

    void insert(ArticlesVendus article);

}
