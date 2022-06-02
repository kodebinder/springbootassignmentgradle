package com.company.service;

import com.company.configuration.MappingConfiguration;
import com.company.constant.Constants;
import com.company.dto.*;
import com.company.entity.*;
import com.company.repository.BaseDbColumnRepository;
import com.company.utility.*;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BaseDbColumnService {

    private static final Logger LOGGER = LogManager.getLogger(BaseDbColumnService.class);

    private static List<BaseDbColumn> baseDbColumns = new LinkedList<>();

    private final AddressUtility addressUtility;
    private final BankAccountUtility bankAccountUtility;
    private final BankOperationUtility bankOperationUtility;
    private final CompanyUtility companyUtility;
    private final PortfolioUtility portfolioUtility;
    private final PositionUtility positionUtility;

    private final UserUtility userUtility;

    private final BaseDbColumnRepository baseDbColumnRepository;
    private final MappingConfiguration mappingConfiguration;

    private final ModelMapper modelMapper;

    public BaseDbColumnService(
            final AddressUtility addressUtility,
            final BankAccountUtility bankAccountUtility,
            final BankOperationUtility bankOperationUtility,
            final CompanyUtility companyUtility,
            final PortfolioUtility portfolioUtility,
            final PositionUtility positionUtility,
            final UserUtility userUtility,
            final BaseDbColumnRepository baseDbColumnRepository,
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
        this.baseDbColumnRepository = baseDbColumnRepository;
        this.mappingConfiguration = mappingConfiguration;
        this.modelMapper = modelMapper;
    }

    public Map<String, List<Object>> getCache() throws ParseException {
        Map<String, List<Object>> cache = new LinkedHashMap<>();
        List<Object> investments = new LinkedList<>();
        List<Object> crm = new LinkedList<>();
        investments.add(Arrays.asList(portfolioUtility.loadPortfolios()));
        investments.add(Arrays.asList(bankAccountUtility.loadBankAccounts()));
        crm.add(Arrays.asList(userUtility.loadUsers()));
        crm.add(Arrays.asList(companyUtility.loadCompanies()));
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

    public List<String> getGroupedValues() {
        return Arrays.asList("A", "B", "C");
    }

    public void createBaseDbColumnsFromDto() throws ParseException, IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<Object> cacheValues = getCacheValues(getCache());
        for (int i = 0; i < cacheValues.size(); i++) {
            Object object = cacheValues.get(i);
            List<Object> existingDtoInsidePackage = getAllExistingDtoInsidePackage();
            List<Object> objects = (List<Object>) object;
            for (Object obj : objects) {
                if (obj.toString().contains(Constants.ADDRESSDTO)) {
                    AddressDto addressDto = mappingConfiguration.mapObjectToAddressDto(obj);
                    Address address = mappingConfiguration.mapAddressDtoToAddressEntity(addressDto);
                    Class<?> clazz = address.getClass();
                    parseFields(clazz);
                } else if (obj.toString().contains(Constants.BANKACCOUNTDTO)) {
                    BankAccountDto bankAccountDto = mappingConfiguration.mapObjectToBankAccountDto(obj);
                    BankAccount bankAccount = mappingConfiguration.mapBankAccountDtoToBankAccountEntity(bankAccountDto);
                    Class<?> clazz = bankAccount.getClass();
                    parseFields(clazz);
                } else if (obj.toString().contains(Constants.BANKOPERATIONDTO)) {
                    BankOperationDto bankOperationDto = mappingConfiguration.mapObjectToBankOperationDto(obj);
                    BankOperation bankOperation = mappingConfiguration.mapBankOperationDtoToBankOperationEntity(bankOperationDto);
                    Class<?> clazz = bankOperation.getClass();
                    parseFields(clazz);
                } else if (obj.toString().contains(Constants.COMPANYDTO)) {
                    CompanyDto companyDto = mappingConfiguration.mapObjectToCompanyDto(obj);
                    Company company = mappingConfiguration.mapCompanyDtoToCompanyEntity(companyDto);
                    Class<?> clazz = company.getClass();
                    parseFields(clazz);
                } else if (obj.toString().contains(Constants.PORTFOLIODTO)) {
                    PortfolioDto portfolioDto = mappingConfiguration.mapObjectToPortfolioDto(obj);
                    Portfolio portfolio = mappingConfiguration.mapPortfolioDtoToPortfolioEntity(portfolioDto);
                    Class<?> clazz = portfolio.getClass();
                    parseFields(clazz);
                } else if (obj.toString().contains(Constants.POSITIONDTO)) {
                    PositionDto positionDto = mappingConfiguration.mapObjectToPositionDto(obj);
                    Position position = mappingConfiguration.mapPositionDtoToPositionEntity(positionDto);
                    Class<?> clazz = position.getClass();
                    parseFields(clazz);
                } else if (obj.toString().contains(Constants.USERDTO)) {
                    UserDto userDto = mappingConfiguration.mapObjectToUserDto(obj);
                    User user = mappingConfiguration.mapUserDtoToUserEntity(userDto);
                    Class<?> clazz = user.getClass();
                    parseFields(clazz);
                }
            }
        }
    }

    /**
     * https://dzone.com/articles/get-all-classes-within-package
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws ParseException
     */
    public List<Object> getAllExistingDtoInsidePackage() throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ParseException {
        Class[] classes = getClasses("com.company.dto");
        List<Object> objects = new LinkedList<>();
        for (Class clazz : classes) {
            Constructor<?> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            Object object = cons.newInstance();
            objects.add(object);
        }
        LOGGER.info("Objects : {}", objects);
        return objects;
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static Class[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList();
        while (resources.hasMoreElements()) {
            URL resource = (URL) resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList classes = new ArrayList();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return (Class[]) classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List findClasses(File directory, String packageName) throws ClassNotFoundException {
        List classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith("Dto.class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    public static List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[]) obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>) obj);
        }
        return list;
    }

    public Set<String> getCacheKeys(Map<String, List<Object>> cache) {
        Set<String> keySet = cache.keySet();
        return keySet;
    }

    public List<Object> getCacheValues(Map<String, List<Object>> cache) {
        Collection<List<Object>> values = cache.values();
        return flatten(values).collect(Collectors.toList());
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

            BaseDbColumn existing = baseDbColumnRepository.findByName(field.getName());
            if (Objects.nonNull(existing)) {
                baseDbColumn.setId(existing.getId());
            }

            baseDbColumns.add(baseDbColumn);

            baseDbColumnRepository.save(baseDbColumn);
        }
    }

    public List<BaseDbColumn> getListBaseDbColumns() throws ParseException, IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        createBaseDbColumnsFromDto();
        baseDbColumns.forEach(System.out::println);
        return baseDbColumns;
    }
}

