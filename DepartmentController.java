package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DepartmentServiceImpl;

@RestController
public class DepartmentController 
{
	@Autowired
	private DepartmentService departmentservice;
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department)
	{
	return departmentservice.saveDepartment(department);
	}
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList()
	{
	return departmentservice.fetchDepartmentList();
	}
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId)
	{
	return departmentservice.fetchDepartmentById(departmentId);
	}
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId)
	{
	departmentservice.deleteDepartmentById(departmentId);
	return "Record deleted successfully";
	}
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId,
	@RequestBody Department department)
	{
	return departmentservice.updateDepartmentById(departmentId,department);
	}
}
