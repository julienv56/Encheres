package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.CategoriesDAO;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet("/")
public class CategoriesManager {
    private CategoriesDAO categorieDAO;
    public List<Categories> selectionnerToutesLesCategories(){
        return categorieDAO.findAll();
    }
}
