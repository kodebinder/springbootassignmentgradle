package com.company.utility;

import com.company.dto.CompanyDto;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CompanyUtility {

    public CompanyUtility() {
    }

    public List<CompanyDto> loadCompanies() {
        List<CompanyDto> companies = new LinkedList<>();
        companies.add(getRelianceDetails());
        companies.add(getTataDetails());
        companies.add(getItcDetails());
        return companies;
    }

    public CompanyDto getRelianceDetails() {
        CompanyDto reliance = CompanyDto.builder()
                .id(7L)
                .companyId("Company-Reliance")
                .companyName("Reliance Industry")
                .domicile("IND")
                .isActive(Boolean.TRUE)
                .yearOfEstablishment(1966)
                .build();
        return reliance;
    }

    public CompanyDto getTataDetails() {
        CompanyDto tata = CompanyDto.builder()
                .id(4L)
                .companyId("Company-Tata")
                .companyName("Tata Group")
                .domicile("IND")
                .isActive(Boolean.TRUE)
                .yearOfEstablishment(1868)
                .build();
        return tata;
    }

    public CompanyDto getItcDetails() {
        CompanyDto itc = CompanyDto.builder()
                .id(3L)
                .companyId("Company-ITC")
                .companyName("Imperial Tobacco Company of India Limited")
                .domicile("IND")
                .isActive(Boolean.TRUE)
                .yearOfEstablishment(1910)
                .build();
        return itc;
    }
}
