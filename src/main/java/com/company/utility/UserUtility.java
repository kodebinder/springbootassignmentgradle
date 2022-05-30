package com.company.utility;

import com.company.model.Address;
import com.company.model.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserUtility {

    public UserUtility() {
    }

    public List<User> loadUsers() {
        List<User> users = new LinkedList<>();

        User john = User.builder()
                .id(7L)
                .userId("1001")
                .userFirstName("john")
                .userLastName("wright")
                .email("john.wright@gmail.com")
                .mobileNumbers(Arrays.asList("5555551234.", "5555555678"))
                .address(Address.builder()
                        .addressId("101")
                        .addressType("Office")
                        .city("Chicago")
                        .street("12 Main").state("Illinois").country("USA").zip("60603").build())
                .build();

        User mark = User.builder()
                .id(5L)
                .userId("1007")
                .userFirstName("mark")
                .userLastName("johnson")
                .email("mark.johnson@gmail.com")
                .mobileNumbers(Arrays.asList("5555551898", "5555551890"))
                .address(Address.builder()
                        .addressId("678")
                        .addressType("Home")
                        .city("New York")
                        .street("10 Main").state("New York").country("USA").zip("10001").build())
                .build();

        users.add(john);
        users.add(mark);

        return users;
    }
}
