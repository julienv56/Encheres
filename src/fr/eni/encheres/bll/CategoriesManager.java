package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.CategoriesDAO;

import java.util.List;

public class CategoriesManager {
    private CategoriesDAO categorieDAO;

    public List<Categories> selectionnerToutesLesCategories() {
        return categorieDAO.findAll();
    }
}
