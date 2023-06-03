package vti.com.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import vti.com.entity.Account;
import vti.com.form.accountForm.AccountFilterViewList;

public class AccountSpecification {

	@SuppressWarnings("deprecation")
	public static Specification<Account> buildWhere(String search, AccountFilterViewList form) {

		Specification<Account> where = null;

		if (!StringUtils.isEmpty(search)) {
			search = search.trim();
			CustomSpecification userName = new CustomSpecification("userName", search);
			CustomSpecification firstName = new CustomSpecification("firstName", search);
			CustomSpecification lastName = new CustomSpecification("lastName", search);

			where = Specification.where(userName).or(firstName).or(lastName);
		}
		if (form != null && form.getAdmin() != null) {
			CustomSpecification admin = new CustomSpecification("admin", form.getAdmin());
			if (where == null) {
				where = admin;
			} else {
				where = where.and(admin);
			}
		}

		if (form != null && form.getManager() != null) {
			CustomSpecification manager = new CustomSpecification("manager", form.getManager());
			if (where == null) {
				where = manager;
			} else {
				where = where.and(manager);
			}
		}

		if (form != null && form.getEmployee() != null) {
			CustomSpecification employee = new CustomSpecification("employee", form.getEmployee());
			if (where == null) {
				where = employee;
			} else {
				where = where.and(employee);
			}
		}
		return where;

	}

	@SuppressWarnings("serial")
	static class CustomSpecification implements Specification<Account> {

		private String field;
		private Object value;
		
		public CustomSpecification(String field, Object value) {

			this.field = field;
			this.value = value;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public Object getValue() {
			return value;
		}

		private void setValue(Object value) {
			this.value = value;
		}

		public CustomSpecification() {
			super();
		}
		
		@Override
		public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			if (field.equalsIgnoreCase("userName")) {
			return criteriaBuilder.like(root.get("userName"),"%"+value.toString()+ "%");
					}

		if (field.equalsIgnoreCase("firstName")) {
			return criteriaBuilder.like(root.get("firstName"),"%"+value.toString()+ "%");
		}
				
		if (field.equalsIgnoreCase("lastName")) {
			return criteriaBuilder.like(root.get("lastName"),"%"+value.toString()+ "%");
		}		
		if (field.equalsIgnoreCase("manager")) {
			return criteriaBuilder.like(root.get("role"), value.toString());
		}

		if (field.equalsIgnoreCase("employee")) {
			return criteriaBuilder.like(root.get("role"), value.toString());
		}

		if	(field.equalsIgnoreCase("admin")) {
			return criteriaBuilder.like(root.get("role"), value.toString());
		}
			return null;
		}


	}
		
		}
