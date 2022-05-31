package com.company.utility;

import com.company.dto.UserDto;
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
        UserDto john = UserDto.builder()
                .id(7L)
                .userId("1001")
                .userFirstName("john")
                .userLastName("wright")
                .email("john.wright@gmail.com")
                .mobileNumbers(Arrays.asList("5555551234.", "5555555678"))
                .address(addressUtility.getAddressForJohn())
                .build();
        return john;
    }

    public UserDto getUserDetailsForMark() {
        UserDto mark = UserDto.builder()
                .id(5L)
                .userId("1007")
                .userFirstName("mark")
                .userLastName("johnson")
                .email("mark.johnson@gmail.com")
                .mobileNumbers(Arrays.asList("5555551898", "5555551890"))
                .address(addressUtility.getAddressDetailsForMark())
                .build();
        return mark;
    }

}
