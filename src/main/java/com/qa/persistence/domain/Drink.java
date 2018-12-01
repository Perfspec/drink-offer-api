package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Drink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDrink")
	private Long idDrink;
	@Column(length=255)
	private String name;
	@Column(length=255)
	private String logoUrl;
	
	@JoinColumn(name="idBrewery")
	private Long idBrewery;
	private double abv;
	
	@Override
	public String toString() {
		return "{" 
				+ "\"idDrink\":" + "\"" + this.idDrink + "\"" + "," 
				+ "\"name\":" + "\"" + this.name + "\"" + ","
				+ "\"logoUrl\":" + "\"" + this.logoUrl + "\""+ ","
				+ "\"idBrewery\":" + "\"" + this.idBrewery + "\"" + ","
				+ "\"abv\":" + "\"" + this.abv + "\""
				+ "}";
	}
	
	public Drink() {}

	public Drink(String name, String logoUrl, Long idBrewery, double abv) {
		this.name = name;
		this.logoUrl = logoUrl;
		this.idBrewery = idBrewery;
		this.abv = abv;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

	public Long getIdDrink() {
		return idDrink;
	}

	public void setIdDrink(Long idDrink) {
		this.idDrink = idDrink;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public Long getIdBrewery() {
		return idBrewery;
	}

	public void setIdBrewery(Long idBrewery) {
		this.idBrewery = idBrewery;
	}
	
	

}
