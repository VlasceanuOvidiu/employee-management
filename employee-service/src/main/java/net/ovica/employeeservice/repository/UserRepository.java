package net.ovica.employeeservice.repository;

import net.ovica.employeeservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
