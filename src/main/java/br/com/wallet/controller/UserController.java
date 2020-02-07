package br.com.wallet.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wallet.dto.UserDTO;
import br.com.wallet.entity.User;
import br.com.wallet.response.Response;
import br.com.wallet.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result){
		Response<UserDTO> response = new Response<UserDTO>();
		User user = service.save(this.convertDtoToEntoty(dto));
		
		response.setData(this.convertEntotyToDto(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private User convertDtoToEntoty(UserDTO dto) {
		User u = new User();
		u.setEmail(dto.getEmail());
		u.setName(dto.getName());
		u.setPassword(dto.getPassword());
		
		return u;	
	}
	
	private UserDTO convertEntotyToDto(User u) {
		UserDTO dto = new UserDTO();
		dto.setEmail(u.getEmail());
		dto.setName(u.getName());
		dto.setPassword(u.getPassword());
		
		return dto;
	}
}
