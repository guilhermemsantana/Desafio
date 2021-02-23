package com.beerhouse.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Beer{
	
	@Id
	private Integer id;
	private String name;
	private String ingredients;
	private String alcoholContent;
	private Number price;
	private String category;
	
	public Beer() {}
	
	public Beer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Beer(Integer id, String name, String ingredients, String alcoholContent, Number price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.alcoholContent = alcoholContent;
		this.price = price;
		this.category = category;
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

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getAlcoholContent() {
		return alcoholContent;
	}

	public void setAlcoholContent(String alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	public Number getPrice() {
		return price;
	}

	public void setPrice(Number price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
