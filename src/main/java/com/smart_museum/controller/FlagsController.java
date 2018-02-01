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

import com.smart_museum.entity.Flags;
import com.smart_museum.service.IFlagsService;

@Controller
@RequestMapping("user")
public class FlagsController {
	@Autowired
	private IFlagsService flagsService;
	@GetMapping("flags/{id}")
	public ResponseEntity<Flags> getFlagsById(@PathVariable("id") Integer id) {
		Flags flags = flagsService.getFlagsById(id);
		return new ResponseEntity<Flags>(flags, HttpStatus.OK);
	}
	@GetMapping("flags_by_evidence/{id}")
	public ResponseEntity<Flags> getFlagsByEvidenceId(@PathVariable("id") Integer id) {
		Flags list = flagsService.getFlagsByEvidenceId(id);
		return new ResponseEntity<Flags>(list, HttpStatus.OK);
	}
	@GetMapping("flags")
	public ResponseEntity<List<Flags>> getAllFlags() {
		List<Flags> list = flagsService.getAllFlags();
		return new ResponseEntity<List<Flags>>(list, HttpStatus.OK);
	}
	@PostMapping("flags")
	public ResponseEntity<Void> addFlags(@RequestBody Flags flags, UriComponentsBuilder builder) {
        boolean flag = flagsService.addFlags(flags);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/flags/{id}").buildAndExpand(flags.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("flags")
	public ResponseEntity<Flags> updateFlags(@RequestBody Flags flags) {
		flagsService.updateFlags(flags);
		return new ResponseEntity<Flags>(flags, HttpStatus.OK);
	}
	@DeleteMapping("flags/{id}")
	public ResponseEntity<Void> deleteFlags(@PathVariable("id") Integer id) {
		flagsService.deleteFlags(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 
