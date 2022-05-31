package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private long id;
    private String addressId;
    private String addressType;
    private String city;
    private String street;
    private String state;
    private String country;
    private String zip;
}
