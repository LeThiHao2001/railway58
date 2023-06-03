package vti.com.form.departmentForm;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DepartmentFilterViewListCreateDate {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minCreateDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxCreateDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	public Date getMinCreateDate() {
		return minCreateDate;
	}

	public void setMinCreateDate(Date minCreateDate) {
		this.minCreateDate = minCreateDate;
	}

	public Date getMaxCreateDate() {
		return maxCreateDate;
	}

	public void setMaxCreateDate(Date maxCreateDate) {
		this.maxCreateDate = maxCreateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public DepartmentFilterViewListCreateDate(Date minCreateDate, Date maxCreateDate, Date createDate) {
		super();
		this.minCreateDate = minCreateDate;
		this.maxCreateDate = maxCreateDate;
		this.createDate = createDate;
	}

	public DepartmentFilterViewListCreateDate() {
		super();
	}
	
	

}
