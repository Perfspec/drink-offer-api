package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Bar;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class BarDBRepo implements BarRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	JSONUtil util;

	public String getAll() {
		Query q = em.createQuery("Select a FROM Bar a");
		@SuppressWarnings("unchecked")
		Collection<Bar> bars = (Collection<Bar>) q.getResultList();
		return util.toJSON(bars);
	}

	public Bar find(Long id) {
		return em.find(Bar.class, id);
	}

	@Transactional(REQUIRED)
	public String delete(Long id) {
		if(em.find(Bar.class, id) != null) {
			em.remove(em.find(Bar.class, id));
			return "{\"message\": \"Bar sucessfully deleted\"}";
		} else {
			return "{\"message\": \"Bar not deleted\"}";
		}	
	}

	@Transactional(REQUIRED)
	public String create(String bar) {
		Bar m = util.fromJSON(bar, Bar.class);
		em.persist(m);		
		return "{\"message\": \"Bar successfully added\"}";
	}

	@Transactional(REQUIRED)
	public String update(Long id, String bar) {
		Bar newBar = util.fromJSON(bar, Bar.class);
		Bar oldBar = em.find(Bar.class, id);
		
		oldBar.setIdBar(newBar.getIdBar());
		oldBar.setName(newBar.getName());
		oldBar.setAddress(newBar.getAddress());
		oldBar.setPostcode(newBar.getPostcode());
		oldBar.setEasting(newBar.getEasting());
		oldBar.setNorthing(newBar.getNorthing());
		oldBar.setLatitude(newBar.getLatitude());
		oldBar.setLongitude(newBar.getLongitude());
		oldBar.setLocalAuthority(newBar.getLocalAuthority());
		
		return "{\"message\": \"Bar sucessfully updated\"}";
	}

	public String getLoLa(double longitude, double latitude, int listLength) {
		Query q = em.createQuery("Select a FROM Bar a");
		@SuppressWarnings("unchecked")
		List<Bar> bars = q.getResultList();
		bars.sort(Comparator.comparing(bar -> distance(longitude, latitude, bar)));
		Collection<Bar> output = (Collection<Bar>) bars.subList(0, listLength);
		return util.toJSON(output);
	}

	public String getEN(Long easting, Long northing, int listLength) {
		Query q = em.createQuery("Select a FROM Bar a");
		@SuppressWarnings("unchecked")
		List<Bar> bars = q.getResultList();
		bars.sort(Comparator.comparing(bar -> distance(easting, northing, bar)));
		Collection<Bar> output = (Collection<Bar>) bars.subList(0, listLength);
		return util.toJSON(output);
	}
	
	public double distance(double longitude, double latitude, Bar bar) {
		double diffLong = bar.getLongitude()-longitude;
		double diffLat = bar.getLatitude()-latitude;		
		return Math.sqrt(diffLong*diffLong+diffLat*diffLat);
	}
	
	public Long distance(Long easting, Long northing, Bar bar) {
		long diffE = bar.getEasting()-easting;
		long diffN = bar.getNorthing()-northing;
		return Math.abs(diffE)+Math.abs(diffN);
	}
	
}
