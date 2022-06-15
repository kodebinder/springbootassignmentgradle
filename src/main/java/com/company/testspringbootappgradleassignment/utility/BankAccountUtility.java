package com.company.testspringbootappgradleassignment.utility;

import com.company.testspringbootappgradleassignment.dto.BankAccountDto;
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
        BankAccountDto iciciBankAccount = new BankAccountDto();
        iciciBankAccount.setId(9L);
        iciciBankAccount.setBankAccountId("ICICI1001");
        iciciBankAccount.setBankAccountNumber("501000607812345");
        iciciBankAccount.setActive(Boolean.TRUE);
        iciciBankAccount.setBalance(new BigDecimal(70000));
        iciciBankAccount.setBankOperation(bankOperationUtility.getIciciBankOperationDetails());
        return iciciBankAccount;
    }

    public BankAccountDto getAxisBankAccountDetails() {
        BankAccountDto axisBankAccount = new BankAccountDto();
        axisBankAccount.setId(8L);
        axisBankAccount.setBankAccountId("AXIS9001");
        axisBankAccount.setBankAccountNumber("801000607867890");
        axisBankAccount.setActive(Boolean.TRUE);
        axisBankAccount.setBalance(new BigDecimal(50000));
        axisBankAccount.setBankOperation(bankOperationUtility.getAxisBankOperationDetails());
        return axisBankAccount;
    }

    public BankAccountDto getSbiBankAccountDetails() {
        BankAccountDto sbiBankAccount = new BankAccountDto();
        sbiBankAccount.setId(3L);
        sbiBankAccount.setBankAccountId("SBI7004");
        sbiBankAccount.setBankAccountNumber("700000607879797");
        sbiBankAccount.setActive(Boolean.TRUE);
        sbiBankAccount.setBalance(new BigDecimal(10000));
        sbiBankAccount.setBankOperation(bankOperationUtility.getSbiBankOperationDetails());
        return sbiBankAccount;
    }

}
