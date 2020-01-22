package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateursDAO;

public class UtilisateursManager {
    private UtilisateursDAO utilisateursDAO;

    public UtilisateursManager() {
        this.utilisateursDAO = DAOFactory.getUtilisateursDAO();
    }

    public Utilisateurs ajouter(String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {

        Utilisateurs users = new Utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur);

        this.utilisateursDAO.insert(users);
        return users;
    }
}