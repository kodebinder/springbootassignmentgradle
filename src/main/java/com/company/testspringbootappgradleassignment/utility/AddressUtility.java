package com.company.testspringbootappgradleassignment.utility;

import com.company.testspringbootappgradleassignment.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressUtility {

    public AddressUtility(){

    }

    public AddressDto getAddressForJohn() {

        AddressDto addressDto = new AddressDto();
        addressDto.setId(1L);
        addressDto.setAddressId("101");
        addressDto.setAddressType("Office");
        addressDto.setCity("Chicago");
        addressDto.setStreet("12 Main");
        addressDto.setState("Illinois");
        addressDto.setCountry("USA");
        addressDto.setZip("60603");

        return addressDto;
    }

    public AddressDto getAddressDetailsForMark() {

        AddressDto addressDto = new AddressDto();
        addressDto.setId(2L);
        addressDto.setAddressId("678");
        addressDto.setAddressType("Home");
        addressDto.setCity("New York");
        addressDto.setStreet("10 Main");
        addressDto.setState("New York");
        addressDto.setCountry("USA");
        addressDto.setZip("10001");

        return addressDto;
    }

}
