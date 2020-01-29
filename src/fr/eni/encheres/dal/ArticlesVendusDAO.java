package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;

import java.util.List;

public interface ArticlesVendusDAO {

    List<ArticlesVendus> trierParCategorie(int no_categorie);
    List<ArticlesVendus> trierParFiltre(String achatsSelected);

    List<ArticlesVendus> listeArticleDuJour();

    void insert(ArticlesVendus article);

}
