package vti.com.dto;

public class LoginDto {
	private int id;
	
	
	private String fullName;
	
	private String role;
	
	private String departmentName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public LoginDto(int id, String fullName, String role, String departmentName) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.role = role;
		this.departmentName = departmentName;
	}

	public LoginDto() {
		super();
	}
	

}
