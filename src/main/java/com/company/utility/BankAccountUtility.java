package com.company.utility;

import com.company.dto.BankAccountDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
public class BankAccountUtility {

    private final BankOperationUtility bankOperationUtility;

    public BankAccountUtility(final BankOperationUtility bankOperationUtility) {
        this.bankOperationUtility = bankOperationUtility;
    }

    public List<BankAccountDto> loadBankAccounts() {
        List<BankAccountDto> bankAccounts = new LinkedList<>();
        bankAccounts.add(getIciciBankAccountDetails());
        bankAccounts.add(getAxisBankAccountDetails());
        bankAccounts.add(getSbiBankAccountDetails());
        return bankAccounts;
    }

    public BankAccountDto getIciciBankAccountDetails() {
        BankAccountDto iciciBankAccount = BankAccountDto.builder()
                .id(9L)
                .bankAccountId("ICICI1001")
                .bankAccountNumber("501000607812345")
                .isActive(Boolean.TRUE)
                .balance(new BigDecimal(70000))
                .bankOperation(bankOperationUtility.getIciciBankOperationDetails()).build();
        return iciciBankAccount;
    }

    public BankAccountDto getAxisBankAccountDetails() {
        BankAccountDto axisBankAccount = BankAccountDto.builder()
                .id(8L)
                .bankAccountId("AXIS9001")
                .bankAccountNumber("801000607867890")
                .isActive(Boolean.TRUE)
                .balance(new BigDecimal(50000))
                .bankOperation(bankOperationUtility.getAxisBankOperationDetails()).build();
        return axisBankAccount;
    }

    public BankAccountDto getSbiBankAccountDetails() {
        BankAccountDto sbiBankAccount = BankAccountDto.builder()
                .id(3L)
                .bankAccountId("SBI7004")
                .bankAccountNumber("700000607879797")
                .isActive(Boolean.TRUE)
                .balance(new BigDecimal(10000))
                .bankOperation(bankOperationUtility.getSbiBankOperationDetails()).build();
        return sbiBankAccount;
    }

}
