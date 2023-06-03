package vti.com.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import vti.com.entity.Department;

public interface IDepartmentReponsitory extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
	
	boolean existsByName(String name);
	
	
	

}
