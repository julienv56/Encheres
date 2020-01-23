package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.CategoriesDAO;
import fr.eni.encheres.dal.CategoriesDAOJdbcImpl;

import java.util.List;

public class CategoriesManager {
    private CategoriesDAO categorieDAO = new CategoriesDAOJdbcImpl();
    public List<Categories> selectionnerToutesLesCategories() {
        System.out.println("HELLO CEST LE MANAGER");
        System.out.println(this);
        return categorieDAO.findAll();
    }
}
