package vti.com.valucation.departmentValudationAnotation;


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
	@Constraint(validatedBy = { DepartmentIDExistsValudation.class})
	@Repeatable(CheckDepartmentIDexists.List.class)
	public @interface CheckDepartmentIDexists {
		
		String message() default "{Department.id.IdExists}";
		
		Class<?>[] groups() default{};
		
		Class< ? extends Payload>[] payload() default {};
		
		@Target({ElementType.METHOD,ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
		@Retention(RetentionPolicy.RUNTIME)
		@Documented
		@interface List{
			CheckDepartmentIDexists[] value();
		}
		
		

	}



