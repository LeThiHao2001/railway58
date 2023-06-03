package vti.com.dto;

public class AccountDto {
	private int id;
	
	private String userName;
	
	private String departmentName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public AccountDto(int id, String userName, String departmentName) {
		super();
		this.id = id;
		this.userName = userName;
		this.departmentName = departmentName;
	}

	public AccountDto() {
		super();
	}
	
	

}
