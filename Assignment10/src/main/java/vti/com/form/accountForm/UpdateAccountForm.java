package vti.com.form.accountForm;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import vti.com.valucation.accountValudasionAnotation.AccountNameNotExists;
import vti.com.valucation.accountValudasionAnotation.CheckAccountIdExists;
import vti.com.valucation.departmentValudationAnotation.CheckDepartmentIDexists;

public class UpdateAccountForm {
	@NotNull(message = "{Account.id.NotNull}" )
	@PositiveOrZero(message = "{Account.id.PositiveOrZero}")
	@CheckAccountIdExists
	private Integer id;
	
	@NotBlank(message = "{Account.name.NotBlank}")
	@Length(max = 50, message = "{Account.name.length}")
	@AccountNameNotExists
	private String userName;
	
//	@NotBlank(message = "{Account.password.NotBlank}")
//	private String password;
	
	@NotBlank(message = "{Account.firstName.NotBlank}")
	@Length(max = 50, message = "{Account.firstName.length}")
	private String firstName;
	
	@NotBlank(message = "{Account.lastName.NotBlank}")
	@Length(max = 50, message = "{Account.lastName.length}")
	private String lastName;
	
	
//	@NotBlank(message = "{Account.role.NotBlank}")
//	@Pattern(regexp = "MANAGER|ADMIN|EMLOYEE", message = "{Account.role.Pattern}")
	private String role;
	
	@NotNull(message = "{Department.id.NotNul}")
	@PositiveOrZero(message = "{Department.id.PositiveOrZero}")
	@CheckDepartmentIDexists
	private Integer departmentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public UpdateAccountForm(@PositiveOrZero(message = "The id must be greator than or equal 0! ") Integer id,
			@NotBlank(message = "The userName mustn't be null value!") @Length(max = 50, message = "The userName less than or equal 50!") String userName,
			
			@NotBlank(message = "The userName mustn't be null value!") @Length(max = 50, message = "The firstName less than or equal 50!") String firstName,
			@NotBlank(message = "The lastName mustn't be null value!") @Length(max = 50, message = "The lastName less than or equal 50!") String lastName,
		
			@NotBlank(message = "The role mustn't be null value !") String role,
			@NotNull(message = "The departmentId must be have value") @PositiveOrZero(message = "The departmentId must be greator than or equal 0!") Integer departmentId) {
		super();
		this.id = id;
		this.userName = userName;
		
		this.firstName = firstName;
		this.lastName = lastName;
	
		this.role = role;
		this.departmentId = departmentId;
	}

	public UpdateAccountForm() {
		super();
	}


}
