package fr.eni.encheres.bll;

import fr.eni.encheres.bo.ArticlesVendus;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EncheresDAO;
import fr.eni.encheres.dal.EncheresDAOJdbcImpl;

import javax.rmi.CORBA.Util;
import java.sql.SQLException;
import java.sql.Date;

public class EncheresManager {
    private EncheresDAO encheresDAO = new EncheresDAOJdbcImpl();

    public Encheres ajouter(Utilisateurs user, ArticlesVendus art, Date date_enchere, int montant_enchere) throws SQLException {
        Encheres encheres = new Encheres();
        encheres.setUser(user);
        encheres.setArticle(art);
        encheres.setDate_enchere(date_enchere);
        encheres.setMontant_enchere(montant_enchere);

        this.encheresDAO.insert(encheres);
        return encheres;
    }

    public Encheres modifierEnchere(Utilisateurs user, Date date_enchere, int montant_enchere, ArticlesVendus art) throws SQLException {
        Encheres encheres = new Encheres();
        encheres.setUser(user);
        encheres.setDate_enchere(date_enchere);
        encheres.setMontant_enchere(montant_enchere);
        encheres.setArticle(art);

        this.encheresDAO.updateEnchere(encheres);
        return encheres;
    }
}
