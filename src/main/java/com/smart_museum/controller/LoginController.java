package com.smart_museum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart_museum.entity.Operator;
import com.smart_museum.service.IOperatorService;

@Controller
@RequestMapping("user")
public class LoginController {
	@Autowired
	private IOperatorService operatorService;
	@GetMapping("login/{username}")
	public ResponseEntity<Operator> getArticleById(@PathVariable("username") String username) {
		Operator operator = operatorService.getOperatorByUsernameAndPassword(username,"");
		return new ResponseEntity<Operator>(operator, HttpStatus.OK);
	}
} 
