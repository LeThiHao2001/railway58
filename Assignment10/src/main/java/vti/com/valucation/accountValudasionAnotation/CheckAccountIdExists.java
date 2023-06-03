package vti.com.valucation.accountValudasionAnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;




@Target({ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { AccountIdExistsValidation.class})
@Repeatable(CheckAccountIdExists.List.class)

public @interface CheckAccountIdExists {
	

String message() default "{Account.id.CheckAccountIdExists}";
	
	Class<?>[] groups() default{};
	
	Class< ? extends Payload>[] payload() default {};
	
	@Target({ElementType.METHOD,ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List{
		CheckAccountIdExists[] value();
	}
}
