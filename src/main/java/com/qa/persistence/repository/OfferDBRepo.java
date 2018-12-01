package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Offer;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class OfferDBRepo implements OfferRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	JSONUtil util;

	public String getAll() {
		Query q = em.createQuery("Select a FROM Offer a");
		@SuppressWarnings("unchecked")
		Collection<Offer> offers = (Collection<Offer>) q.getResultList();
		return util.toJSON(offers);
	}

	public Offer find(Long id) {
		return em.find(Offer.class, id);
	}

	@Transactional(REQUIRED)
	public String delete(Long id) {
		if(em.find(Offer.class, id) != null) {
			em.remove(em.find(Offer.class, id));
			return "{\"message\": \"Offer sucessfully deleted\"}";
		} else {
			return "{\"message\": \"Offer not deleted\"}";
		}
	}

	@Transactional(REQUIRED)
	public String create(String offer) {
		Offer m = util.fromJSON(offer, Offer.class);
		em.persist(m);		
		return "{\"message\": \"Offer successfully added\"}";
	}

	@Transactional(REQUIRED)
	public String update(Long id, String offer) {
		Offer newOffer = util.fromJSON(offer, Offer.class);
		Offer oldOffer = em.find(Offer.class, id);
		
		oldOffer.setIdOffer(newOffer.getIdOffer());
		oldOffer.setPrice(newOffer.getPrice());
		oldOffer.setIdBar(newOffer.getIdBar());
		oldOffer.setIdDrink(newOffer.getIdDrink());
		oldOffer.setIdBrewery(newOffer.getIdBrewery());
		
		return "{\"message\": \"Offer sucessfully updated\"}";
	}

}
