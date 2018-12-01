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

import com.qa.persistence.domain.Brewery;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default

public class BreweryDBRepo implements BreweryRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	JSONUtil util;
	
	public String getAll() {
		Query q = em.createQuery("Select a FROM Brewery a");
		@SuppressWarnings("unchecked")
		Collection<Brewery> brews = (Collection<Brewery>) q.getResultList();
		return util.toJSON(brews);
	}

	public Brewery find(Long id) {
		return em.find(Brewery.class, id);
	}

	@Transactional(REQUIRED)
	public String delete(Long id) {
		if(em.find(Brewery.class, id) != null) {
			em.remove(em.find(Brewery.class, id));
			return "{\"message\": \"Brewery sucessfully deleted\"}";
		} else {
			return "{\"message\": \"Brewery not deleted\"}";
		}
	}

	@Transactional(REQUIRED)
	public String create(String brewery) {
		Brewery m = util.fromJSON(brewery, Brewery.class);
		em.persist(m);		
		return "{\"message\": \"Brewery successfully added\"}";
	}

	@Transactional(REQUIRED)
	public String update(Long id, String brewery) {
		Brewery newBrewery = util.fromJSON(brewery, Brewery.class);
		Brewery oldBrewery = em.find(Brewery.class, id);
		
		oldBrewery.setIdBrewery(newBrewery.getIdBrewery());
		oldBrewery.setName(newBrewery.getName());
		oldBrewery.setLogoUrl(newBrewery.getLogoUrl());
		
		return "{\"message\": \"Brewery sucessfully updated\"}";
	}

}
