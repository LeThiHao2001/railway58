package vti.com.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vti.com.dto.DepartmentDto;
import vti.com.entity.Department;
import vti.com.form.departmentForm.CreateDepartmentForm;
import vti.com.form.departmentForm.DepartmentFilterViewListCreateDate;
import vti.com.form.departmentForm.UpdateDepartmentForm;
import vti.com.service.IDepartmentService;
import vti.com.valucation.departmentValudationAnotation.CheckDepartmentIDexists;

@RestController
@RequestMapping( value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@Validated
public class DepartmentController {
	
	@Autowired 
	IDepartmentService service;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping()
	public Page<DepartmentDto> getAllDepartment(
			@RequestParam(name = "search", required = false) String search,
			DepartmentFilterViewListCreateDate date, 
			Pageable pageable){
		Page<Department> departments= service.getAllDepartment(search, date, pageable);
		List<DepartmentDto> dtos = modelMapper.map(departments.getContent(), new TypeToken<List<DepartmentDto>>() {
		}.getType());
		
		Page< DepartmentDto> dtoPage = new PageImpl<>(dtos,pageable,departments.getTotalElements());
		
		return dtoPage;

	}
	
	@GetMapping("/{id}")
	public DepartmentDto getDepartmentById(@PathVariable (value  = "id") @CheckDepartmentIDexists int id) {
		Department department = service.getDepartmentById(id);
		DepartmentDto dto = modelMapper.map(department, DepartmentDto.class);
		return dto;
		
	}
	
	@Transactional
	@PostMapping()
	public void createDepartment(@RequestBody @Valid CreateDepartmentForm form) {
		service.createDepartment(form);
		
	}
	
	@PutMapping("/{id}")
	public void upDateDepartment (@PathVariable(value = "id") @CheckDepartmentIDexists int id,
			@RequestBody UpdateDepartmentForm form) {
		form.setId(id);
		service.updateDepartment(form);
		
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable(value = "id") @CheckDepartmentIDexists int id) {
		service.deleteDepartment(id);
		
	}

}
