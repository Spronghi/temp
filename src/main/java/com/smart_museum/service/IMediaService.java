package com.smart_museum.service;

import java.util.List;

import com.smart_museum.entity.Media;

public interface IMediaService {
     List<Media> getAllMedias();
     Media getMediaById(int mediaId);
     boolean addMedia(Media media);
     void updateMedia(Media media);
     void deleteMedia(int mediaId);
}
