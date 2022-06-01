package com.company.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.company.configuration.MappingConfiguration;
import com.company.dto.BankAccountDto;
import com.company.dto.CompanyDto;
import com.company.dto.PortfolioDto;
import com.company.dto.UserDto;
import com.company.entity.BaseDbColumn;
import com.company.repository.BaseDbColumnRepository;
import com.company.utility.AddressUtility;
import com.company.utility.BankAccountUtility;
import com.company.utility.BankOperationUtility;
import com.company.utility.CompanyUtility;
import com.company.utility.PortfolioUtility;
import com.company.utility.PositionUtility;
import com.company.utility.UserUtility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BaseDbColumnService.class, MappingConfiguration.class})
@ExtendWith(SpringExtension.class)
class BaseDbColumnServiceTest {
    @MockBean
    private AddressUtility addressUtility;

    @MockBean
    private BankAccountUtility bankAccountUtility;

    @MockBean
    private BankOperationUtility bankOperationUtility;

    @MockBean
    private BaseDbColumnRepository baseDbColumnRepository;

    @Autowired
    private BaseDbColumnService baseDbColumnService;

    @MockBean
    private CompanyUtility companyUtility;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private PortfolioUtility portfolioUtility;

    @MockBean
    private PositionUtility positionUtility;

    @MockBean
    private UserUtility userUtility;

