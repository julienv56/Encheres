package fr.eni.encheres.bo;

import java.time.LocalDate;

public class ArticlesVendus {

	//paramètres de classe
	private String noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private String etatVente;
	
	//liaisons
	private Utilisateurs no_utilisateur;
	private Categories no_categorie;
	
	public ArticlesVendus(){
	}
	
	public ArticlesVendus(String noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente, Utilisateurs no_utilisateur,
			Categories no_categorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}

	public String getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(String noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public Utilisateurs getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(Utilisateurs no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public Categories getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(Categories no_categorie) {
		this.no_categorie = no_categorie;
	}

	@Override
	public String toString() {
		return "ArticlesVendus [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", no_utilisateur="
				+ no_utilisateur + ", no_categorie=" + no_categorie + "]";
	}

	
	
	
}
