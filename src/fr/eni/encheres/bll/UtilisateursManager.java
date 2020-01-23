package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateursDAO;

import java.util.List;

public class UtilisateursManager {
    private UtilisateursDAO utilisateursDAO;

    public UtilisateursManager() {
        this.utilisateursDAO = DAOFactory.getUtilisateursDAO();
    }

    public Utilisateurs ajouter(String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
        Utilisateurs users = new Utilisateurs();
        users.setPseudo(pseudo);
        users.setNom(nom);
        users.setPrenom(prenom);
        users.setEmail(email);
        users.setTelephone(telephone);
        users.setRue(rue);
        users.setCode_postal(code_postal);
        users.setVille(ville);
        users.setMot_de_passe(mot_de_passe);
        users.setCredit(credit);
        users.setAdministrateur(administrateur);

        this.utilisateursDAO.insert(users);
        return users;
    }

    public Utilisateurs selectionnerTousUtilisateurs() {
        Utilisateurs users = new Utilisateurs();
        this.utilisateursDAO.findAll(users);

        return users;
    }

}
