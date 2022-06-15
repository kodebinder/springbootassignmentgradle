package com.company.testspringbootappgradleassignment.utility;

import com.company.testspringbootappgradleassignment.dto.BankOperationDto;
import org.springframework.stereotype.Component;

@Component
public class BankOperationUtility {

    public BankOperationUtility(){

    }

    public BankOperationDto getIciciBankOperationDetails(){
        BankOperationDto bankOperationDto = new BankOperationDto();
        bankOperationDto.setId(1L);
        bankOperationDto.setBankAccountId("ICICI1001");
        bankOperationDto.setDebitEnabled(Boolean.TRUE);
        bankOperationDto.setCreditEnabled(Boolean.TRUE);
        return bankOperationDto;
    }

    public BankOperationDto getAxisBankOperationDetails(){
        BankOperationDto bankOperationDto = new BankOperationDto();
        bankOperationDto.setId(2L);
        bankOperationDto.setBankAccountId("AXIS9001");
        bankOperationDto.setDebitEnabled(Boolean.TRUE);
        bankOperationDto.setCreditEnabled(Boolean.TRUE);
        return bankOperationDto;
    }

    public BankOperationDto getSbiBankOperationDetails(){
        BankOperationDto bankOperationDto = new BankOperationDto();
        bankOperationDto.setId(3L);
        bankOperationDto.setBankAccountId("SBI7004");
        bankOperationDto.setDebitEnabled(Boolean.TRUE);
        bankOperationDto.setCreditEnabled(Boolean.TRUE);
        return bankOperationDto;
    }

}
