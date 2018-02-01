package com.smart_museum.dao;
import java.util.List;
import com.smart_museum.entity.Museum;

public interface IMuseumDAO {
    List<Museum> getAllMuseums();
    Museum getMuseumById(int museumId);
    void addMuseum(Museum museum);
    void updateMuseum(Museum museum);
    void deleteMuseum(int museumId);
    boolean museumExists(String name);
}
 
