package vti.com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "Department")

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "`name`", length = 50, nullable = false, unique = true)
	
	private String name;

	@Column(name = "total_member")
	private int totalMember;

	@Column(name = "`type`")
	@Convert(converter = DepartmentTypeConvert.class)
	private Type type;

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdDate;
	
	@OneToMany(mappedBy = "department")
	private List<Account> accounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Department(int id, String name, int totalMember, Type type, Date createdDate,
			List<Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.totalMember = totalMember;
		this.type = type;
		this.createdDate = createdDate;
		this.accounts = accounts;
	}

	public Department() {
		
	}

	

	public enum Type {
		DEV("Dev"), TEST("Test"), ScrumMaster("ScrumMaster"), PM("PM");

		private String value;

		private Type(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static Type toEnum(String sqlValue) {
			for (Type type : Type.values()) {
				if (type.getValue().equals(sqlValue)) {
					return type;
				}
			}
			return null;
		}

	}

}
