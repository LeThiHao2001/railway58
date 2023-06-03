package vti.com.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import vti.com.entity.Department.Type;

public class DepartmentDto {
	
	private String name;
	
	private int totalMember;
	
	private Type type;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	
	
	
	
	public DepartmentDto() {
		super();
	}

	public DepartmentDto(String name, int totalMember, Type type, List<AccountDTO> accounts, Date createdDate) {
		super();
		this.name = name;
		this.totalMember = totalMember;
		this.type = type;
	
		this.createdDate = createdDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalMember() {
		return totalMember;
	}

	public void setTotalMember(int totalMember) {
		this.totalMember = totalMember;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	static class AccountDTO{
		private int id;
		
		private String userName;
		
		

		public AccountDTO() {
			super();
		}

		public AccountDTO(int id, String userName) {
			super();
			this.id = id;
			this.userName = userName;
		}

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
		
	}
	

}
