package vti.com.reponsitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import vti.com.dto.AccountDto;
import vti.com.entity.Account;
import vti.com.form.accountForm.AccountFilterViewList;

public interface IAccountReponsitory extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

	boolean existsByUserName(String name);
	
	Account findByUserName(String name);
}
