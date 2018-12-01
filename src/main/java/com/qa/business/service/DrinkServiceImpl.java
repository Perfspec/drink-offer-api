package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Drink;
import com.qa.persistence.repository.DrinkRepository;

public class DrinkServiceImpl implements IDrinkService {
	
	@Inject
	DrinkRepository repo;

	public String getAll() {
		return repo.getAll();
	}

	public Drink find(Long id) {
		return repo.find(id);
	}

	public String delete(Long id) {
		return repo.delete(id);
	}

	public String create(String drink) {
		return repo.create(drink);
	}

	public String update(Long id, String drink) {
		return repo.update(id, drink);
	}

}
