package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Retrait;

public interface RetraitDAO {
    Retrait selectionnerArticleParId(int no_article);
}
