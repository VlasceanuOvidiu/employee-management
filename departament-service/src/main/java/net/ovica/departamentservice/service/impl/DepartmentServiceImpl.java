package net.ovica.departamentservice.service.impl;

import lombok.AllArgsConstructor;
import net.ovica.departamentservice.repository.DepartamentRepository;
import net.ovica.departamentservice.entity.Department;
import net.ovica.departamentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartamentRepository departamentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departamentRepository.save(department);
    }

    @Override
    public Optional<Department> getDepartmentById(Long departmentId) {
        return departamentRepository.findById(departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departamentRepository.findAll();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departamentRepository.deleteById(departmentId);
    }
}
