package fr.frugume.model;

public class Article {
	
	/** identifiant du panier. */
	private int quantity;
	
	/** Date de commande. */
	private Integer vegetableId;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getVegetableId() {
		return vegetableId;
	}

	public void setVegetableId(Integer vegetableId) {
		this.vegetableId = vegetableId;
	}
}
