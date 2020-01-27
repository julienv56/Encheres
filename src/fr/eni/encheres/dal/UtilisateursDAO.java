package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateurs;

public interface UtilisateursDAO {
    public void insert(Utilisateurs users);

    Utilisateurs findPseudo(String pseudo, String mot_de_passe);

    public void supprimerProfil(Utilisateurs users);
}