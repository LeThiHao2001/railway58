package vti.com.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vti.com.dto.LoginDto;
import vti.com.entity.Account;
import vti.com.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/auth" )
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {
	
	@Autowired 
	ModelMapper modelMapper;
	
	@Autowired
	IAccountService service;
	
	@GetMapping("/login")
	public LoginDto login(Principal principal) {
		
		String userName= principal.getName();
		Account entity= service.findByUserName(userName);
		
		LoginDto dto = modelMapper.map(entity, LoginDto.class);
		
	
		return dto;
		
	}
	

}
