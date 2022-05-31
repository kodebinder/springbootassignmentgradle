package com.company.service;

import com.company.configuration.MappingConfiguration;
import com.company.dto.*;
import com.company.entity.*;
import com.company.repository.DbColumnRepository;
import com.company.utility.*;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
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

    public Map<String, List<Map<String, Object>>> getCache() throws ParseException {
        Map<String, List<Map<String, Object>>> cache = new LinkedHashMap<>();

        List<Map<String, Object>> investments = new LinkedList<>();

        Map<String, Object> portfolioCache = new LinkedHashMap<>();
        portfolioCache.put("portfolio", Arrays.asList(portfolioUtility.loadPortfolios()));
        investments.add(portfolioCache);

        Map<String, Object> bankAccountCache = new LinkedHashMap<>();
        bankAccountCache.put("bankAccount", Arrays.asList(bankAccountUtility.loadBankAccounts()));
        investments.add(bankAccountCache);

        List<Map<String, Object>> crm = new LinkedList<>();

        Map<String, Object> userCache = new LinkedHashMap<>();
        userCache.put("user", Arrays.asList(userUtility.loadUsers()));
        crm.add(userCache);

        Map<String, Object> companyCache = new LinkedHashMap<>();
        companyCache.put("company", Arrays.asList(companyUtility.loadCompanies()));
        crm.add(companyCache);

        cache.put("investments", investments);
        cache.put("crm", crm);

        return cache;
    }

    /**
     * To flatten a map containing a list of items as values
     *
     * @param values
     * @param <T>
     * @return
     */
    public static <T> Stream<T> flatten(Collection<List<T>> values) {
        Stream<T> stream = values.stream().flatMap(Collection::stream);
        return stream;
    }

    /**
     * Get Flattened Json
     *
     * @param cache
     * @return
     */
    public Map<String, Object> getFlattenedJson(Map<String, List<Map<String, Object>>> cache) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(cache);
        String flattenedJsonString = JsonFlattener.flatten(jsonString);
        Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonString);
        LOGGER.info("Flattened Json String : {}", flattenedJsonString);
        flattenedJsonMap.forEach((k, v) -> System.out.println(k + " " + v));
        return flattenedJsonMap;
    }

    public Map<String, List<Map<String, Object>>> parseJson() {
        Map<String, List<Map<String, Object>>> cache = new LinkedHashMap<>();
        try {
            cache = getCache();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        cache.forEach((k, v) -> System.out.println(k + " " + v));
        return cache;
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

        Map<String, List<Map<String, Object>>> cache = getCache();

        for (int i = 0; i < cache.size(); i++) {
            for (Map.Entry<String, List<Map<String, Object>>> e : cache.entrySet()) {
                for (Map<String, Object> map : e.getValue()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if ("address".equals(key)) {
                            AddressDto addressDto = mappingConfiguration.mapObjectToAddressDto(value);
                            Address address = mappingConfiguration.mapAddressDtoToAddressEntity(addressDto);
                            Class<?> clazz = address.getClass();
                            parseFields(clazz);
                        } else if ("bankAccount".equals(key)) {
                            BankAccountDto bankAccountDto = mappingConfiguration.mapObjectToBankAccountDto(value);
                            BankAccount bankAccount = mappingConfiguration.mapBankAccountDtoToBankAccountEntity(bankAccountDto);
                            Class<?> clazz = bankAccount.getClass();
                            parseFields(clazz);
                        } else if ("bankOperation".equals(key)) {
                            BankOperationDto bankOperationDto = mappingConfiguration.mapObjectToBankOperationDto(value);
                            BankOperation bankOperation = mappingConfiguration.mapBankOperationDtoToBankOperationEntity(bankOperationDto);
                            Class<?> clazz = bankOperation.getClass();
                            parseFields(clazz);
                        } else if ("company".equals(key)) {
                            CompanyDto companyDto = mappingConfiguration.mapObjectToCompanyDto(value);
                            Company company = mappingConfiguration.mapCompanyDtoToCompanyEntity(companyDto);
                            Class<?> clazz = company.getClass();
                            parseFields(clazz);
                        } else if ("portfolio".equals(key)) {
                            PortfolioDto portfolioDto = mappingConfiguration.mapObjectToPortfolioDto(value);
                            Portfolio portfolio = mappingConfiguration.mapPortfolioDtoToPortfolioEntity(portfolioDto);
                            Class<?> clazz = portfolio.getClass();
                            parseFields(clazz);
                        } else if ("position".equals(key)) {
                            PositionDto positionDto = mappingConfiguration.mapObjectToPositionDto(value);
                            Position position = mappingConfiguration.mapPositionDtoToPositionEntity(positionDto);
                            Class<?> clazz = position.getClass();
                            parseFields(clazz);
                        } else if ("user".equals(key)) {
                            UserDto userDto = mappingConfiguration.mapObjectToUserDto(value);
                            User user = mappingConfiguration.mapUserDtoToUserEntity(userDto);
                            Class<?> clazz = user.getClass();
                            parseFields(clazz);
                        }
                    }
                }
            }
        }
    }

    private void parseFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            BaseDbColumn baseDbColumn = BaseDbColumn.builder()
                    .name(field.getName())
                    .label(field.getName())
                    .type(String.valueOf(field.getAnnotatedType()))
                    .groupedValues(getGroupedValues())
                    .build();

            BaseDbColumn existing = dbColumnRepository.findByName(field.getName());
            if (Objects.nonNull(existing)) {
                baseDbColumn.setId(existing.getId());
            }

            dbColumnRepository.save(baseDbColumn);


        }
    }
}
