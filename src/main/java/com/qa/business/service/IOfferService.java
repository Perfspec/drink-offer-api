package com.qa.business.service;

import com.qa.persistence.domain.Offer;

public interface IOfferService {

	String getAll();

	Offer find(Long id);

	String delete(Long id);

	String create(String offer);

	String update(Long id, String offer);

}
