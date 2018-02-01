package com.smart_museum.dao;
import java.util.List;
import com.smart_museum.entity.Media;

public interface IMediaDAO {
    List<Media> getAllMedias();
    Media getMediaById(int mediaId);
    void addMedia(Media media);
    void updateMedia(Media media);
    void deleteMedia(int mediaId);
    boolean mediaExists(String name);
}
 
