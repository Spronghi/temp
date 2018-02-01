package com.smart_museum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smart_museum.entity.Flags;

@Transactional
@Repository
public class FlagsDAO implements IFlagsDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@Override
	public Flags getFlagsById(int flagsId) {
		return entityManager.find(Flags.class, flagsId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Flags> getAllFlags() {
		String hql = "FROM Flags as flags ORDER BY flags.id";
		return (List<Flags>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addFlags(Flags flags) {
		entityManager.persist(flags);
	}
	@Override
	public void updateFlags(Flags flags) {
		Flags fl = getFlagsById(flags.getId());
		fl.setAuthor(flags.isAuthor());
		fl.setCulture(flags.isCulture());
		fl.setDescription(flags.isDescription());
		fl.setDomain(flags.isDomain());
		fl.setEvidence(flags.getEvidence());
		fl.setOtherData(flags.isOtherData());
		fl.setHistoricInformation(flags.isHistoricInformation());
		fl.setMaterial(flags.isMaterial());
		fl.setNumber(flags.isNumber());
		fl.setOrigin_place(flags.isOrigin_place());
		fl.setOriginal(flags.isOriginal());
		fl.setOwner(flags.isOwner());
		fl.setPeriod(flags.isPeriod());
		fl.setRestauration(flags.isRestauration());
		fl.setScaleOfDamage(flags.isScaleOfDamage());
		fl.setWeight(flags.isWeight());
		fl.setStorageLocation(flags.isStorageLocation());
		fl.setTechnique(flags.isTechnique());
		fl.setType(flags.isType());
		fl.setValue(flags.isValue());
		fl.setDimensions(flags.isDimensions());
		entityManager.flush();
	}
	@Override
	public void deleteFlags(int flagsId) {
		entityManager.remove(getFlagsById(flagsId));
	}
	@Override
	public Flags getFlagsByEvidenceId(int evidenceId) {
		String hql = "FROM Flags as show_flags WHERE show_flags.evidence.id= ?";
		return (Flags) entityManager.createQuery(hql).setParameter(1, evidenceId).getResultList().get(0);
	}
}