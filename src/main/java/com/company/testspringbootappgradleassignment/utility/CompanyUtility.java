package com.company.testspringbootappgradleassignment.utility;

import com.company.testspringbootappgradleassignment.dto.CompanyDto;
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
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(7L);
        companyDto.setCompanyId("Company-Reliance");
        companyDto.setCompanyName("Reliance Industry");
        companyDto.setDomicile("IND");
        companyDto.setActive(Boolean.TRUE);
        companyDto.setYearOfEstablishment(1966);
        return companyDto;
    }

    public CompanyDto getTataDetails() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(4L);
        companyDto.setCompanyId("Company-Tata");
        companyDto.setCompanyName("Tata Group");
        companyDto.setDomicile("IND");
        companyDto.setActive(Boolean.TRUE);
        companyDto.setYearOfEstablishment(1868);
        return companyDto;
    }

    public CompanyDto getItcDetails() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(3L);
        companyDto.setCompanyId("Company-ITC");
        companyDto.setCompanyName("Imperial Tobacco Company of India Limited");
        companyDto.setDomicile("IND");
        companyDto.setActive(Boolean.TRUE);
        companyDto.setYearOfEstablishment(1910);
        return companyDto;
    }
}
