package net.ovica.employeeservice.rest;

import lombok.AllArgsConstructor;
import net.ovica.employeeservice.entity.User;
import net.ovica.employeeservice.entity.dto.ResponseDto;
import net.ovica.employeeservice.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long departmentId) {
        Optional<User> existingUser = userService.getUserById(departmentId);

        return existingUser.map(department -> new ResponseEntity<>(department, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") Long id) {
        Optional<User> existingUser = userService.getUserById(id);

        if (existingUser.isPresent()) {
            userService.deleteUserByUserId(id);
            return new ResponseEntity<>(existingUser.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public List<User> getAllDepartments() {
        return userService.getAllUsers();
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<ResponseDto> getUserAndDepartment(@PathVariable("id") Long userId) throws Exception {

        ResponseDto responseDto = userService.getUserWithDepartment(userId);
        return ResponseEntity.ok(responseDto);

    }
}
