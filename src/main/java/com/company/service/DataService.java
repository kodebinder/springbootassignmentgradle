package com.company.service;

import com.company.configuration.MappingConfiguration;
import com.company.entity.*;
import com.company.repository.DbColumnRepository;
import com.company.utility.*;
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

    private final AddressUtility addressUtility;
    private final BankAccountUtility bankAccountUtility;
    private final BankOperationUtility bankOperationUtility;
    private final CompanyUtility companyUtility;
    private final PortfolioUtility portfolioUtility;
    private final PositionUtility positionUtility;

    private final UserUtility userUtility;

    private final DbColumnRepository dbColumnRepository;
    private final MappingConfiguration mappingConfiguration;

    private final ModelMapper modelMapper;

    public DataService(
            final AddressUtility addressUtility,
            final BankAccountUtility bankAccountUtility,
            final BankOperationUtility bankOperationUtility,
            final CompanyUtility companyUtility,
            final PortfolioUtility portfolioUtility,
            final PositionUtility positionUtility,
            final UserUtility userUtility,
            final DbColumnRepository dbColumnRepository,
            final MappingConfiguration mappingConfiguration,
            final ModelMapper modelMapper
    ) {
        this.addressUtility = addressUtility;
        this.bankAccountUtility = bankAccountUtility;
        this.bankOperationUtility = bankOperationUtility;
        this.companyUtility = companyUtility;
        this.portfolioUtility = portfolioUtility;
        this.positionUtility = positionUtility;
        this.userUtility = userUtility;
        this.dbColumnRepository = dbColumnRepository;
        this.mappingConfiguration = mappingConfiguration;
        this.modelMapper = modelMapper;
    }

    public Map<String, List<Object>> getCache() throws ParseException {
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
            cache = getCache();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        cache.forEach((k, v) -> System.out.println(k + " " + v));
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

    public void createBaseDbColumnsFromDto() throws ParseException {

        Map<String, List<Object>> cache = getCache();
        cache.get("investments");

        List<Object> list = new LinkedList<>();
        list.add(mappingConfiguration.mapAddressDtoToAddressEntity(addressUtility.getAddressDetailsForMark()));
        list.add(mappingConfiguration.mapBankAccountDtoToBankAccountEntity(bankAccountUtility.getIciciBankAccountDetails()));
        list.add(mappingConfiguration.mapBankOperationDtoToBankOperationEntity(bankOperationUtility.getIciciBankOperationDetails()));
        list.add(mappingConfiguration.mapCompanyDtoToCompanyEntity(companyUtility.getRelianceDetails()));
        list.add(mappingConfiguration.mapPortfolioDtoToPortfolioEntity(portfolioUtility.getConservativePortfolioDetails()));
        list.add(mappingConfiguration.mapPositionDtoToPositionEntity(positionUtility.getPositionAtStartOfMonthForAggressivePortfolio()));
        list.add(mappingConfiguration.mapUserDtoToUserEntity(userUtility.getUserDetailsForJohn()));

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                Address address = (Address) list.get(i);
                BaseDbColumn baseDbColumn = BaseDbColumn.builder()
                        .name("address")
                        .label("address")
                        .type("String")
                        .groupedValues(getGroupedValues())
                        .build();
                dbColumnRepository.save(baseDbColumn);
            } else if (i == 1) {
                BankAccount bankAccount = (BankAccount) list.get(i);
                BaseDbColumn baseDbColumn = BaseDbColumn.builder()
                        .name("bankAccount")
                        .label("bankAccount")
                        .type("String")
                        .groupedValues(getGroupedValues())
                        .build();
                dbColumnRepository.save(baseDbColumn);
            } else if (i == 2) {
                BankOperation bankOperation = (BankOperation) list.get(i);
                BaseDbColumn baseDbColumn = BaseDbColumn.builder()
                        .name("bankOperation")
                        .label("bankOperation")
                        .type("String")
                        .groupedValues(getGroupedValues())
                        .build();
                dbColumnRepository.save(baseDbColumn);
            } else if (i == 3) {
                Company company = (Company) list.get(i);
                BaseDbColumn baseDbColumn = BaseDbColumn.builder()
                        .name("company")
                        .label("company")
                        .type("String")
                        .groupedValues(getGroupedValues())
                        .build();
                dbColumnRepository.save(baseDbColumn);
            } else if (i == 4) {
                Portfolio portfolio = (Portfolio) list.get(i);
                BaseDbColumn baseDbColumn = BaseDbColumn.builder()
                        .name("portfolio")
                        .label("portfolio")
                        .type("String")
                        .groupedValues(getGroupedValues())
                        .build();
                dbColumnRepository.save(baseDbColumn);
            } else if (i == 5) {
                Position position = (Position) list.get(i);
                BaseDbColumn baseDbColumn = BaseDbColumn.builder()
                        .name("position")
                        .label("position")
                        .type("String")
                        .groupedValues(getGroupedValues())
                        .build();
                dbColumnRepository.save(baseDbColumn);
            } else if (i == 6) {
                User user = (User) list.get(i);
                BaseDbColumn baseDbColumn = BaseDbColumn.builder()
                        .name("user")
                        .label("user")
                        .type("String")
                        .groupedValues(getGroupedValues())
                        .build();
                dbColumnRepository.save(baseDbColumn);
            }
        }
    }
}
