package net.ovica.employeeservice.utility;

import net.ovica.employeeservice.entity.User;
import net.ovica.employeeservice.entity.dto.UserDto;

public class UtilityClass {

    public static UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
