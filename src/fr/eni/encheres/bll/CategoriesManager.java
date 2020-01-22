package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.CategoriesDAO;

import java.util.List;

public class CategoriesManager {
    private CategoriesDAO categorieDAO;

    public List<Categories> selectionnerToutesLesCategories() {
        System.out.println("HELLO CEST LE MANAGER");
        return this.categorieDAO.findAll();
    }
}
