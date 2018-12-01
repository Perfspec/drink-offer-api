package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Brewery;
import com.qa.persistence.repository.BreweryRepository;

public class BreweryServiceImpl implements IBreweryService {
	
	@Inject
	BreweryRepository repo;

	public String getAll() {
		return repo.getAll();
	}

	public Brewery find(Long id) {
		return repo.find(id);
	}

	public String delete(Long id) {
		return repo.delete(id);
	}

	public String create(String brewery) {
		return repo.create(brewery);
	}

	public String update(Long id, String brewery) {
		return repo.update(id, brewery);
	}

}
