package com.smart_museum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smart_museum.entity.Media;

@Transactional
@Repository
public class MediaDAO implements IMediaDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMedias() {
		String hql = "FROM Media as media ORDER BY media.id";
		return (List<Media>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Media getMediaById(int mediaId) {
		return entityManager.find(Media.class, mediaId);
	}

	@Override
	public void addMedia(Media media) {
		entityManager.persist(media);
	}

	@Override
	public void updateMedia(Media media) {
		Media oldMedia = getMediaById(media.getId());
		oldMedia.setEvidence(media.getEvidence());
		oldMedia.setShow(media.isShow());
		oldMedia.setType(media.getType());
		oldMedia.setUrl(media.getUrl());
		entityManager.flush();
	}

	@Override
	public void deleteMedia(int mediaId) {
		entityManager.remove(getMediaById(mediaId));
	}

	@Override
	public boolean mediaExists(String url) {
		String hql = "FROM Media as media WHERE media.url = ?";
		int count = entityManager.createQuery(hql).setParameter(1, url)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
