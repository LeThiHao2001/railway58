package vti.com.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Collection;
import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vti.com.entity.Account;
import vti.com.form.accountForm.AccountFilterViewList;
import vti.com.form.accountForm.CreateAccountForm;
import vti.com.form.accountForm.UpdateAccountForm;
import vti.com.reponsitory.IAccountReponsitory;
import vti.com.specification.AccountSpecification;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	IAccountReponsitory reponsitory;
	
	@Autowired 
	ModelMapper modelMapper;

	@Override
	public Page<Account> getAllAcount(String search, AccountFilterViewList form, Pageable pageable) {
		Specification<Account> where = AccountSpecification.buildWhere(search, form);
		return reponsitory.findAll(where, pageable);
	}

	@Override
	public Account getAccountById(int id) {
		return reponsitory.findById(id).get();
	}

	@Override
	public void createAccount(CreateAccountForm form) {
		TypeMap<CreateAccountForm, Account>typeMap= modelMapper.getTypeMap(CreateAccountForm.class, Account.class);
			
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<CreateAccountForm, Account>() {

				@Override
				protected void configure() {
					skip(destination.getId());
					
				}
			});
			
		}
		Account account = modelMapper.map(form, Account.class);
		
		reponsitory.save(account);
		
	}

	@Override
	public void updateAccount(UpdateAccountForm form) {
		TypeMap<UpdateAccountForm, Account>typeMap= modelMapper.getTypeMap(UpdateAccountForm.class, Account.class);
		
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<UpdateAccountForm, Account>() {

				@Override
				protected void configure() {
					skip(destination.getId());
					
				}
			});
			
		}
		Account account = modelMapper.map(form, Account.class);
		reponsitory.save(account);
		
	}

	@Override
	public void deleteAccount(int id) {
		reponsitory.deleteById(id);
		
	}

	@Override
	public boolean existsByName(String name) {
		return reponsitory.existsByUserName(name);
	}

	@Override
	public boolean existsById(Integer id) {
		return reponsitory.existsById(id);
	}

	@Override
	public Account findByUserName(String name) {
		return reponsitory.findByUserName(name);
	}
	
	//
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Account account = reponsitory.findByUserName(username);
		
		if (account== null) {
			throw new UsernameNotFoundException(username);
			
		}
		return new User(
				account.getUserName(),
				account.getPassword(),
				AuthorityUtils.createAuthorityList(account.getRole().toString()));
	}

}
