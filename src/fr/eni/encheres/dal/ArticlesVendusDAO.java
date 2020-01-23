package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticlesVendus;

import java.util.List;

public interface ArticlesVendusDAO {

    List<ArticlesVendus> listeArticleDuJour();
}
