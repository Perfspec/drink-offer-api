package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idOffer")
	private Long idOffer;
	private double price;
	
	@JoinColumn(name="idBar")
	private Long idBar;
	
	@JoinColumn(name="idDrink")
	private Long idDrink;
	
	@JoinColumn(name="idBrewery")
	private Long idBrewery;
	
	@Override
	public String toString() {
		return "{" 
				+ "\"idOffer\":" + "\"" + this.idOffer + "\"" + "," 
				+ "\"price\":" + "\"" + this.price + "\"" + ","
				+ "\"idBar\":" + "\"" + this.idBar + "\""+ ","
				+ "\"idDrink\":" + "\"" + this.idDrink + "\""+ ","
				+ "\"idBrewery\":" + "\"" + this.idBrewery + "\""
				+ "}";
	}
	
	public Offer() {}

	public Offer(double price, Long idBar, Long idDrink, Long idBrewery) {
		this.price = price;
		this.idBar = idBar;
		this.idDrink = idDrink;
		this.idBrewery = idBrewery;
	}

	public Long getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(Long idOffer) {
		this.idOffer = idOffer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getIdBar() {
		return idBar;
	}

	public void setIdBar(Long idBar) {
		this.idBar = idBar;
	}

	public Long getIdDrink() {
		return idDrink;
	}

	public void setIdDrink(Long idDrink) {
		this.idDrink = idDrink;
	}

	public Long getIdBrewery() {
		return idBrewery;
	}

	public void setIdBrewery(Long idBrewery) {
		this.idBrewery = idBrewery;
	}

		
}
