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

import com.qa.persistence.domain.Drink;
import com.qa.util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class DrinkDBRepo implements DrinkRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	JSONUtil util;
	
	public String getAll() {
		Query q = em.createQuery("Select a FROM Drink a");
		@SuppressWarnings("unchecked")
		Collection<Drink> drinks = (Collection<Drink>) q.getResultList();
		return util.toJSON(drinks);
	}


	public Drink find(Long id) {
		return em.find(Drink.class, id);
	}

	@Transactional(REQUIRED)
	public String delete(Long id) {
		if(em.find(Drink.class, id) != null) {
			em.remove(em.find(Drink.class, id));
			return "{\"message\": \"Drink sucessfully deleted\"}";
		} else {
			return "{\"message\": \"Drink not deleted\"}";
		}
	}

	@Transactional(REQUIRED)
	public String create(String drink) {
		Drink m = util.fromJSON(drink, Drink.class);
		em.persist(m);		
		return "{\"message\": \"Drink successfully added\"}";
	}

	@Transactional(REQUIRED)
	public String update(Long id, String drink) {
		Drink newDrink = util.fromJSON(drink, Drink.class);
		Drink oldDrink = em.find(Drink.class, id);
		
		oldDrink.setIdDrink(newDrink.getIdDrink());
		oldDrink.setName(newDrink.getName());
		oldDrink.setLogoUrl(newDrink.getLogoUrl());
		
		return "{\"message\": \"Drink successfully updated\"}";
	}

}
