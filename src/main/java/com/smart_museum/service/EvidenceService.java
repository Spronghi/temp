package com.smart_museum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_museum.dao.IEvidenceDAO;
import com.smart_museum.entity.Evidence;
@Service
public class EvidenceService implements IEvidenceService {
	@Autowired
	private IEvidenceDAO evidenceDAO;
	@Autowired
	private IOperatorService operatorService;
	@Override
	public Evidence getEvidenceById(int evidenceId) {
		Evidence obj = evidenceDAO.getEvidenceById(evidenceId);
		return obj;
	}	
	@Override
	public List<Evidence> getAllEvidences(){
		return evidenceDAO.getAllEvidences();
	}
	@Override
	public synchronized boolean addEvidence(Evidence evidence){
       if (evidenceDAO.evidenceExists(evidence.getTitle(), evidence.getAuthor())) {
    	   return false;
       } else {
    	   evidenceDAO.addEvidence(evidence);
    	   return true;
       }
	}
	@Override
	public void updateEvidence(Evidence evidence) {
		evidenceDAO.updateEvidence(evidence);
	}
	@Override
	public void deleteEvidence(int evidenceId) {
		evidenceDAO.deleteEvidence(evidenceId);
	}
	@Override
    public List<Evidence> getEvidencesByMuseumId(int museumId){
		return evidenceDAO.getEvidencesByMuseumId(museumId);
	}
	@Override
    public List<Evidence> getEvidencesByOperatorId(int operatorId){
		return evidenceDAO.getEvidencesByMuseumId(operatorService.getOperatorById(operatorId).getMuseum().getId());
	}
}
