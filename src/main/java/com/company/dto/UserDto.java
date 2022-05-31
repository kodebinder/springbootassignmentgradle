package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private AddressDto address;
    private List<String> mobileNumbers;
    private String email;
    private String userFirstName;
    private String userId;
    private String userLastName;
}
