package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private long id;
    private String addressId;
    private String addressType;
    private String city;
    private String street;
    private String state;
    private String country;
    private String zip;
}
