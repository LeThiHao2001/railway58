package vti.com.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import vti.com.dto.AccountDto;
import vti.com.entity.Account;
import vti.com.form.accountForm.AccountFilterViewList;
import vti.com.form.accountForm.CreateAccountForm;
import vti.com.form.accountForm.UpdateAccountForm;

public interface IAccountService extends UserDetailsService {
	
	Page<Account>getAllAcount(String search, AccountFilterViewList form, Pageable pageable);
	
	Account getAccountById(int id);
	
	void createAccount (CreateAccountForm form);
	
	void updateAccount(UpdateAccountForm form);
	
	void deleteAccount(int id);
	
	boolean existsByName(String name);
	
	boolean existsById(Integer id);
	
	Account findByUserName(String name);
	

}
