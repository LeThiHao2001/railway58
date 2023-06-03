package vti.com.form.departmentForm;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import vti.com.entity.Department.Type;
import vti.com.valucation.departmentValudationAnotation.CheckDepartmentIDexists;
import vti.com.valucation.departmentValudationAnotation.DepartmentNameNotExists;

public class UpdateDepartmentForm {
	
	@PositiveOrZero(message = "{Department.id.PositiveOrZero} ")
	@CheckDepartmentIDexists
	private Integer id;
	
	@NotBlank(message = "{Department.name.NotBlank}")
	@Length(max = 50, message = "{Department.name.Length}")
	@DepartmentNameNotExists
	private String name;
	
//	@NotBlank(message = "{Department.type.NotBlank}")
//	@Pattern(regexp = "DEV|TEST|ScrumMaster", message = "{Department.type.Pattern}")
 	private Type type;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "{Department.createDate.FutureOrPresent}")
	private Date createdDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getDate() {
		return createdDate;
	}

	public void setDate(Date date) {
		this.createdDate = date;
	}

	public UpdateDepartmentForm(Integer id, String name, Type type, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.createdDate = date;
	}

	public UpdateDepartmentForm() {
		super();
	}
	
	

}
