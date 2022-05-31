package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private long id;
    private String companyId;
    private String companyName;
    private String domicile;
    private int yearOfEstablishment;
    private boolean isActive;
}
