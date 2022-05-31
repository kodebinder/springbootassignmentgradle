package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    private long id;
    private String bankAccountId;
    private String bankAccountNumber;
    private boolean isActive;
    private BigDecimal balance;
    private BankOperation bankOperation;
}
