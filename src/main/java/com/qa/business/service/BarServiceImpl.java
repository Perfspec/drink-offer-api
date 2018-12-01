package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Bar;
import com.qa.persistence.repository.BarRepository;

public class BarServiceImpl implements IBarService {
	
	@Inject
	BarRepository repo;

	public String getAll() {
		return repo.getAll();
	}

	public Bar find(Long id) {
		return repo.find(id);
	}

	public String delete(Long id) {
		return repo.delete(id);
	}

	public String create(String bar) {
		return repo.create(bar);
	}

	public String update(Long id, String bar) {
		return repo.update(id, bar);
	}


	public String getLoLa(double longitude, double latitude, int listLength) {
		return repo.getLoLa(longitude,latitude,listLength);
	}
	

	public String getEN(Long easting, Long northing, int listLength) {
		return repo.getEN(easting,northing,listLength);
	}

}
