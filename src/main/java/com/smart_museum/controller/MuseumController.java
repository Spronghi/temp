package com.smart_museum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.smart_museum.entity.Museum;
import com.smart_museum.service.IMuseumService;

@Controller
@RequestMapping("user")
public class MuseumController {
	@Autowired
	private IMuseumService museumService;
	@GetMapping("museum/{id}")
	public ResponseEntity<Museum> getMuseumById(@PathVariable("id") Integer id) {
		Museum museum = museumService.getMuseumById(id);
		return new ResponseEntity<Museum>(museum, HttpStatus.OK);
	}
	@GetMapping("museums")
	public ResponseEntity<List<Museum>> getAllMuseums() {
		List<Museum> list = museumService.getAllMuseums();
		return new ResponseEntity<List<Museum>>(list, HttpStatus.OK);
	}
	@PostMapping("museum")
	public ResponseEntity<Void> addMuseum(@RequestBody Museum museum, UriComponentsBuilder builder) {
        boolean flag = museumService.addMuseum(museum);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/museum/{id}").buildAndExpand(museum.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("museum")
	public ResponseEntity<Museum> updateMuseum(@RequestBody Museum museum) {
		museumService.updateMuseum(museum);
		return new ResponseEntity<Museum>(museum, HttpStatus.OK);
	}
	@DeleteMapping("museum/{id}")
	public ResponseEntity<Void> deleteMuseum(@PathVariable("id") Integer id) {
		museumService.deleteMuseum(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
