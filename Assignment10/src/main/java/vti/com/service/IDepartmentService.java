package vti.com.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vti.com.entity.Department;
import vti.com.form.departmentForm.CreateDepartmentForm;
import vti.com.form.departmentForm.DepartmentFilterViewListCreateDate;
import vti.com.form.departmentForm.UpdateDepartmentForm;

public interface IDepartmentService {
	
	Page<Department>getAllDepartment(String search, DepartmentFilterViewListCreateDate form, Pageable pageable);
	
	Department getDepartmentById(int  id);
	
	void createDepartment(CreateDepartmentForm form);
	
	void updateDepartment(UpdateDepartmentForm form);
	
	void deleteDepartment(int id);
	
	boolean existsByName(String name);
	
	boolean existsById(Integer id);
	
	

}
