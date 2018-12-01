package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brewery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idBrewery")
	private Long idBrewery;
	@Column(length=255)
	private String name;
	@Column(length=255)
	private String logoUrl;
	
	@Override
	public String toString() {
		return "{" 
				+ "\"idBrewery\":" + "\"" + this.idBrewery + "\"" + "," 
				+ "\"name\":" + "\"" + this.name + "\"" + ","
				+ "\"logoUrl\":" + "\"" + this.logoUrl + "\""
				+ "}";
	}
	
	public Brewery() {}
	
	public Brewery(String name, String logoUrl) {
		this.name = name;
		this.logoUrl = logoUrl;
	}

	public Long getIdBrewery() {
		return idBrewery;
	}

	public void setIdBrewery(Long idBrewery) {
		this.idBrewery = idBrewery;
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
	
	
	
}
