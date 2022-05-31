package com.company.utility;

import com.company.dto.BankOperationDto;
import org.springframework.stereotype.Component;

@Component
public class BankOperationUtility {

    public BankOperationUtility(){

    }

    public BankOperationDto getIciciBankOperationDetails(){
        return BankOperationDto.builder()
                .id(1L)
                .bankAccountId("ICICI1001")
                .isDebitEnabled(Boolean.TRUE)
                .isCreditEnabled(Boolean.TRUE)
                .build();
    }

    public BankOperationDto getAxisBankOperationDetails(){
        return BankOperationDto.builder()
                .id(2L)
                .bankAccountId("AXIS9001")
                .isDebitEnabled(Boolean.TRUE)
                .isCreditEnabled(Boolean.TRUE)
                .build();
    }

    public BankOperationDto getSbiBankOperationDetails(){
        return BankOperationDto.builder()
                .id(3L)
                .bankAccountId("SBI7004")
                .isDebitEnabled(Boolean.TRUE)
                .isCreditEnabled(Boolean.TRUE)
                .build();
    }

}
