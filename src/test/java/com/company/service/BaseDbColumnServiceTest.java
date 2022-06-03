package com.company.service;

import com.company.configuration.MappingConfiguration;
import com.company.dto.BankAccountDto;
import com.company.dto.CompanyDto;
import com.company.dto.PortfolioDto;
import com.company.dto.UserDto;
import com.company.entity.BaseDbColumn;
import com.company.repository.BaseDbColumnRepository;
import com.company.utility.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {BaseDbColumnService.class, MappingConfiguration.class})
@ExtendWith(SpringExtension.class)
class BaseDbColumnServiceTest {
    @Autowired
    private BaseDbColumnService baseDbColumnService;

    @MockBean
    private AddressUtility addressUtility;

    @MockBean
    private BankAccountUtility bankAccountUtility;

    @MockBean
    private BankOperationUtility bankOperationUtility;

    @MockBean
    private BaseDbColumnRepository baseDbColumnRepository;

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
        Map<String, List<Object>> actualCache = this.baseDbColumnService.getCache();
        assertEquals(2, actualCache.size());
        assertEquals(2, actualCache.get("investments").size());
        assertEquals(2, actualCache.get("crm").size());
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
     * Method under test: {@link BaseDbColumnService#getFlattenedJson(Map)}
     */
    @Test
    void testGetFlattenedJson() {
        assertTrue(this.baseDbColumnService.getFlattenedJson(new HashMap<>()).isEmpty());
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
        Map<String, List<Object>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        assertEquals(2, actualParseJsonResult.get("investments").size());
        assertEquals(2, actualParseJsonResult.get("crm").size());
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
        Map<String, List<Object>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        assertEquals(2, actualParseJsonResult.get("investments").size());
        assertEquals(2, actualParseJsonResult.get("crm").size());
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
        Map<String, List<Object>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        assertEquals(2, actualParseJsonResult.get("investments").size());
        assertEquals(2, actualParseJsonResult.get("crm").size());
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
        companyDtoList.add(new CompanyDto(123L, "42", "investments", "investments", 1, true));
        when(this.companyUtility.loadCompanies()).thenReturn(companyDtoList);
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Object>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        assertEquals(2, actualParseJsonResult.get("investments").size());
        assertEquals(2, actualParseJsonResult.get("crm").size());
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
        Map<String, List<Object>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        assertEquals(2, actualParseJsonResult.get("investments").size());
        assertEquals(2, actualParseJsonResult.get("crm").size());
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
        Map<String, List<Object>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        assertEquals(2, actualParseJsonResult.get("investments").size());
        assertEquals(2, actualParseJsonResult.get("crm").size());
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
        Map<String, List<Object>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        assertEquals(2, actualParseJsonResult.get("investments").size());
        assertEquals(2, actualParseJsonResult.get("crm").size());
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
        companyDtoList.add(new CompanyDto(123L, "42", "investments", "investments", 1, true));
        companyDtoList.add(new CompanyDto(123L, "42", "investments", "investments", 1, true));
        when(this.companyUtility.loadCompanies()).thenReturn(companyDtoList);
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        Map<String, List<Object>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        assertEquals(2, actualParseJsonResult.get("investments").size());
        assertEquals(2, actualParseJsonResult.get("crm").size());
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
        Map<String, List<Object>> actualParseJsonResult = this.baseDbColumnService.parseJson();
        assertEquals(2, actualParseJsonResult.size());
        assertEquals(2, actualParseJsonResult.get("investments").size());
        assertEquals(2, actualParseJsonResult.get("crm").size());
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
        List<String> actualGroupedValues = this.baseDbColumnService.getGroupedValues();
        assertEquals(3, actualGroupedValues.size());
        assertEquals("A", actualGroupedValues.get(0));
        assertEquals("B", actualGroupedValues.get(1));
        assertEquals("C", actualGroupedValues.get(2));
    }

    /**
     * Method under test: {@link BaseDbColumnService#createBaseDbColumnsFromDto()}
     */
    @Test
    void testCreateBaseDbColumnsFromDto() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(new ArrayList<>());
        this.baseDbColumnService.createBaseDbColumnsFromDto();
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#createBaseDbColumnsFromDto()}
     */
    @Test
    void testCreateBaseDbColumnsFromDto2() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.baseDbColumnService.createBaseDbColumnsFromDto());
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#createBaseDbColumnsFromDto()}
     */
    @Test
    void testCreateBaseDbColumnsFromDto3() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
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
    void testCreateBaseDbColumnsFromDto4() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
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
    void testCreateBaseDbColumnsFromDto5() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);

        ArrayList<PortfolioDto> portfolioDtoList = new ArrayList<>();
        portfolioDtoList.add(new PortfolioDto());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(portfolioDtoList);
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
    void testCreateBaseDbColumnsFromDto6() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());

        ArrayList<CompanyDto> companyDtoList = new ArrayList<>();
        companyDtoList.add(new CompanyDto(123L, "42", "investments", "investments", 1, true));
        when(this.companyUtility.loadCompanies()).thenReturn(companyDtoList);

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
    void testCreateBaseDbColumnsFromDto7() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        BaseDbColumn baseDbColumn = mock(BaseDbColumn.class);
        when(baseDbColumn.getId()).thenReturn(123L);
        doNothing().when(baseDbColumn).setGroupedValues((List<String>) any());
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
        verify(baseDbColumn).setGroupedValues((List<String>) any());
        verify(baseDbColumn).setId(anyLong());
        verify(baseDbColumn).setLabel((String) any());
        verify(baseDbColumn).setName((String) any());
        verify(baseDbColumn).setType((String) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#createBaseDbColumnsFromDto()}
     */
    @Test
    void testCreateBaseDbColumnsFromDto8() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        BaseDbColumn baseDbColumn = mock(BaseDbColumn.class);
        when(baseDbColumn.getId()).thenReturn(123L);
        doNothing().when(baseDbColumn).setGroupedValues((List<String>) any());
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

        ArrayList<BankAccountDto> bankAccountDtoList = new ArrayList<>();
        bankAccountDtoList.add(new BankAccountDto());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(bankAccountDtoList);
        this.baseDbColumnService.createBaseDbColumnsFromDto();
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.baseDbColumnRepository, atLeast(1)).findByName((String) any());
        verify(this.baseDbColumnRepository, atLeast(1)).save((BaseDbColumn) any());
        verify(baseDbColumn, atLeast(1)).getId();
        verify(baseDbColumn).setGroupedValues((List<String>) any());
        verify(baseDbColumn).setId(anyLong());
        verify(baseDbColumn).setLabel((String) any());
        verify(baseDbColumn).setName((String) any());
        verify(baseDbColumn).setType((String) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getAllExistingDtoInsidePackage()}
     */
    @Test
    void testGetAllExistingDtoInsidePackage() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        assertEquals(7, this.baseDbColumnService.getAllExistingDtoInsidePackage().size());
    }

    /**
     * Method under test: {@link BaseDbColumnService#convertObjectToList(Object)}
     */
    @Test
    void testConvertObjectToList() {
        assertTrue(BaseDbColumnService.convertObjectToList("Obj").isEmpty());
        assertTrue(BaseDbColumnService.convertObjectToList(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getCacheKeys(java.util.Map)}
     */
    @Test
    void testGetCacheKeys() {
        assertTrue(this.baseDbColumnService.getCacheKeys(new HashMap<>()).isEmpty());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getCacheValues(java.util.Map)}
     */
    @Test
    void testGetCacheValues() {
        assertTrue(this.baseDbColumnService.getCacheValues(new HashMap<>()).isEmpty());
    }

    /**
     * Method under test: {@link BaseDbColumnService#getListBaseDbColumns()}
     */
    @Test
    void testGetListBaseDbColumns() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        when(this.userUtility.loadUsers()).thenReturn(new ArrayList<>());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        when(this.bankAccountUtility.loadBankAccounts()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.baseDbColumnService.getListBaseDbColumns());
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getListBaseDbColumns()}
     */
    @Test
    void testGetListBaseDbColumns2() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
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
        List<BaseDbColumn> actualListBaseDbColumns = this.baseDbColumnService.getListBaseDbColumns();
        BaseDbColumn getResult = actualListBaseDbColumns.get(3545);
        assertEquals("userId", getResult.getName());
        assertEquals("userId", getResult.getLabel());
        assertEquals(123L, getResult.getId());
        BaseDbColumn getResult1 = actualListBaseDbColumns.get(3544);
        assertEquals("userFirstName", getResult1.getName());
        assertEquals("userFirstName", getResult1.getLabel());
        assertEquals(123L, getResult1.getId());
        BaseDbColumn getResult2 = actualListBaseDbColumns.get(3543);
        assertEquals("email", getResult2.getName());
        assertEquals("email", getResult2.getLabel());
        assertEquals(123L, getResult2.getId());
        BaseDbColumn getResult3 = actualListBaseDbColumns.get(3542);
        assertEquals("mobileNumbers", getResult3.getName());
        assertEquals("mobileNumbers", getResult3.getLabel());
        assertEquals(123L, getResult3.getId());
        BaseDbColumn getResult4 = actualListBaseDbColumns.get(3546);
        assertEquals("userLastName", getResult4.getName());
        assertEquals("userLastName", getResult4.getLabel());
        assertEquals(123L, getResult4.getId());
        assertEquals("java.util.List<java.lang.String>", getResult3.getType());
        assertEquals("java.lang.String", getResult4.getType());
        assertEquals("java.lang.String", getResult.getType());
        assertEquals("java.lang.String", getResult1.getType());
        assertEquals("java.lang.String", getResult2.getType());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.baseDbColumnRepository, atLeast(1)).findByName((String) any());
        verify(this.baseDbColumnRepository, atLeast(1)).save((BaseDbColumn) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getListBaseDbColumns()}
     */
    @Test
    void testGetListBaseDbColumns3() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
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
        List<BaseDbColumn> actualListBaseDbColumns = this.baseDbColumnService.getListBaseDbColumns();
        BaseDbColumn getResult = actualListBaseDbColumns.get(3566);
        assertEquals("userId", getResult.getName());
        assertEquals("userId", getResult.getLabel());
        assertEquals(123L, getResult.getId());
        BaseDbColumn getResult1 = actualListBaseDbColumns.get(3565);
        assertEquals("userFirstName", getResult1.getName());
        assertEquals("userFirstName", getResult1.getLabel());
        assertEquals(123L, getResult1.getId());
        BaseDbColumn getResult2 = actualListBaseDbColumns.get(3564);
        assertEquals("email", getResult2.getName());
        assertEquals("email", getResult2.getLabel());
        assertEquals(123L, getResult2.getId());
        BaseDbColumn getResult3 = actualListBaseDbColumns.get(3563);
        assertEquals("mobileNumbers", getResult3.getName());
        assertEquals("mobileNumbers", getResult3.getLabel());
        assertEquals(123L, getResult3.getId());
        BaseDbColumn getResult4 = actualListBaseDbColumns.get(3567);
        assertEquals("userLastName", getResult4.getName());
        assertEquals("userLastName", getResult4.getLabel());
        assertEquals(123L, getResult4.getId());
        assertEquals("java.util.List<java.lang.String>", getResult3.getType());
        assertEquals("java.lang.String", getResult4.getType());
        assertEquals("java.lang.String", getResult.getType());
        assertEquals("java.lang.String", getResult1.getType());
        assertEquals("java.lang.String", getResult2.getType());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.baseDbColumnRepository, atLeast(1)).findByName((String) any());
        verify(this.baseDbColumnRepository, atLeast(1)).save((BaseDbColumn) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getListBaseDbColumns()}
     */
    @Test
    void testGetListBaseDbColumns4() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);

        ArrayList<PortfolioDto> portfolioDtoList = new ArrayList<>();
        portfolioDtoList.add(new PortfolioDto());
        when(this.portfolioUtility.loadPortfolios()).thenReturn(portfolioDtoList);
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
        List<BaseDbColumn> actualListBaseDbColumns = this.baseDbColumnService.getListBaseDbColumns();
        BaseDbColumn getResult = actualListBaseDbColumns.get(3595);
        assertEquals("userId", getResult.getName());
        assertEquals("userId", getResult.getLabel());
        assertEquals(123L, getResult.getId());
        BaseDbColumn getResult1 = actualListBaseDbColumns.get(3594);
        assertEquals("userFirstName", getResult1.getName());
        assertEquals("userFirstName", getResult1.getLabel());
        assertEquals(123L, getResult1.getId());
        BaseDbColumn getResult2 = actualListBaseDbColumns.get(3593);
        assertEquals("email", getResult2.getName());
        assertEquals("email", getResult2.getLabel());
        assertEquals(123L, getResult2.getId());
        BaseDbColumn getResult3 = actualListBaseDbColumns.get(3592);
        assertEquals("mobileNumbers", getResult3.getName());
        assertEquals("mobileNumbers", getResult3.getLabel());
        assertEquals(123L, getResult3.getId());
        BaseDbColumn getResult4 = actualListBaseDbColumns.get(3596);
        assertEquals("userLastName", getResult4.getName());
        assertEquals("userLastName", getResult4.getLabel());
        assertEquals(123L, getResult4.getId());
        assertEquals("java.util.List<java.lang.String>", getResult3.getType());
        assertEquals("java.lang.String", getResult4.getType());
        assertEquals("java.lang.String", getResult.getType());
        assertEquals("java.lang.String", getResult1.getType());
        assertEquals("java.lang.String", getResult2.getType());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.baseDbColumnRepository, atLeast(1)).findByName((String) any());
        verify(this.baseDbColumnRepository, atLeast(1)).save((BaseDbColumn) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getListBaseDbColumns()}
     */
    @Test
    void testGetListBaseDbColumns5() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());

        ArrayList<CompanyDto> companyDtoList = new ArrayList<>();
        companyDtoList.add(new CompanyDto(123L, "42", "investments", "investments", 1, true));
        when(this.companyUtility.loadCompanies()).thenReturn(companyDtoList);

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
        List<BaseDbColumn> actualListBaseDbColumns = this.baseDbColumnService.getListBaseDbColumns();
        BaseDbColumn getResult = actualListBaseDbColumns.get(3638);
        assertEquals("yearOfEstablishment", getResult.getName());
        assertEquals("yearOfEstablishment", getResult.getLabel());
        assertEquals(123L, getResult.getId());
        BaseDbColumn getResult1 = actualListBaseDbColumns.get(3637);
        assertEquals("domicile", getResult1.getName());
        assertEquals("domicile", getResult1.getLabel());
        assertEquals(123L, getResult1.getId());
        BaseDbColumn getResult2 = actualListBaseDbColumns.get(3636);
        assertEquals("companyName", getResult2.getName());
        assertEquals("companyName", getResult2.getLabel());
        assertEquals(123L, getResult2.getId());
        BaseDbColumn getResult3 = actualListBaseDbColumns.get(3635);
        assertEquals("companyId", getResult3.getName());
        assertEquals("companyId", getResult3.getLabel());
        assertEquals(123L, getResult3.getId());
        BaseDbColumn getResult4 = actualListBaseDbColumns.get(3639);
        assertEquals("isActive", getResult4.getName());
        assertEquals("isActive", getResult4.getLabel());
        assertEquals(123L, getResult4.getId());
        assertEquals("java.lang.String", getResult3.getType());
        assertEquals("boolean", getResult4.getType());
        assertEquals("int", getResult.getType());
        assertEquals("java.lang.String", getResult1.getType());
        assertEquals("java.lang.String", getResult2.getType());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.baseDbColumnRepository, atLeast(1)).findByName((String) any());
        verify(this.baseDbColumnRepository, atLeast(1)).save((BaseDbColumn) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getListBaseDbColumns()}
     */
    @Test
    void testGetListBaseDbColumns6() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        BaseDbColumn baseDbColumn = mock(BaseDbColumn.class);
        when(baseDbColumn.getId()).thenReturn(123L);
        doNothing().when(baseDbColumn).setGroupedValues((List<String>) any());
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
        List<BaseDbColumn> actualListBaseDbColumns = this.baseDbColumnService.getListBaseDbColumns();
        BaseDbColumn getResult = actualListBaseDbColumns.get(3671);
        assertEquals("userId", getResult.getName());
        assertEquals("userId", getResult.getLabel());
        assertEquals(123L, getResult.getId());
        BaseDbColumn getResult1 = actualListBaseDbColumns.get(3670);
        assertEquals("userFirstName", getResult1.getName());
        assertEquals("userFirstName", getResult1.getLabel());
        assertEquals(123L, getResult1.getId());
        BaseDbColumn getResult2 = actualListBaseDbColumns.get(3669);
        assertEquals("email", getResult2.getName());
        assertEquals("email", getResult2.getLabel());
        assertEquals(123L, getResult2.getId());
        BaseDbColumn getResult3 = actualListBaseDbColumns.get(3668);
        assertEquals("mobileNumbers", getResult3.getName());
        assertEquals("mobileNumbers", getResult3.getLabel());
        assertEquals(123L, getResult3.getId());
        BaseDbColumn getResult4 = actualListBaseDbColumns.get(3672);
        assertEquals("userLastName", getResult4.getName());
        assertEquals("userLastName", getResult4.getLabel());
        assertEquals(123L, getResult4.getId());
        assertEquals("java.util.List<java.lang.String>", getResult3.getType());
        assertEquals("java.lang.String", getResult4.getType());
        assertEquals("java.lang.String", getResult.getType());
        assertEquals("java.lang.String", getResult1.getType());
        assertEquals("java.lang.String", getResult2.getType());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.baseDbColumnRepository, atLeast(1)).findByName((String) any());
        verify(this.baseDbColumnRepository, atLeast(1)).save((BaseDbColumn) any());
        verify(baseDbColumn, atLeast(1)).getId();
        verify(baseDbColumn).setGroupedValues((List<String>) any());
        verify(baseDbColumn).setId(anyLong());
        verify(baseDbColumn).setLabel((String) any());
        verify(baseDbColumn).setName((String) any());
        verify(baseDbColumn).setType((String) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }

    /**
     * Method under test: {@link BaseDbColumnService#getListBaseDbColumns()}
     */
    @Test
    void testGetListBaseDbColumns7() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        ArrayList<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto());
        when(this.userUtility.loadUsers()).thenReturn(userDtoList);
        when(this.portfolioUtility.loadPortfolios()).thenReturn(new ArrayList<>());
        when(this.companyUtility.loadCompanies()).thenReturn(new ArrayList<>());
        BaseDbColumn baseDbColumn = mock(BaseDbColumn.class);
        when(baseDbColumn.getId()).thenReturn(123L);
        doNothing().when(baseDbColumn).setGroupedValues((List<String>) any());
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

        ArrayList<BankAccountDto> bankAccountDtoList = new ArrayList<>();
        bankAccountDtoList.add(new BankAccountDto());
        when(this.bankAccountUtility.loadBankAccounts()).thenReturn(bankAccountDtoList);
        List<BaseDbColumn> actualListBaseDbColumns = this.baseDbColumnService.getListBaseDbColumns();
        BaseDbColumn getResult = actualListBaseDbColumns.get(3698);
        assertEquals("userId", getResult.getName());
        assertEquals("userId", getResult.getLabel());
        assertEquals(123L, getResult.getId());
        BaseDbColumn getResult1 = actualListBaseDbColumns.get(3697);
        assertEquals("userFirstName", getResult1.getName());
        assertEquals("userFirstName", getResult1.getLabel());
        assertEquals(123L, getResult1.getId());
        BaseDbColumn getResult2 = actualListBaseDbColumns.get(3696);
        assertEquals("email", getResult2.getName());
        assertEquals("email", getResult2.getLabel());
        assertEquals(123L, getResult2.getId());
        BaseDbColumn getResult3 = actualListBaseDbColumns.get(3695);
        assertEquals("mobileNumbers", getResult3.getName());
        assertEquals("mobileNumbers", getResult3.getLabel());
        assertEquals(123L, getResult3.getId());
        BaseDbColumn getResult4 = actualListBaseDbColumns.get(3699);
        assertEquals("userLastName", getResult4.getName());
        assertEquals("userLastName", getResult4.getLabel());
        assertEquals(123L, getResult4.getId());
        assertEquals("java.util.List<java.lang.String>", getResult3.getType());
        assertEquals("java.lang.String", getResult4.getType());
        assertEquals("java.lang.String", getResult.getType());
        assertEquals("java.lang.String", getResult1.getType());
        assertEquals("java.lang.String", getResult2.getType());
        verify(this.userUtility).loadUsers();
        verify(this.portfolioUtility).loadPortfolios();
        verify(this.companyUtility).loadCompanies();
        verify(this.baseDbColumnRepository, atLeast(1)).findByName((String) any());
        verify(this.baseDbColumnRepository, atLeast(1)).save((BaseDbColumn) any());
        verify(baseDbColumn, atLeast(1)).getId();
        verify(baseDbColumn).setGroupedValues((List<String>) any());
        verify(baseDbColumn).setId(anyLong());
        verify(baseDbColumn).setLabel((String) any());
        verify(baseDbColumn).setName((String) any());
        verify(baseDbColumn).setType((String) any());
        verify(this.bankAccountUtility).loadBankAccounts();
    }
}

