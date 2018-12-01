package com.qa.business.service;

import com.qa.persistence.domain.Brewery;

public interface IBreweryService {

	String getAll();

	Brewery find(Long id);

	String delete(Long id);

	String create(String brewery);

	String update(Long id, String brewery);
	
}
