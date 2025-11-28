package com.jeanaragao.workshopmongo.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jeanaragao.workshopmongo.domain.User;
import com.jeanaragao.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET) // ou poderia ser @GetMapping
	public ResponseEntity<List<User>> findAll() {
		

		List<User> list = userService.findAll();

		return ResponseEntity.ok().body(list);

	}

}
