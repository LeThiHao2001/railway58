package vti.com.valucation.accountValudasionAnotation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import vti.com.service.IAccountService;



public class AccountNameNotexistValudation implements ConstraintValidator<AccountNameNotExists, String> {

	@Autowired
	private IAccountService service;
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
			
		}
		
		return !service.existsByName(value);
	}

}
