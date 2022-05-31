package com.company.utility;

import com.company.dto.BankAccountDto;
import com.company.dto.BankOperationDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
public class BankAccountUtility {

    public BankAccountUtility() {
    }

    public List<BankAccountDto> loadBankAccounts() {
        List<BankAccountDto> bankAccounts = new LinkedList<>();

        BankAccountDto iciciBankAccount = BankAccountDto.builder()
                .id(9L)
                .bankAccountId("ICICI1001")
                .bankAccountNumber("501000607812345")
                .isActive(Boolean.TRUE)
                .balance(new BigDecimal(70000))
                .bankOperation(BankOperationDto.builder()
                        .id(1L)
                        .bankAccountId("ICICI1001")
                        .isDebitEnabled(Boolean.TRUE)
                        .isCreditEnabled(Boolean.TRUE)
                        .build()).build();

        BankAccountDto axisBankAccount = BankAccountDto.builder()
                .id(8L)
                .bankAccountId("AXIS9001")
                .bankAccountNumber("801000607867890")
                .isActive(Boolean.TRUE)
                .balance(new BigDecimal(50000))
                .bankOperation(BankOperationDto.builder()
                        .id(2L)
                        .bankAccountId("AXIS9001")
                        .isDebitEnabled(Boolean.TRUE)
                        .isCreditEnabled(Boolean.TRUE)
                        .build()).build();

        BankAccountDto sbiBankAccount = BankAccountDto.builder()
                .id(3L)
                .bankAccountId("SBI7004")
                .bankAccountNumber("700000607879797")
                .isActive(Boolean.TRUE)
                .balance(new BigDecimal(10000))
                .bankOperation(BankOperationDto.builder()
                        .id(3L)
                        .bankAccountId("SBI7004")
                        .isDebitEnabled(Boolean.TRUE)
                        .isCreditEnabled(Boolean.TRUE)
                        .build()).build();

        bankAccounts.add(iciciBankAccount);
        bankAccounts.add(axisBankAccount);
        bankAccounts.add(sbiBankAccount);

        return bankAccounts;
    }

}
