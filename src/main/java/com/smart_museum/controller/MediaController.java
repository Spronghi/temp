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

import com.smart_museum.entity.Media;
import com.smart_museum.service.IMediaService;

@Controller
@RequestMapping("user")
public class MediaController {
	@Autowired
	private IMediaService mediaService;
	@GetMapping("media/{id}")
	public ResponseEntity<Media> getMediaById(@PathVariable("id") Integer id) {
		Media media = mediaService.getMediaById(id);
		return new ResponseEntity<Media>(media, HttpStatus.OK);
	}
	@GetMapping("medias")
	public ResponseEntity<List<Media>> getAllMedias() {
		List<Media> list = mediaService.getAllMedias();
		return new ResponseEntity<List<Media>>(list, HttpStatus.OK);
	}
	@PostMapping("media")
	public ResponseEntity<Void> addMedia(@RequestBody Media media, UriComponentsBuilder builder) {
        boolean flag = mediaService.addMedia(media);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/media/{id}").buildAndExpand(media.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("media")
	public ResponseEntity<Media> updateMedia(@RequestBody Media media) {
		mediaService.updateMedia(media);
		return new ResponseEntity<Media>(media, HttpStatus.OK);
	}
	@DeleteMapping("media/{id}")
	public ResponseEntity<Void> deleteMedia(@PathVariable("id") Integer id) {
		mediaService.deleteMedia(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 
