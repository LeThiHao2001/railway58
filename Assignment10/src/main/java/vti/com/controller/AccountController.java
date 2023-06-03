package vti.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.TypeToken;
import vti.com.dto.AccountDto;
import vti.com.entity.Account;
import vti.com.form.accountForm.AccountFilterViewList;
import vti.com.form.accountForm.CreateAccountForm;
import vti.com.form.accountForm.UpdateAccountForm;
import vti.com.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@Validated
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AccountController {
	
	@Autowired
	IAccountService service;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@GetMapping()
	public Page<AccountDto>getAllAccount(
			@RequestParam(value = "search", required = false) String search,
			AccountFilterViewList form,
			Pageable pageable){
		Page<Account> entitys= service.getAllAcount(search, form, pageable);
		List<AccountDto>dtos = modelMapper .map(entitys.getContent(), new TypeToken<List<AccountDto>>() {}.getType());
		
		Page<AccountDto> dtoPage= new PageImpl<>(dtos, pageable, entitys.getTotalElements());
				return dtoPage;
		
		
	}
	
	@GetMapping("/{id}")
	public AccountDto getAccountById(@PathVariable(value = "id") int id) {
		Account account = service.getAccountById(id);
		
		AccountDto dto = modelMapper.map(account, AccountDto.class);
		
		return dto;
		
		
	}
	
	@PostMapping()
	public void createAccount(@RequestBody @Valid CreateAccountForm form) {
		service.createAccount(form);
	}
	
	@PutMapping("/{id}")
	public void updateAccount(@PathVariable(value = "id")int id,
			@RequestBody @Valid UpdateAccountForm form) {
		form.setId(id);
		service.updateAccount(form);
	}
	
	@DeleteMapping()
	public void deleteAccount(int id) {
		service.deleteAccount(id);
		
	}

}
