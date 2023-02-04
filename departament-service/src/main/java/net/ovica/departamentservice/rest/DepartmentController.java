package net.ovica.departamentservice.rest;

import lombok.AllArgsConstructor;
import net.ovica.departamentservice.entity.Department;
import net.ovica.departamentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
        Optional<Department> existingDepartment = departmentService.getDepartmentById(departmentId);

        return existingDepartment.map(department -> new ResponseEntity<>(department, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Department> deleteDepartmentById(@PathVariable("id") Long departmentId) {
        Optional<Department> existingDepartment = departmentService.getDepartmentById(departmentId);

        if (existingDepartment.isPresent()) {
            departmentService.deleteDepartmentById(departmentId);
            return new ResponseEntity<>(existingDepartment.get(), HttpStatus.OK);
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
