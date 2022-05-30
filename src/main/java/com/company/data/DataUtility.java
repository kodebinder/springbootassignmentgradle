package com.company.data;

import com.company.utility.BankAccountUtility;
import com.company.utility.CompanyUtility;
import com.company.utility.PortfolioUtility;
import com.company.utility.UserUtility;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Stream;

@Component
public class DataUtility {

    private final PortfolioUtility portfolioUtility;
    private final BankAccountUtility bankAccountUtility;
    private final UserUtility userUtility;
    private final CompanyUtility companyUtility;

    @Autowired
    public DataUtility(
            final PortfolioUtility portfolioUtility,
            final BankAccountUtility bankAccountUtility,
            final UserUtility userUtility,
            final CompanyUtility companyUtility
    ) {
        this.portfolioUtility = portfolioUtility;
        this.bankAccountUtility = bankAccountUtility;
        this.userUtility = userUtility;
        this.companyUtility = companyUtility;
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
     *
     */
    public <T> Stream<T> flatten(Collection<List<T>> values) {
        return values.stream().flatMap(Collection::stream);
    }

    /**
     * Display flatten Json
     *
     * @param cache
     */
    public void displayFlattenedJson(Map<String, List<Object>> cache) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(cache);
        String flattenedJson = JsonFlattener.flatten(jsonString);
        Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonString);
        flattenedJsonMap.forEach((k, v) -> System.out.println(k + " " + v));
    }

}