    /**
     * Method under test: {@link BaseDbColumnService#getCache()}
     */
    @Test
    void testGetCache() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Map<String, Object>>> actualCache = this.baseDbColumnService.getCache();
        assertEquals(2, actualCache.size());
        List<Map<String, Object>> getResult = actualCache.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualCache.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getCache()}
     */
    @Test
    void testGetCache2() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.baseDbColumnService.getCache());
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getCache()}
     */
    @Test
    void testGetCache3() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenThrow(new RuntimeException("An error occurred"));
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        assertThrows(RuntimeException.class, () -> this.baseDbColumnService.getCache());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#flatten(java.util.Collection)}
     */
    @Test
    void testFlatten() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by flatten(Collection)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        BaseDbColumnService.flatten(new ArrayList<>());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson() {
        assertTrue(this.baseDbColumnService.getFlattenedJson(new HashMap<>()).isEmpty());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson2() {
        HashMap<String, List<Map<String, Object>>> stringListMap = new HashMap<>();
        stringListMap.put("Flattened Json String : {}", new ArrayList<>());
        assertTrue(this.baseDbColumnService.getFlattenedJson(stringListMap).isEmpty());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson3() {
        HashMap<String, List<Map<String, Object>>> stringListMap = new HashMap<>();
        stringListMap.put("", new ArrayList<>());
        assertTrue(this.baseDbColumnService.getFlattenedJson(stringListMap).isEmpty());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson4() {
        HashMap<String, List<Map<String, Object>>> stringListMap = new HashMap<>();
        stringListMap.put("Key", new ArrayList<>());
        stringListMap.put("Flattened Json String : {}", new ArrayList<>());
        assertTrue(this.baseDbColumnService.getFlattenedJson(stringListMap).isEmpty());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson5() {
        ArrayList<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(new HashMap<>());

        HashMap<String, List<Map<String, Object>>> stringListMap = new HashMap<>();
        stringListMap.put("Flattened Json String : {}", mapList);
        assertTrue(this.baseDbColumnService.getFlattenedJson(stringListMap).isEmpty());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson6() {
        ArrayList<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(new HashMap<>());
        mapList.add(new HashMap<>());

        HashMap<String, List<Map<String, Object>>> stringListMap = new HashMap<>();
        stringListMap.put("Flattened Json String : {}", mapList);
        assertTrue(this.baseDbColumnService.getFlattenedJson(stringListMap).isEmpty());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson7() {
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("Flattened Json String : {}", "Value");

        ArrayList<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(stringObjectMap);

        HashMap<String, List<Map<String, Object>>> stringListMap = new HashMap<>();
        stringListMap.put("Flattened Json String : {}", mapList);
        assertEquals(1, this.baseDbColumnService.getFlattenedJson(stringListMap).size());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson8() {
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("Flattened Json String : {}", 42);

        ArrayList<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(stringObjectMap);

        HashMap<String, List<Map<String, Object>>> stringListMap = new HashMap<>();
        stringListMap.put("Flattened Json String : {}", mapList);
        assertEquals(1, this.baseDbColumnService.getFlattenedJson(stringListMap).size());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson9() {
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("Flattened Json String : {}", Integer.MIN_VALUE);

        ArrayList<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(stringObjectMap);

        HashMap<String, List<Map<String, Object>>> stringListMap = new HashMap<>();
        stringListMap.put("Flattened Json String : {}", mapList);
        assertEquals(1, this.baseDbColumnService.getFlattenedJson(stringListMap).size());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson10() {
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("Key", "Value");
        stringObjectMap.put("Flattened Json String : {}", "Value");

        ArrayList<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(stringObjectMap);

        HashMap<String, List<Map<String, Object>>> stringListMap = new HashMap<>();
        stringListMap.put("Flattened Json String : {}", mapList);
        assertEquals(2, this.baseDbColumnService.getFlattenedJson(stringListMap).size());
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Map<String, Object>>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        List<Map<String, Object>> getResult = actualParseJsonResult.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualParseJsonResult.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson2() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.baseDbColumnService.parseJson());
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson3() throws ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Map<String, Object>>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        List<Map<String, Object>> getResult = actualParseJsonResult.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualParseJsonResult.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson4() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());

        ArrayList<PortfolioDto> portfolioDtoList = new ArrayList<>();
        portfolioDtoList.add(new PortfolioDto());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(portfolioDtoList);
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Map<String, Object>>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        List<Map<String, Object>> getResult = actualParseJsonResult.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualParseJsonResult.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson5() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());

        ArrayList<CompanyDto> companyDtoList = new ArrayList<>();
        companyDtoList.add(new CompanyDto(123L, "42", "portfolio", "portfolio", 1, true));
        when(this.companyUtility.loadCompanies()).thenReturn(companyDtoList);
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Map<String, Object>>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        List<Map<String, Object>> getResult = actualParseJsonResult.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualParseJsonResult.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson6() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());

        ArrayList<BankAccountDto> bankAccountDtoList = new ArrayList<>();
        bankAccountDtoList.add(new BankAccountDto());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(bankAccountDtoList);
        Map<String, List<Map<String, Object>>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        List<Map<String, Object>> getResult = actualParseJsonResult.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualParseJsonResult.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson7() throws ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Map<String, Object>>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        List<Map<String, Object>> getResult = actualParseJsonResult.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualParseJsonResult.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson8() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());

        ArrayList<PortfolioDto> portfolioDtoList = new ArrayList<>();
        portfolioDtoList.add(new PortfolioDto());
        portfolioDtoList.add(new PortfolioDto());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(portfolioDtoList);
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Map<String, Object>>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        List<Map<String, Object>> getResult = actualParseJsonResult.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualParseJsonResult.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson9() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());

        ArrayList<CompanyDto> companyDtoList = new ArrayList<>();
        companyDtoList.add(new CompanyDto(123L, "42", "portfolio", "portfolio", 1, true));
        companyDtoList.add(new CompanyDto(123L, "42", "portfolio", "portfolio", 1, true));
        when(this.companyUtility.loadCompanies()).thenReturn(companyDtoList);
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Map<String, Object>>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        List<Map<String, Object>> getResult = actualParseJsonResult.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualParseJsonResult.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#parseJson()}
     */
    @Test
    void testParseJson10() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());

        ArrayList<BankAccountDto> bankAccountDtoList = new ArrayList<>();
        bankAccountDtoList.add(new BankAccountDto());
        bankAccountDtoList.add(new BankAccountDto());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(bankAccountDtoList);
        Map<String, List<Map<String, Object>>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        List<Map<String, Object>> getResult = actualParseJsonResult.get("investments");
        assertEquals(2, getResult.size());
        List<Map<String, Object>> getResult1 = actualParseJsonResult.get("crm");
        assertEquals(2, getResult1.size());
        assertEquals(1, getResult.get(1).size());
        assertEquals(1, getResult1.get(1).size());
        assertEquals(1, getResult.get(0).size());
        assertEquals(1, getResult1.get(0).size());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getGroupedValues()}
     */
    @Test
    void testGetGroupedValues() {
        List<List<String>> actualGroupedValues = this.baseDbColumnService.getGroupedValues();
        assertEquals(2, actualGroupedValues.size());
        List<String> getResult = actualGroupedValues.get(0);
        assertEquals(2, getResult.size());
        assertEquals("A", getResult.get(0));
        assertEquals("B", getResult.get(1));
        List<String> getResult1 = actualGroupedValues.get(1);
        assertEquals(2, getResult1.size());
        assertEquals("C", getResult1.get(0));
        assertEquals("D", getResult1.get(1));
    }

    /**
     * Method under test: {@link BaseDbColumnService#createBaseDbColumnsFromDto()}
     */
    @Test
    void testCreateBaseDbColumnsFromDto() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());

        BaseDbColumn baseDbColumn = new BaseDbColumn();
        baseDbColumn.setGroupedValues(new ArrayList<>());
        baseDbColumn.setId(123L);
        baseDbColumn.setLabel("Label");
        baseDbColumn.setName("Name");
        baseDbColumn.setType("Type");

        BaseDbColumn baseDbColumn1 = new BaseDbColumn();
        baseDbColumn1.setGroupedValues(new ArrayList<>());
        baseDbColumn1.setId(123L);
        baseDbColumn1.setLabel("Label");
        baseDbColumn1.setName("Name");
        baseDbColumn1.setType("Type");
        when(this.baseDbColumnRepository.findByName((String) any())).thenReturn(baseDbColumn);
        when(this.baseDbColumnRepository.save((BaseDbColumn) any())).thenReturn(baseDbColumn1);
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        this.baseDbColumnService.createBaseDbColumnsFromDto();
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.baseDbColumnRepository, atLeast(1)).findByName((String) any());
        verify(this.baseDbColumnRepository, atLeast(1)).save((BaseDbColumn) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#createBaseDbColumnsFromDto()}
     */
    @Test
    void testCreateBaseDbColumnsFromDto2() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());

        BaseDbColumn baseDbColumn = new BaseDbColumn();
        baseDbColumn.setGroupedValues(new ArrayList<>());
        baseDbColumn.setId(123L);
        baseDbColumn.setLabel("Label");
        baseDbColumn.setName("Name");
        baseDbColumn.setType("Type");

        BaseDbColumn baseDbColumn1 = new BaseDbColumn();
        baseDbColumn1.setGroupedValues(new ArrayList<>());
        baseDbColumn1.setId(123L);
        baseDbColumn1.setLabel("Label");
        baseDbColumn1.setName("Name");
        baseDbColumn1.setType("Type");
        when(this.baseDbColumnRepository.findByName((String) any())).thenReturn(baseDbColumn);
        when(this.baseDbColumnRepository.save((BaseDbColumn) any())).thenReturn(baseDbColumn1);
        when(this.bankAccountUtility.loadBankAccounts()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.baseDbColumnService.createBaseDbColumnsFromDto());
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#createBaseDbColumnsFromDto()}
     */
    @Test
    void testCreateBaseDbColumnsFromDto3() throws ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        BaseDbColumn baseDbColumn = mock(BaseDbColumn.class);
        when(baseDbColumn.getId()).thenReturn(123L);
        doNothing().when(baseDbColumn).setGroupedValues((List<List<String>>) any());
        doNothing().when(baseDbColumn).setId(anyLong());
        doNothing().when(baseDbColumn).setLabel((String) any());
        doNothing().when(baseDbColumn).setName((String) any());
        doNothing().when(baseDbColumn).setType((String) any());
        baseDbColumn.setGroupedValues(new ArrayList<>());
        baseDbColumn.setId(123L);
        baseDbColumn.setLabel("Label");
        baseDbColumn.setName("Name");
        baseDbColumn.setType("Type");

        BaseDbColumn baseDbColumn1 = new BaseDbColumn();
        baseDbColumn1.setGroupedValues(new ArrayList<>());
        baseDbColumn1.setId(123L);
        baseDbColumn1.setLabel("Label");
        baseDbColumn1.setName("Name");
        baseDbColumn1.setType("Type");
        when(this.baseDbColumnRepository.findByName((String) any())).thenReturn(baseDbColumn);
        when(this.baseDbColumnRepository.save((BaseDbColumn) any())).thenReturn(baseDbColumn1);
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        this.baseDbColumnService.createBaseDbColumnsFromDto();
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.baseDbColumnRepository, atLeast(1)).findByName((String) any());
        verify(this.baseDbColumnRepository, atLeast(1)).save((BaseDbColumn) any());
        verify(baseDbColumn, atLeast(1)).getId();
        verify(baseDbColumn).setGroupedValues((List<List<String>>) any());
        verify(baseDbColumn).setId(anyLong());
        verify(baseDbColumn).setLabel((String) any());
        verify(baseDbColumn).setName((String) any());
        verify(baseDbColumn).setType((String) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }
}

