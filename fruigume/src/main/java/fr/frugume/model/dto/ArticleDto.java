package fr.frugume.model.dto;

public class ArticleDto {
	
	/** identifiant du panier. */
	private int quantity;
	
	/** Date de commande. */
	private VegetableDto vegetable;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public VegetableDto getVegetable() {
		return vegetable;
	}

	public void setVegetable(VegetableDto vegetable) {
		this.vegetable = vegetable;
	}
}
