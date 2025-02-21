package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService {
@Autowired
private DepartmentRepository departmentRepository;
@Override
public Department saveDepartment(Department department)
{
return departmentRepository.save(department);
}
@Override
public List<Department> fetchDepartmentList()
{
return departmentRepository.findAll();
}
@Override
public Department fetchDepartmentById(Long departmentId)
{
return departmentRepository.findById(departmentId).get();
}
@Override
public void deleteDepartmentById(Long departmentId)
{
departmentRepository.deleteById(departmentId);
}
@Override
public Department updateDepartmentById(Long departmentId, Department department)
{
Department db=departmentRepository.findById(departmentId).get();
db.setDepartmentAddress(department.getDepartmentAddress());
db.setDepartmentCode(department.getDepartmentCode());
db.setDepartmentName(department.getDepartmentName());
return departmentRepository.save(db);
}
}