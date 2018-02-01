package com.smart_museum.service;

import java.util.List;

import com.smart_museum.entity.Museum;

public interface IMuseumService {
    List<Museum> getAllMuseums();
    Museum getMuseumById(int museumId);
    boolean addMuseum(Museum museum);
    void updateMuseum(Museum museum);
    void deleteMuseum(int museumId);
}
