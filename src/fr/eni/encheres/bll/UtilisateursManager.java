package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateursDAO;
import fr.eni.encheres.dal.UtilisateursDAOJdbcImpl;

public class UtilisateursManager {
    private UtilisateursDAO utilisateursDAO = new UtilisateursDAOJdbcImpl();

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

    public Utilisateurs selectionnerTousLesUtilisateurs(String pseudo, String mdp) {
        return utilisateursDAO.findPseudo(pseudo, mdp);
    }

    public Utilisateurs supprimerProfilUtilisateurs(Integer no_utilisateur) {
        Utilisateurs users = new Utilisateurs();
        users.setNo_utilisateur(no_utilisateur);
        this.utilisateursDAO.supprimerProfil(users);

        return users;
    }

    public Utilisateurs modifier(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, int credit) {
        Utilisateurs users = new Utilisateurs();
        users.setNo_utilisateur(no_utilisateur);
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

        this.utilisateursDAO.edit(users);
        return users;
    }

}