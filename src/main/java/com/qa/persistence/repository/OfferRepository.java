package com.qa.persistence.repository;

import com.qa.persistence.domain.Offer;

public interface OfferRepository {

	String getAll();

	Offer find(Long id);

	String delete(Long id);

	String create(String offer);

	String update(Long id, String offer);

}
