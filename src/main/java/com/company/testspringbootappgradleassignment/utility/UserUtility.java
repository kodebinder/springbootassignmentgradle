package com.company.testspringbootappgradleassignment.utility;

import com.company.testspringbootappgradleassignment.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserUtility {

    private final AddressUtility addressUtility;

    public UserUtility(final AddressUtility addressUtility) {
        this.addressUtility = addressUtility;
    }

    public List<UserDto> loadUsers() {
        List<UserDto> users = new LinkedList<>();
        users.add(getUserDetailsForJohn());
        users.add(getUserDetailsForMark());
        return users;
    }

    public UserDto getUserDetailsForJohn() {
        UserDto userDto = new UserDto();
        userDto.setId(7L);
        userDto.setUserId("1001");
        userDto.setUserFirstName("john");
        userDto.setUserLastName("wright");
        userDto.setEmail("john.wright@email.com");
        userDto.setMobileNumbers(Arrays.asList("5555551234", "5555555678"));
        userDto.setAddress(addressUtility.getAddressForJohn());
        return userDto;
    }

    public UserDto getUserDetailsForMark() {
        UserDto userDto = new UserDto();
        userDto.setId(5L);
        userDto.setUserId("1007");
        userDto.setUserFirstName("mark");
        userDto.setUserLastName("johnson");
        userDto.setEmail("mark.johnson@email.com");
        userDto.setMobileNumbers(Arrays.asList("5555551898", "5555551890"));
        userDto.setAddress(addressUtility.getAddressDetailsForMark());
        return userDto;
    }

}
