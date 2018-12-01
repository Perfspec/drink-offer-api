package com.qa.business.service;

import com.qa.persistence.domain.Bar;

public interface IBarService {

	String getAll();

	Bar find(Long id);

	String delete(Long id);

	String create(String bar);

	String update(Long id, String bar);

	String getLoLa(double longitude, double latitude, int listLength);

	String getEN(Long easting, Long northing, int listLength);

}
