package com.company.utility;

import com.company.model.Company;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CompanyUtility {

    public CompanyUtility() {
    }

    public List<Company> loadCompanies() {
        List<Company> companies = new LinkedList<>();

        Company reliance = Company.builder()
                .id(7L)
                .companyId("Company-Reliance")
                .companyName("Reliance Industry")
                .domicile("IND")
                .isActive(Boolean.TRUE)
                .yearOfEstablishment(1966)
                .build();

        Company tata = Company.builder()
                .id(4L)
                .companyId("Company-Tata")
                .companyName("Tata Group")
                .domicile("IND")
                .isActive(Boolean.TRUE)
                .yearOfEstablishment(1868)
                .build();

        Company itc = Company.builder()
                .id(3L)
                .companyId("Company-ITC")
                .companyName("Imperial Tobacco Company of India Limited")
                .domicile("IND")
                .isActive(Boolean.TRUE)
                .yearOfEstablishment(1910)
                .build();

        companies.add(reliance);
        companies.add(tata);
        companies.add(itc);

        return companies;
    }
}
