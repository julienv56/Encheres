package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateurs;

public interface UtilisateursDAO {
    public void insert(Utilisateurs users);

    public void getUsers(Utilisateurs users);

}