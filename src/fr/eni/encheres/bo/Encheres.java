package fr.eni.encheres.bo;

import java.sql.Date;

public class Encheres {
    private Utilisateurs user;
    private ArticlesVendus article;
    private Date date_enchere;
    private int montant_enchere;

    public Encheres() {

    }

    public Utilisateurs getUser() {
        return user;
    }

    public void setUser(Utilisateurs user) {
        this.user = user;
    }

    public ArticlesVendus getArticle() {
        return article;
    }

    public void setArticle(ArticlesVendus article) {

        this.article = article;
    }

    public Date getDate_enchere() {
        return date_enchere;
    }

    public void setDate_enchere(Date date_enchere) {
        this.date_enchere = date_enchere;
    }

    public int getMontant_enchere() {
        return montant_enchere;
    }

    public void setMontant_enchere(int montant_enchere) {
        this.montant_enchere = montant_enchere;
    }

    public Encheres(Utilisateurs user, ArticlesVendus article, Date date_enchere, int montant_enchere) {
        this.user = user;
        this.article = article;
        this.date_enchere = date_enchere;
        this.montant_enchere = montant_enchere;
    }

    @Override
    public String toString() {
        return "Encheres{" +
                "user=" + user +
                ", article=" + article +
                ", date_enchere=" + date_enchere +
                ", montant_enchere=" + montant_enchere +
                '}';
    }
}
