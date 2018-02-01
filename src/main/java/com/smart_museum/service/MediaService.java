package com.smart_museum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_museum.dao.IMediaDAO;
import com.smart_museum.entity.Media;
@Service
public class MediaService implements IMediaService {
	@Autowired
	private IMediaDAO mediaDAO;
	@Override
	public Media getMediaById(int mediaId) {
		Media obj = mediaDAO.getMediaById(mediaId);
		return obj;
	}	
	@Override
	public List<Media> getAllMedias(){
		return mediaDAO.getAllMedias();
	}
	@Override
	public synchronized boolean addMedia(Media media){
       if (mediaDAO.mediaExists(media.getUrl())) {
    	   return false;
       } else {
    	   mediaDAO.addMedia(media);
    	   return true;
       }
	}
	@Override
	public void updateMedia(Media media) {
		mediaDAO.updateMedia(media);
	}
	@Override
	public void deleteMedia(int mediaId) {
		mediaDAO.deleteMedia(mediaId);
	}
}
