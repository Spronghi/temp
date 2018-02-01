package com.smart_museum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_museum.dao.IMuseumDAO;
import com.smart_museum.entity.Museum;

@Service
public class MuseumService implements IMuseumService{
	@Autowired
	private IMuseumDAO museumDAO;
	@Override
	public List<Museum> getAllMuseums() {
		return museumDAO.getAllMuseums();
	}

	@Override
	public Museum getMuseumById(int museumId) {
		return museumDAO.getMuseumById(museumId);
	}

	@Override
	public boolean addMuseum(Museum museum) {
		if (museumDAO.museumExists(museum.getName())) {
	    	   return false;
		} else {
			museumDAO.addMuseum(museum);
			return true;
		}
	}

	@Override
	public void updateMuseum(Museum museum) {
		museumDAO.updateMuseum(museum);
	}

	@Override
	public void deleteMuseum(int museumId) {
		museumDAO.deleteMuseum(museumId);
	}

}
