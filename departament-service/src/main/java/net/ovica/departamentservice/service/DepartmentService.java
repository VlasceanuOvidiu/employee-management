package net.ovica.departamentservice.service;

import net.ovica.departamentservice.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Optional<Department> getDepartmentById(Long departmentId);

    List<Department> getAllDepartments();

    void deleteDepartmentById(Long departmentId);

}
