package com.company.service;

import com.company.entity.DbColumn;
import com.company.repository.DbColumnRepository;
import com.company.utility.BankAccountUtility;
import com.company.utility.CompanyUtility;
import com.company.utility.PortfolioUtility;
import com.company.utility.UserUtility;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Stream;

@Service
@Slf4j
public class DataService {

    private final PortfolioUtility portfolioUtility;
    private final BankAccountUtility bankAccountUtility;
    private final UserUtility userUtility;
    private final CompanyUtility companyUtility;
    private final DbColumnRepository dbColumnRepository;

    private final ModelMapper modelMapper;

    public DataService(
            final PortfolioUtility portfolioUtility,
            final BankAccountUtility bankAccountUtility,
            final UserUtility userUtility,
            final CompanyUtility companyUtility,
            final DbColumnRepository dbColumnRepository,
            final ModelMapper modelMapper
    ) {
        this.portfolioUtility = portfolioUtility;
        this.bankAccountUtility = bankAccountUtility;
        this.userUtility = userUtility;
        this.companyUtility = companyUtility;
        this.dbColumnRepository = dbColumnRepository;
        this.modelMapper = modelMapper;
    }

    public Map<String, List<Object>> loadCache() throws ParseException {
        Map<String, List<Object>> cache = new LinkedHashMap<>();

        List<Object> investments = new LinkedList<>();

        investments.add(portfolioUtility.loadPortfolios());
        investments.add(bankAccountUtility.loadBankAccounts());

        List<Object> crm = new LinkedList<>();
        crm.add(userUtility.loadUsers());
        crm.add(companyUtility.loadCompanies());

        cache.put("investments", investments);
        cache.put("crm", crm);

        return cache;
    }

    /**
     * To flatten a map containing a list of items as values
     */
    public <T> Stream<T> flatten(Collection<List<T>> values) {
        return values.stream().flatMap(Collection::stream);
    }

    /**
     * Get Flattened Json
     *
     * @param cache
     * @return
     */
    public Map<String, Object> getFlattenedJson(Map<String, List<Object>> cache) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(cache);
        String flattenedJsonString = JsonFlattener.flatten(jsonString);
        Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonString);
        LOGGER.info("Flattened Json String : {}", flattenedJsonString);
        flattenedJsonMap.forEach((k, v) -> System.out.println(k + " " + v));
        return flattenedJsonMap;
    }

    public Map<String, List<Object>> parseJson() {
        Map<String, List<Object>> cache = new LinkedHashMap<>();
        try {
            cache = loadCache();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        cache.forEach((k, v) -> System.out.println(k + " " + v));

        DbColumn dbColumn = DbColumn.builder()
                .id(1)
                .name("Name")
                .label("Name")
                .type("String")
                .groupedValues(getGroupedValues())
                .build();

        dbColumnRepository.save(dbColumn);

        return cache;
    }

    public void performTransformation() {


    }

    public List<List<String>> getGroupedValues() {
        List<List<String>> groupedValues = new LinkedList<>();

        List<String> record1 = new LinkedList<>();
        record1.add("A");
        record1.add("B");
        List<String> record2 = new LinkedList<>();
        record2.add("C");
        record2.add("D");
        groupedValues.add(record1);
        groupedValues.add(record2);

        return groupedValues;
    }

}
