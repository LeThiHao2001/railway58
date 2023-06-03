package vti.com.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import vti.com.entity.Account;
import vti.com.entity.Department;
import vti.com.form.departmentForm.CreateDepartmentForm;
import vti.com.form.departmentForm.DepartmentFilterViewListCreateDate;
import vti.com.form.departmentForm.UpdateDepartmentForm;
import vti.com.reponsitory.IAccountReponsitory;
import vti.com.reponsitory.IDepartmentReponsitory;
import vti.com.specification.DepartmentSpecification;

@Service
public class DepartmentService implements IDepartmentService {
	
	@Autowired 
	IDepartmentReponsitory reponsitory;
	
	@Autowired 
	ModelMapper modelMapper;
	
	@Autowired
	IAccountReponsitory accountReponsitory;

	@Override
	public Page<Department> getAllDepartment(String search,
			DepartmentFilterViewListCreateDate form,
			Pageable pageable) {
		
		Specification<Department> specification= DepartmentSpecification.buildWhere(search, form) ;
		return reponsitory.findAll(specification, pageable);
		
	}

	@Override
	public Department getDepartmentById(int id) {
		return reponsitory.findById(id).get();
		
	}

	@Override
	public void createDepartment(CreateDepartmentForm form) {
		Department department = modelMapper.map(form, Department.class);
		
		Department department2 = reponsitory.save(department);
		
		List<Account>entityList = department2.getAccounts();
		
		for (Account account : entityList) {
			account.setDepartment(department2);
			
		}
		accountReponsitory.saveAll(entityList);
		
	}

	@Override
	public void updateDepartment(UpdateDepartmentForm form) {
		Department department = modelMapper.map(form, Department.class);
		
		reponsitory.save(department);
		
	}

	@Override
	public void deleteDepartment(int id) {
		reponsitory.deleteById(id);
		
	}

	@Override
	public boolean existsByName(String name) {
		return reponsitory.existsByName(name);
	}

	@Override
	public boolean existsById(Integer id) {
		return reponsitory.existsById(id);
	}

}
