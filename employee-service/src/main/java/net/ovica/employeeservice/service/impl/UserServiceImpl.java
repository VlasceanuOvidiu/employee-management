package net.ovica.employeeservice.service.impl;

import net.ovica.employeeservice.entity.User;
import net.ovica.employeeservice.entity.dto.DepartmentDto;
import net.ovica.employeeservice.entity.dto.ResponseDto;
import net.ovica.employeeservice.entity.dto.UserDto;
import net.ovica.employeeservice.exception.CustomException;
import net.ovica.employeeservice.repository.UserRepository;
import net.ovica.employeeservice.service.UserService;
import net.ovica.employeeservice.utility.UtilityClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Value("${department.service.url}")
    private String departmentServiceUrl;

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserByUserId(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseDto getUserWithDepartment(Long userId) throws Exception {

        try {
            ResponseDto responseDto = new ResponseDto();
            User user = userRepository.findById(userId).get();
            UserDto userDto = UtilityClass.mapToUser(user);

            ResponseEntity<DepartmentDto> responseEntity = restTemplate
                    .getForEntity(departmentServiceUrl + user.getDepartmentId(),
                            DepartmentDto.class);

            DepartmentDto departmentDto = responseEntity.getBody();

            responseDto.setUser(userDto);
            responseDto.setDepartment(departmentDto);

            return responseDto;

        } catch (Exception ex) {
            throw new CustomException("Department not found or it doesn t exist");
        }

    }
}


