package fr.eni.encheres.dal;

public class DAOFactory {
    public static UtilisateursDAO getUtilisateursDAO() {
        return new UtilisateursDAOJdbcImpl();
    }
}