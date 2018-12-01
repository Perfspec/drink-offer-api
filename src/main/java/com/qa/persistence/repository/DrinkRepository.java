package com.qa.persistence.repository;

import com.qa.persistence.domain.Drink;

public interface DrinkRepository {

	String getAll();

	Drink find(Long id);

	String delete(Long id);

	String create(String drink);

	String update(Long id, String drink);

}
