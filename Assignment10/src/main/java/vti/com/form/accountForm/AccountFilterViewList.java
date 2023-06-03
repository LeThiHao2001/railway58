package vti.com.form.accountForm;

public class AccountFilterViewList {
	
	private String manager;
	
	private String employee;
	
	private String admin;

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public AccountFilterViewList(String manager, String employee, String admin) {
		super();
		this.manager = manager;
		this.employee = employee;
		this.admin = admin;
	}

	public AccountFilterViewList() {
		super();
	}
	
	

}
