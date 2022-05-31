package com.company.utility;

import com.company.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressUtility {

    public AddressUtility(){

    }

    public AddressDto getAddressForJohn() {
        AddressDto addressDto = AddressDto.builder()
                .id(1L)
                .addressId("101")
                .addressType("Office")
                .city("Chicago")
                .street("12 Main").state("Illinois").country("USA").zip("60603").build();
        return addressDto;
    }

    public AddressDto getAddressDetailsForMark() {
        AddressDto addressDto = AddressDto.builder()
                .id(2L)
                .addressId("678")
                .addressType("Home")
                .city("New York")
                .street("10 Main").state("New York").country("USA").zip("10001").build();
        return addressDto;
    }

}
