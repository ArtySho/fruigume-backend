package fr.frugume.model.dto;

import java.util.Date;
import java.util.List;

public class CartDto implements Comparable<CartDto> {
	
	/** identifiant du panier. */
	private Integer id;

	/** Date de commande. */
	private Date date;
	
	/** acheteur. */
	private UserDto user;

	/**
	 * statut du panier. (A : A préparer, P : prêt, R : Retiré, N : Annulé)
	 */
	private String status;

	/** Liste des articles */
	List<ArticleDto> articles;

	
	@Override
	public int compareTo(CartDto o) {
		if (date.before(o.getDate())){
			return -1;
		}
		if (date.after(o.getDate())){
			return 1;
		}
		return 0;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public UserDto getUser() {
		return user;
	}


	public void setUser(UserDto user) {
		this.user = user;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<ArticleDto> getArticles() {
		return articles;
	}


	public void setArticles(List<ArticleDto> articles) {
		this.articles = articles;
	}
}

