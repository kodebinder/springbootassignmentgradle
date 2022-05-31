package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankOperation {
    private long id;
    private String bankAccountId;
    private boolean isDebitEnabled;
    private boolean isCreditEnabled;
}
