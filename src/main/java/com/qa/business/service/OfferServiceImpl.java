package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Offer;
import com.qa.persistence.repository.OfferRepository;

public class OfferServiceImpl implements IOfferService {

	@Inject
	OfferRepository repo;
	
	public String getAll() {
		return repo.getAll();
	}

	public Offer find(Long id) {
		return repo.find(id);
	}

	public String delete(Long id) {
		return repo.delete(id);
	}

	public String create(String offer) {
		return repo.create(offer);
	}

	public String update(Long id, String offer) {
		return repo.update(id, offer);
	}

}
