package com.smart_museum.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smart_museum.entity.Evidence;
@Transactional
@Repository
public class EvidenceDAO implements IEvidenceDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@Override
	public Evidence getEvidenceById(int evidenceId) {
		return entityManager.find(Evidence.class, evidenceId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Evidence> getAllEvidences() {
		String hql = "FROM Evidence as evidence ORDER BY evidence.id";
		return (List<Evidence>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addEvidence(Evidence evidence) {
		entityManager.persist(evidence);
	}
	@Override
	public void updateEvidence(Evidence evidence) {
		Evidence evd = getEvidenceById(evidence.getId());
		evd.setTitle(evidence.getTitle());
		evd.setAuthor(evidence.getAuthor());
		evd.setCreationDate(evidence.getCreationDate());
		evd.setCulture(evidence.getCulture());
		evd.setDescription(evidence.getDescription());
		evd.setDimensions(evidence.getDimensions());
		evd.setDomain(evidence.getDomain());
		evd.setHistoricInformation(evidence.getHistoricInformation());
		evd.setMaterial(evidence.getMaterial());
		evd.setMuseum(evidence.getMuseum());
		evd.setNumber(evidence.getNumber());
		evd.setValue(evidence.getValue());
		evd.setType(evidence.getType());
		evd.setTechnique(evidence.getTechnique());
		evd.setStorageLocation(evidence.getStorageLocation());
		evd.setScaleOfDamage(evidence.getScaleOfDamage());
		evd.setRestauration(evidence.getRestauration());
		evd.setOperator(evidence.getOperator());
		evd.setOriginal(evidence.isOriginal());
		evd.setOriginPlace(evidence.getOriginPlace());
		evd.setOtherData(evidence.getOtherData());
		evd.setOwner(evidence.getOwner());
		evd.setPeriod(evidence.getPeriod());
		evd.setPublic(evidence.isPublic());
		evd.setWeight(evidence.getWeight());
		entityManager.flush();
	}
	@Override
	public void deleteEvidence(int evidenceId) {
		entityManager.remove(getEvidenceById(evidenceId));
	}
	@Override
	public boolean evidenceExists(String title, String author) {
		String hql = "FROM Evidence as evidence WHERE evidence.title = ? and evidence.author = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, author).getResultList().size();
		return count > 0 ? true : false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Evidence> getEvidencesByMuseumId(int museumId) {
		String hql = "FROM Evidence as evidence WHERE evidence.museum.id= ?";
		return (List<Evidence>) entityManager.createQuery(hql).setParameter(1, museumId).getResultList();
	}
}
