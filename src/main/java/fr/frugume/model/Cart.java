package fr.frugume.model;

import java.util.List;

public class Cart {

	/** identifiant du panier. */
	private Integer id;

	/** Date de commande. */
	private String date;
	
	/** identifiant du client. */
	private Integer userId;

	/**
	 * statut du panier. (A : A préparer, P : prêt, R : Retiré, N : Annulé)
	 */
	private String status;

	/** Liste des articles */
	List<Article> articles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
