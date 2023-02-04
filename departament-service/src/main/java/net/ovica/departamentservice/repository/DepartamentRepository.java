package net.ovica.departamentservice.repository;

import net.ovica.departamentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends JpaRepository<Department, Long> {
}
