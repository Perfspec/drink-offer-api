package com.qa.business.service;

import com.qa.persistence.domain.Drink;

public interface IDrinkService {

	String getAll();

	Drink find(Long id);

	String delete(Long id);

	String create(String drink);

	String update(Long id, String drink);

}
