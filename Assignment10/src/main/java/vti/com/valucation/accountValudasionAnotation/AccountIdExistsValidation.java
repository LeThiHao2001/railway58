package vti.com.valucation.accountValudasionAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import vti.com.service.IAccountService;

public class AccountIdExistsValidation implements ConstraintValidator<CheckAccountIdExists, Integer> {

	@Autowired
	private IAccountService service;
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
			
		}
		return service.existsById(value);
	}

}
