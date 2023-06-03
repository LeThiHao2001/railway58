package vti.com.valucation.departmentValudationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentIDExistsValudation implements ConstraintValidator<CheckDepartmentIDexists, Integer> {

	@Autowired
	vti.com.service.IDepartmentService service;

	@SuppressWarnings("deprecation")
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {

		if (org.springframework.util.StringUtils.isEmpty(value)) {
			return true;

		}
		return service.existsById(value);
	}

}
