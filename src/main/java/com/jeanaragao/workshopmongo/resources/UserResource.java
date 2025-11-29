package com.jeanaragao.workshopmongo.resources;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jeanaragao.workshopmongo.domain.User;
import com.jeanaragao.workshopmongo.dto.UserDTO;
import com.jeanaragao.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET) // ou poderia ser @GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		

		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

}
