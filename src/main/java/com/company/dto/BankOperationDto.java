package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankOperationDto {
    private long id;
    private String bankAccountId;
    private boolean isDebitEnabled;
    private boolean isCreditEnabled;
}
