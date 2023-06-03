package vti.com.valucation.departmentValudationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import vti.com.service.IDepartmentService;


public class DepartmentNameNotExistsValidator implements ConstraintValidator<DepartmentNameNotExists, String> {

	@Autowired
	private IDepartmentService service;
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
			
		}
		
		return !service.existsByName(value);
	}

}
