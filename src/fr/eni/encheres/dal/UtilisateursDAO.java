package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateurs;

import java.util.List;

public interface UtilisateursDAO {
    public void insert(Utilisateurs users);

    List<Utilisateurs> findAll();

}