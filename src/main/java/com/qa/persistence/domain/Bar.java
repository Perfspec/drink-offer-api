package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idBar")
	private Long idBar;
	@Column(length=255)
	private String name;
	@Column(length=255)
	private String address;
	@Column(length=9)
	private String postcode;
	private Long easting;
	private Long northing;
	private double latitude;
	private double longitude;
	@Column(length=45)
	private String local_authority;
	
	public String toString() {
		return "{" 
				+ "\"idBar\": " + "\"" + this.idBar + "\"" + "," 
				+ "\"name\": " + "\"" + this.name + "\"" + ","
				+ "\"address\": " + "\"" + this.address + "\""+ ","
				+ "\"postcode\": " + "\"" + this.postcode + "\"" + ","
				+ "\"easting\": " + "\"" + this.easting + "\"" + ","
				+ "\"northing\": " + "\"" + this.northing + "\"" + ","
				+ "\"latitude\": " + "\"" + this.latitude + "\"" + ","
				+ "\"longitude\": " + "\"" + this.longitude + "\"" + ","
				+ "\"local_authority\": " + "\"" + this.local_authority + "\""
				+ "}";
	}
	
	public Bar(){}

	public Bar(String name, String address, String postcode, Long easting, Long northing, double latitude,
			double longitude, String localAuthority) {
		this.name = name;
		this.address = address;
		this.postcode = postcode;
		this.easting = easting;
		this.northing = northing;
		this.latitude = latitude;
		this.longitude = longitude;
		this.local_authority = localAuthority;
	}

	public Long getIdBar() {
		return idBar;
	}

	public void setIdBar(Long idBar) {
		this.idBar = idBar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Long getEasting() {
		return easting;
	}

	public void setEasting(Long easting) {
		this.easting = easting;
	}

	public Long getNorthing() {
		return northing;
	}

	public void setNorthing(Long northing) {
		this.northing = northing;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getLocalAuthority() {
		return local_authority;
	}

	public void setLocalAuthority(String localAuthority) {
		this.local_authority = localAuthority;
	}
	
}
