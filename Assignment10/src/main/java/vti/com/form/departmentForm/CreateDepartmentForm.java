package vti.com.form.departmentForm;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import vti.com.entity.Department.Type;
import vti.com.valucation.accountValudasionAnotation.AccountNameNotExists;
import vti.com.valucation.departmentValudationAnotation.DepartmentNameNotExists;

public class CreateDepartmentForm {

	@NotBlank(message = "{Department.name.NotBlank}")
	@Length(max = 50, message = "{Department.name.Length}")
	@DepartmentNameNotExists
	private String name;

//	@NotBlank(message = "{Department.type.NotBlank}")
//	 @Pattern(regexp = "DEV|TEST|ScrumMaster", message = "{Department.type.Pattern}")
	private Type type;

	@NotNull(message = "{Department.totalMember.Notnull}")
	@PositiveOrZero(message = "{Department.totalMember.PositiveOrZero}")
	private Integer totalMember;

	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "{Department.createDate.FutureOrPresent}")
	private Date createdDate;

	@NotEmpty(message = "{Department.accounts.NotEmpty}")
	private List<@Valid AccountForm> accounts;

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

	public Integer getTotalMember() {
		return totalMember;
	}

	public void setTotalMember(Integer totalMember) {
		this.totalMember = totalMember;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<AccountForm> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountForm> accounts) {
		this.accounts = accounts;
	}

	public CreateDepartmentForm() {
		super();
	}

	public CreateDepartmentForm(
			@NotBlank(message = "The name mustn't be null value!") @Length(max = 50, message = "The name less than or equal 50!") String name,
			Type type,
			@NotNull(message = "The totalMember mustn't null value!") @PositiveOrZero(message = "The totalMember greator than or equal 0!") Integer totalMember,
			@FutureOrPresent(message = "The date is now or future!") Date createdDate,
			@NotEmpty(message = "The list accounts mustn't be null value!") List<AccountForm> accounts) {
		super();
		this.name = name;
		this.type = type;
		this.totalMember = totalMember;
		this.createdDate = createdDate;
		this.accounts = accounts;
	}

	static class AccountForm {

		@NotBlank(message = "{Account.name.NotBlank}")
		@Length(max = 50, message = "{Account.name.length}")
		@AccountNameNotExists
		private String userName;
		
		
		@NotBlank(message = "{Account.firstName.NotBlank}")
		@Length(max = 50, message = "{Account.firstName.length}")
		private String firstName;
		
		@NotBlank(message = "{Account.lastName.NotBlank}")
		@Length(max = 50, message = "{Account.lastName.length}")
		private String lastName;
		
		
//		@NotBlank(message = "{Account.role.NotBlank}")
//		@Pattern(regexp = "MANAGER|ADMIN|EMLOYEE", message = "{Account.role.Pattern}")
		private String role;
		

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}


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

		public AccountForm(
				@NotBlank(message = "The userName mustn't be null value!") @Length(max = 50, message = "The userName less than or equal 50!") String userName,
				
				@NotBlank(message = "The userName mustn't be null value!") @Length(max = 50, message = "The firstName less than or equal 50!") String firstName,
				@NotBlank(message = "The lastName mustn't be null value!") @Length(max = 50, message = "The lastName less than or equal 50!") String lastName,
				@NotBlank(message = "The fullName mustn't be null value!") @Length(max = 50, message = "The lastName less than or equal 50!") String fullName,
				@NotBlank(message = "The role mustn't be null value !") @Pattern(regexp = "MANAGER|ADMIN|EMLOYEE", message = "The role must value MANAGER or ADMIN orEMPLOYEE!") String role) {
			super();
			this.userName = userName;
			
			this.firstName = firstName;
			this.lastName = lastName;
			
			this.role = role;
		}

		public AccountForm() {
			super();
		}

	}
}
