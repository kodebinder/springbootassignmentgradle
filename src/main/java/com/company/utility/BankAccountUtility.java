package com.company.utility;

import com.company.model.BankAccount;
import com.company.model.BankOperation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
public class BankAccountUtility {

    public BankAccountUtility() {
    }

    public List<BankAccount> loadBankAccounts() {
        List<BankAccount> bankAccounts = new LinkedList<>();

        BankAccount iciciBankAccount = BankAccount.builder()
                .id(9L)
                .bankAccountId("ICICI1001")
                .bankAccountNumber("501000607812345")
                .isActive(Boolean.TRUE)
                .balance(new BigDecimal(70000))
                .bankOperation(BankOperation.builder()
                        .bankAccountId("ICICI1001")
                        .isDebitEnabled(Boolean.TRUE)
                        .isCreditEnabled(Boolean.TRUE)
                        .build()).build();

        BankAccount axisBankAccount = BankAccount.builder()
                .id(8L)
                .bankAccountId("AXIS9001")
                .bankAccountNumber("801000607867890")
                .isActive(Boolean.TRUE)
                .balance(new BigDecimal(50000))
                .bankOperation(BankOperation.builder()
                        .bankAccountId("AXIS9001")
                        .isDebitEnabled(Boolean.TRUE)
                        .isCreditEnabled(Boolean.TRUE)
                        .build()).build();

        BankAccount sbiBankAccount = BankAccount.builder()
                .id(3L)
                .bankAccountId("SBI7004")
                .bankAccountNumber("700000607879797")
                .isActive(Boolean.TRUE)
                .balance(new BigDecimal(10000))
                .bankOperation(BankOperation.builder()
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
