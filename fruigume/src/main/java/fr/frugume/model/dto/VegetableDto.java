package fr.frugume.model.dto;

import fr.frugume.utils.ComparableUtils;
/**
 * DTO fruits et legumes.
 */
public class VegetableDto implements Comparable<VegetableDto> {
	
	/** identifiant. */
	private Integer id;

	/** Nom du fruit/légume. */
	private String name;

	/** Description du fruit/légume. */
	private String description;

	/** Poids moyen en g. d'un fruit/légume. */
	private int averageWeight;

	/** Prix par unité de mesure. */
	private double price;

	/** Unité de mesure : Pièce u/Poids w. */
	private String unit;
	
	@Override
	public int compareTo(VegetableDto o) {
		return ComparableUtils.safeStringCompare(name, o.getName());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAverageWeight() {
		return averageWeight;
	}

	public void setAverageWeight(int averageWeight) {
		this.averageWeight = averageWeight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
