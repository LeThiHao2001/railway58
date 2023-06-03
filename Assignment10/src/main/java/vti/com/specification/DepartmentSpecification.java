package vti.com.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import vti.com.entity.Department;
import vti.com.form.departmentForm.DepartmentFilterViewListCreateDate;

public class DepartmentSpecification {
	
	@SuppressWarnings("deprecation")
	public static Specification<Department>buildWhere (
			String search, DepartmentFilterViewListCreateDate filter){
		
		Specification<Department> where = null;
		
		if (!StringUtils.isEmpty(search)) {
			search = search.trim();
			CustomSpecification name = new CustomSpecification("name", search);
			where = Specification.where(name);
			
		}
		if (filter != null && filter.getCreateDate() != null) {
			CustomSpecification createDate= new CustomSpecification("createDate",filter.getCreateDate());
			if (where== null) {
				where = createDate;
				
			}
			else {
				where = where.and(createDate);
			}
			
		}
		if (filter != null && filter.getMinCreateDate() != null) {
			CustomSpecification minCreateDate= new CustomSpecification("minCreateDate",filter.getMinCreateDate());
			if (where== null) {
				where = minCreateDate;
				
			}
			else {
				where = where.and(minCreateDate);
			}
			
		}
		
		if (filter != null && filter.getMaxCreateDate() != null) {
			CustomSpecification maxCreateDate= new CustomSpecification("maxCreateDate",filter.getMaxCreateDate());
			if (where== null) {
				where = maxCreateDate;
				
			}
			else {
				where = where.and(maxCreateDate);
			}
			
		}
		
		return where;
		
	}
	
	@SuppressWarnings("serial")
	static class CustomSpecification implements Specification<Department>{
		private String field;
		
		private Object value;
		
		

		public CustomSpecification() {
			super();
		}



		public CustomSpecification(String field, Object value) {
			super();
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



		public void setValue(Object value) {
			this.value = value;
		}



		@Override
		public Predicate toPredicate(
				Root<Department> root,
				CriteriaQuery<?> query, 
				CriteriaBuilder criteriaBuilder) {
			if (field.equalsIgnoreCase("name")) {
				return criteriaBuilder.like(root.get("name"), "%"+value.toString()+"%");
				
			}
			if (field.equalsIgnoreCase("minCreateDate")) {
				return criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class), (Date)value);
				
			}
			if (field.equalsIgnoreCase("maxCreateDate")) {
				return criteriaBuilder.lessThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class), (Date)value);
				
			}
			if (field.equalsIgnoreCase("createDate")) {
				return criteriaBuilder.equal(root.get("createdDate").as(java.sql.Date.class), (Date)value);
				
			}
			return null;
		}
	}

}
