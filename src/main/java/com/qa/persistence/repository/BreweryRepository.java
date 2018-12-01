package com.qa.persistence.repository;

import com.qa.persistence.domain.Brewery;

public interface BreweryRepository {

	String getAll();

	Brewery find(Long id);

	String delete(Long id);

	String create(String brewery);

	String update(Long id, String brewery);

}
