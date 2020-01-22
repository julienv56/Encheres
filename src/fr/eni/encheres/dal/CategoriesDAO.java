package fr.eni.encheres.dal;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import fr.eni.encheres.bo.Categories;

import java.util.List;

public interface CategoriesDAO {

    List<Categories> findAll();
}
