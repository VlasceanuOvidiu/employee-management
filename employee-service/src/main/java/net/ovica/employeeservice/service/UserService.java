package net.ovica.employeeservice.service;

import net.ovica.employeeservice.entity.User;
import net.ovica.employeeservice.entity.dto.ResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    void deleteUserByUserId(Long id);

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    ResponseDto getUserWithDepartment(Long userId) throws Exception;




}
