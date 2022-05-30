package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private long id;
    private String companyId;
    private String companyName;
    private String domicile;
    private int yearOfEstablishment;
    private boolean isActive;
}
