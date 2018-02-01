package com.smart_museum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smart_museum.entity.Museum;

@Transactional
@Repository
public class MuseumDAO implements IMuseumDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Museum> getAllMuseums() {
		String hql = "FROM Museum as museum ORDER BY museum.id";
		return (List<Museum>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Museum getMuseumById(int museumId) {
		return entityManager.find(Museum.class, museumId);
	}

	@Override
	public void addMuseum(Museum museum) {
		entityManager.persist(museum);
	}

	@Override
	public void updateMuseum(Museum museum) {
		Museum oldMuseum = getMuseumById(museum.getId());
		oldMuseum.setAddress(museum.getAddress());
		oldMuseum.setDescription(museum.getDescription());
		oldMuseum.setEmail(museum.getEmail());
		oldMuseum.setLocation(museum.getLocation());
		oldMuseum.setName(museum.getName());
		oldMuseum.setPostalNo(museum.getPostalNo());
		entityManager.flush();
	}

	@Override
	public void deleteMuseum(int museumId) {
		entityManager.remove(getMuseumById(museumId));
	}

	@Override
	public boolean museumExists(String name) {
		String hql = "FROM Museum as museum WHERE museum.name = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
