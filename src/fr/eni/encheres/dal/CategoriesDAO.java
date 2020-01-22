package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Categories;

import java.util.List;

public interface CategoriesDAO {
    List<Categories> findAll();
}
