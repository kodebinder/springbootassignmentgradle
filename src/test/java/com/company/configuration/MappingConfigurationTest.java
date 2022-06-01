package com.company.configuration;

import com.company.dto.AddressDto;
import com.company.dto.BankAccountDto;
import com.company.dto.BankOperationDto;
import com.company.dto.CompanyDto;
import com.company.dto.PortfolioDto;
import com.company.dto.PositionDto;
import com.company.dto.UserDto;
import com.company.entity.Address;
import com.company.entity.BankAccount;
import com.company.entity.BankOperation;
import com.company.entity.Company;
import com.company.entity.Portfolio;
import com.company.entity.Position;
import com.company.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {MappingConfiguration.class})
@ExtendWith(SpringExtension.class)
class MappingConfigurationTest {
    @Autowired
    private MappingConfiguration mappingConfiguration;

    /**
     * Method under test: {@link MappingConfiguration#mapAddressDtoToAddressEntity(AddressDto)}
     */
    @Test
    void testMapAddressDtoToAddressEntity() {
        Address actualMapAddressDtoToAddressEntityResult = this.mappingConfiguration.mapAddressDtoToAddressEntity(
                new AddressDto(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654"));
        assertEquals("42 Main St", actualMapAddressDtoToAddressEntityResult.getAddressId());
        assertEquals("21654", actualMapAddressDtoToAddressEntityResult.getZip());
        assertEquals("Street", actualMapAddressDtoToAddressEntityResult.getStreet());
        assertEquals("MD", actualMapAddressDtoToAddressEntityResult.getState());
        assertEquals(123L, actualMapAddressDtoToAddressEntityResult.getId());
        assertEquals("GB", actualMapAddressDtoToAddressEntityResult.getCountry());
        assertEquals("Oxford", actualMapAddressDtoToAddressEntityResult.getCity());
        assertEquals("42 Main St", actualMapAddressDtoToAddressEntityResult.getAddressType());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapAddressDtoToAddressEntity(AddressDto)}
     */
    @Test
    void testMapAddressDtoToAddressEntity2() {
        Address actualMapAddressDtoToAddressEntityResult = this.mappingConfiguration.mapAddressDtoToAddressEntity(
                new AddressDto(1L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654"));
        assertEquals("42 Main St", actualMapAddressDtoToAddressEntityResult.getAddressId());
        assertEquals("21654", actualMapAddressDtoToAddressEntityResult.getZip());
        assertEquals("Street", actualMapAddressDtoToAddressEntityResult.getStreet());
        assertEquals("MD", actualMapAddressDtoToAddressEntityResult.getState());
        assertEquals(1L, actualMapAddressDtoToAddressEntityResult.getId());
        assertEquals("GB", actualMapAddressDtoToAddressEntityResult.getCountry());
        assertEquals("Oxford", actualMapAddressDtoToAddressEntityResult.getCity());
        assertEquals("42 Main St", actualMapAddressDtoToAddressEntityResult.getAddressType());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapAddressDtoToAddressEntity(AddressDto)}
     */
    @Test
    void testMapAddressDtoToAddressEntity3() {
        Address actualMapAddressDtoToAddressEntityResult = this.mappingConfiguration
                .mapAddressDtoToAddressEntity(new AddressDto());
        assertNull(actualMapAddressDtoToAddressEntityResult.getAddressId());
        assertNull(actualMapAddressDtoToAddressEntityResult.getZip());
        assertNull(actualMapAddressDtoToAddressEntityResult.getStreet());
        assertNull(actualMapAddressDtoToAddressEntityResult.getState());
        assertEquals(0L, actualMapAddressDtoToAddressEntityResult.getId());
        assertNull(actualMapAddressDtoToAddressEntityResult.getCountry());
        assertNull(actualMapAddressDtoToAddressEntityResult.getCity());
        assertNull(actualMapAddressDtoToAddressEntityResult.getAddressType());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapAddressDtoToAddressEntity(AddressDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapAddressDtoToAddressEntity4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapAddressDtoToAddressEntity(MappingConfiguration.java:12)
        //   In order to prevent mapAddressDtoToAddressEntity(AddressDto)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapAddressDtoToAddressEntity(AddressDto).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapAddressDtoToAddressEntity(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapAddressDtoToAddressEntity(AddressDto)}
     */
    @Test
    void testMapAddressDtoToAddressEntity5() {
        AddressDto addressDto = mock(AddressDto.class);
        when(addressDto.getAddressId()).thenReturn("42 Main St");
        when(addressDto.getAddressType()).thenReturn("42 Main St");
        when(addressDto.getCity()).thenReturn("Oxford");
        when(addressDto.getCountry()).thenReturn("GB");
        when(addressDto.getState()).thenReturn("MD");
        when(addressDto.getStreet()).thenReturn("Street");
        when(addressDto.getZip()).thenReturn("21654");
        when(addressDto.getId()).thenReturn(123L);
        Address actualMapAddressDtoToAddressEntityResult = this.mappingConfiguration
                .mapAddressDtoToAddressEntity(addressDto);
        assertEquals("42 Main St", actualMapAddressDtoToAddressEntityResult.getAddressId());
        assertEquals("21654", actualMapAddressDtoToAddressEntityResult.getZip());
        assertEquals("Street", actualMapAddressDtoToAddressEntityResult.getStreet());
        assertEquals("MD", actualMapAddressDtoToAddressEntityResult.getState());
        assertEquals(123L, actualMapAddressDtoToAddressEntityResult.getId());
        assertEquals("GB", actualMapAddressDtoToAddressEntityResult.getCountry());
        assertEquals("Oxford", actualMapAddressDtoToAddressEntityResult.getCity());
        assertEquals("42 Main St", actualMapAddressDtoToAddressEntityResult.getAddressType());
        verify(addressDto).getAddressId();
        verify(addressDto).getAddressType();
        verify(addressDto).getCity();
        verify(addressDto).getCountry();
        verify(addressDto).getState();
        verify(addressDto).getStreet();
        verify(addressDto).getZip();
        verify(addressDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapAddressEntityToAddressDto(Address)}
     */
    @Test
    void testMapAddressEntityToAddressDto() {
        AddressDto actualMapAddressEntityToAddressDtoResult = this.mappingConfiguration.mapAddressEntityToAddressDto(
                new Address(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654"));
        assertEquals("42 Main St", actualMapAddressEntityToAddressDtoResult.getAddressId());
        assertEquals("21654", actualMapAddressEntityToAddressDtoResult.getZip());
        assertEquals("Street", actualMapAddressEntityToAddressDtoResult.getStreet());
        assertEquals("MD", actualMapAddressEntityToAddressDtoResult.getState());
        assertEquals(123L, actualMapAddressEntityToAddressDtoResult.getId());
        assertEquals("GB", actualMapAddressEntityToAddressDtoResult.getCountry());
        assertEquals("Oxford", actualMapAddressEntityToAddressDtoResult.getCity());
        assertEquals("42 Main St", actualMapAddressEntityToAddressDtoResult.getAddressType());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapAddressEntityToAddressDto(Address)}
     */
    @Test
    void testMapAddressEntityToAddressDto2() {
        AddressDto actualMapAddressEntityToAddressDtoResult = this.mappingConfiguration
                .mapAddressEntityToAddressDto(new Address());
        assertNull(actualMapAddressEntityToAddressDtoResult.getAddressId());
        assertNull(actualMapAddressEntityToAddressDtoResult.getZip());
        assertNull(actualMapAddressEntityToAddressDtoResult.getStreet());
        assertNull(actualMapAddressEntityToAddressDtoResult.getState());
        assertEquals(0L, actualMapAddressEntityToAddressDtoResult.getId());
        assertNull(actualMapAddressEntityToAddressDtoResult.getCountry());
        assertNull(actualMapAddressEntityToAddressDtoResult.getCity());
        assertNull(actualMapAddressEntityToAddressDtoResult.getAddressType());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapAddressEntityToAddressDto(Address)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapAddressEntityToAddressDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapAddressEntityToAddressDto(MappingConfiguration.java:16)
        //   In order to prevent mapAddressEntityToAddressDto(Address)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapAddressEntityToAddressDto(Address).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapAddressEntityToAddressDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapAddressEntityToAddressDto(Address)}
     */
    @Test
    void testMapAddressEntityToAddressDto4() {
        Address address = mock(Address.class);
        when(address.getAddressId()).thenReturn("42 Main St");
        when(address.getAddressType()).thenReturn("42 Main St");
        when(address.getCity()).thenReturn("Oxford");
        when(address.getCountry()).thenReturn("GB");
        when(address.getState()).thenReturn("MD");
        when(address.getStreet()).thenReturn("Street");
        when(address.getZip()).thenReturn("21654");
        when(address.getId()).thenReturn(123L);
        AddressDto actualMapAddressEntityToAddressDtoResult = this.mappingConfiguration
                .mapAddressEntityToAddressDto(address);
        assertEquals("42 Main St", actualMapAddressEntityToAddressDtoResult.getAddressId());
        assertEquals("21654", actualMapAddressEntityToAddressDtoResult.getZip());
        assertEquals("Street", actualMapAddressEntityToAddressDtoResult.getStreet());
        assertEquals("MD", actualMapAddressEntityToAddressDtoResult.getState());
        assertEquals(123L, actualMapAddressEntityToAddressDtoResult.getId());
        assertEquals("GB", actualMapAddressEntityToAddressDtoResult.getCountry());
        assertEquals("Oxford", actualMapAddressEntityToAddressDtoResult.getCity());
        assertEquals("42 Main St", actualMapAddressEntityToAddressDtoResult.getAddressType());
        verify(address).getAddressId();
        verify(address).getAddressType();
        verify(address).getCity();
        verify(address).getCountry();
        verify(address).getState();
        verify(address).getStreet();
        verify(address).getZip();
        verify(address).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapAddressEntityToAddressDto(Address)}
     */
    @Test
    void testMapAddressEntityToAddressDto5() {
        Address address = mock(Address.class);
        when(address.getAddressId()).thenReturn("42 Main St");
        when(address.getAddressType()).thenReturn("42 Main St");
        when(address.getCity()).thenReturn("foo");
        when(address.getCountry()).thenReturn("GB");
        when(address.getState()).thenReturn("MD");
        when(address.getStreet()).thenReturn("Street");
        when(address.getZip()).thenReturn("21654");
        when(address.getId()).thenReturn(123L);
        AddressDto actualMapAddressEntityToAddressDtoResult = this.mappingConfiguration
                .mapAddressEntityToAddressDto(address);
        assertEquals("42 Main St", actualMapAddressEntityToAddressDtoResult.getAddressId());
        assertEquals("21654", actualMapAddressEntityToAddressDtoResult.getZip());
        assertEquals("Street", actualMapAddressEntityToAddressDtoResult.getStreet());
        assertEquals("MD", actualMapAddressEntityToAddressDtoResult.getState());
        assertEquals(123L, actualMapAddressEntityToAddressDtoResult.getId());
        assertEquals("GB", actualMapAddressEntityToAddressDtoResult.getCountry());
        assertEquals("foo", actualMapAddressEntityToAddressDtoResult.getCity());
        assertEquals("42 Main St", actualMapAddressEntityToAddressDtoResult.getAddressType());
        verify(address).getAddressId();
        verify(address).getAddressType();
        verify(address).getCity();
        verify(address).getCountry();
        verify(address).getState();
        verify(address).getStreet();
        verify(address).getZip();
        verify(address).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountDtoToBankAccountEntity(BankAccountDto)}
     */
    @Test
    void testMapBankAccountDtoToBankAccountEntity() {
        BankAccount actualMapBankAccountDtoToBankAccountEntityResult = this.mappingConfiguration
                .mapBankAccountDtoToBankAccountEntity(new BankAccountDto());
        assertNull(actualMapBankAccountDtoToBankAccountEntityResult.getBalance());
        assertFalse(actualMapBankAccountDtoToBankAccountEntityResult.isActive());
        assertEquals(0L, actualMapBankAccountDtoToBankAccountEntityResult.getId());
        assertNull(actualMapBankAccountDtoToBankAccountEntityResult.getBankAccountNumber());
        assertNull(actualMapBankAccountDtoToBankAccountEntityResult.getBankAccountId());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountDtoToBankAccountEntity(BankAccountDto)}
     */
    @Test
    void testMapBankAccountDtoToBankAccountEntity2() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        BankAccount actualMapBankAccountDtoToBankAccountEntityResult = this.mappingConfiguration
                .mapBankAccountDtoToBankAccountEntity(
                        new BankAccountDto(123L, "42", "42", true, valueOfResult, new BankOperationDto(123L, "42", true, true)));
        BigDecimal balance = actualMapBankAccountDtoToBankAccountEntityResult.getBalance();
        assertSame(valueOfResult, balance);
        assertTrue(actualMapBankAccountDtoToBankAccountEntityResult.isActive());
        assertEquals("42", actualMapBankAccountDtoToBankAccountEntityResult.getBankAccountId());
        assertEquals(123L, actualMapBankAccountDtoToBankAccountEntityResult.getId());
        assertEquals("42", actualMapBankAccountDtoToBankAccountEntityResult.getBankAccountNumber());
        BankOperation bankOperation = actualMapBankAccountDtoToBankAccountEntityResult.getBankOperation();
        assertTrue(bankOperation.isCreditEnabled());
        assertEquals(123L, bankOperation.getId());
        assertEquals("42", bankOperation.getBankAccountId());
        assertEquals("42", balance.toString());
        assertTrue(bankOperation.isDebitEnabled());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountDtoToBankAccountEntity(BankAccountDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapBankAccountDtoToBankAccountEntity3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapBankAccountDtoToBankAccountEntity(MappingConfiguration.java:20)
        //   In order to prevent mapBankAccountDtoToBankAccountEntity(BankAccountDto)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapBankAccountDtoToBankAccountEntity(BankAccountDto).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapBankAccountDtoToBankAccountEntity(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountDtoToBankAccountEntity(BankAccountDto)}
     */
    @Test
    void testMapBankAccountDtoToBankAccountEntity4() {
        BankAccountDto bankAccountDto = mock(BankAccountDto.class);
        when(bankAccountDto.isActive()).thenReturn(true);
        when(bankAccountDto.getBankOperation()).thenReturn(new BankOperationDto(123L, "42", true, true));
        when(bankAccountDto.getBankAccountId()).thenReturn("42");
        when(bankAccountDto.getBankAccountNumber()).thenReturn("42");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(bankAccountDto.getBalance()).thenReturn(valueOfResult);
        when(bankAccountDto.getId()).thenReturn(123L);
        BankAccount actualMapBankAccountDtoToBankAccountEntityResult = this.mappingConfiguration
                .mapBankAccountDtoToBankAccountEntity(bankAccountDto);
        BigDecimal balance = actualMapBankAccountDtoToBankAccountEntityResult.getBalance();
        assertSame(valueOfResult, balance);
        assertTrue(actualMapBankAccountDtoToBankAccountEntityResult.isActive());
        assertEquals("42", actualMapBankAccountDtoToBankAccountEntityResult.getBankAccountId());
        assertEquals(123L, actualMapBankAccountDtoToBankAccountEntityResult.getId());
        assertEquals("42", actualMapBankAccountDtoToBankAccountEntityResult.getBankAccountNumber());
        BankOperation bankOperation = actualMapBankAccountDtoToBankAccountEntityResult.getBankOperation();
        assertTrue(bankOperation.isCreditEnabled());
        assertEquals(123L, bankOperation.getId());
        assertEquals("42", bankOperation.getBankAccountId());
        assertEquals("42", balance.toString());
        assertTrue(bankOperation.isDebitEnabled());
        verify(bankAccountDto).isActive();
        verify(bankAccountDto, atLeast(1)).getBankOperation();
        verify(bankAccountDto).getBankAccountId();
        verify(bankAccountDto).getBankAccountNumber();
        verify(bankAccountDto).getBalance();
        verify(bankAccountDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountDtoToBankAccountEntity(BankAccountDto)}
     */
    @Test
    void testMapBankAccountDtoToBankAccountEntity5() {
        BankAccountDto bankAccountDto = mock(BankAccountDto.class);
        when(bankAccountDto.isActive()).thenReturn(false);
        when(bankAccountDto.getBankOperation()).thenReturn(new BankOperationDto(123L, "", true, true));
        when(bankAccountDto.getBankAccountId()).thenReturn("42");
        when(bankAccountDto.getBankAccountNumber()).thenReturn("42");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(bankAccountDto.getBalance()).thenReturn(valueOfResult);
        when(bankAccountDto.getId()).thenReturn(123L);
        BankAccount actualMapBankAccountDtoToBankAccountEntityResult = this.mappingConfiguration
                .mapBankAccountDtoToBankAccountEntity(bankAccountDto);
        BigDecimal balance = actualMapBankAccountDtoToBankAccountEntityResult.getBalance();
        assertSame(valueOfResult, balance);
        assertFalse(actualMapBankAccountDtoToBankAccountEntityResult.isActive());
        assertEquals("42", actualMapBankAccountDtoToBankAccountEntityResult.getBankAccountId());
        assertEquals(123L, actualMapBankAccountDtoToBankAccountEntityResult.getId());
        assertEquals("42", actualMapBankAccountDtoToBankAccountEntityResult.getBankAccountNumber());
        BankOperation bankOperation = actualMapBankAccountDtoToBankAccountEntityResult.getBankOperation();
        assertTrue(bankOperation.isCreditEnabled());
        assertEquals(123L, bankOperation.getId());
        assertEquals("", bankOperation.getBankAccountId());
        assertEquals("42", balance.toString());
        assertTrue(bankOperation.isDebitEnabled());
        verify(bankAccountDto).isActive();
        verify(bankAccountDto, atLeast(1)).getBankOperation();
        verify(bankAccountDto).getBankAccountId();
        verify(bankAccountDto).getBankAccountNumber();
        verify(bankAccountDto).getBalance();
        verify(bankAccountDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountEntityToBankAccountDto(BankAccount)}
     */
    @Test
    void testMapBankAccountEntityToBankAccountDto() {
        BankAccountDto actualMapBankAccountEntityToBankAccountDtoResult = this.mappingConfiguration
                .mapBankAccountEntityToBankAccountDto(new BankAccount());
        assertNull(actualMapBankAccountEntityToBankAccountDtoResult.getBalance());
        assertFalse(actualMapBankAccountEntityToBankAccountDtoResult.isActive());
        assertEquals(0L, actualMapBankAccountEntityToBankAccountDtoResult.getId());
        assertNull(actualMapBankAccountEntityToBankAccountDtoResult.getBankAccountNumber());
        assertNull(actualMapBankAccountEntityToBankAccountDtoResult.getBankAccountId());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountEntityToBankAccountDto(BankAccount)}
     */
    @Test
    void testMapBankAccountEntityToBankAccountDto2() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        BankAccountDto actualMapBankAccountEntityToBankAccountDtoResult = this.mappingConfiguration
                .mapBankAccountEntityToBankAccountDto(
                        new BankAccount(123L, "42", "42", true, valueOfResult, new BankOperation(123L, "42", true, true)));
        BigDecimal balance = actualMapBankAccountEntityToBankAccountDtoResult.getBalance();
        assertSame(valueOfResult, balance);
        assertTrue(actualMapBankAccountEntityToBankAccountDtoResult.isActive());
        assertEquals("42", actualMapBankAccountEntityToBankAccountDtoResult.getBankAccountId());
        assertEquals(123L, actualMapBankAccountEntityToBankAccountDtoResult.getId());
        assertEquals("42", actualMapBankAccountEntityToBankAccountDtoResult.getBankAccountNumber());
        BankOperationDto bankOperation = actualMapBankAccountEntityToBankAccountDtoResult.getBankOperation();
        assertTrue(bankOperation.isCreditEnabled());
        assertEquals(123L, bankOperation.getId());
        assertEquals("42", bankOperation.getBankAccountId());
        assertEquals("42", balance.toString());
        assertTrue(bankOperation.isDebitEnabled());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountEntityToBankAccountDto(BankAccount)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapBankAccountEntityToBankAccountDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapBankAccountEntityToBankAccountDto(MappingConfiguration.java:24)
        //   In order to prevent mapBankAccountEntityToBankAccountDto(BankAccount)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapBankAccountEntityToBankAccountDto(BankAccount).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapBankAccountEntityToBankAccountDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountEntityToBankAccountDto(BankAccount)}
     */
    @Test
    void testMapBankAccountEntityToBankAccountDto4() {
        BankAccount bankAccount = mock(BankAccount.class);
        when(bankAccount.isActive()).thenReturn(true);
        when(bankAccount.getBankOperation()).thenReturn(new BankOperation(123L, "42", true, true));
        when(bankAccount.getBankAccountId()).thenReturn("42");
        when(bankAccount.getBankAccountNumber()).thenReturn("42");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(bankAccount.getBalance()).thenReturn(valueOfResult);
        when(bankAccount.getId()).thenReturn(123L);
        BankAccountDto actualMapBankAccountEntityToBankAccountDtoResult = this.mappingConfiguration
                .mapBankAccountEntityToBankAccountDto(bankAccount);
        BigDecimal balance = actualMapBankAccountEntityToBankAccountDtoResult.getBalance();
        assertSame(valueOfResult, balance);
        assertTrue(actualMapBankAccountEntityToBankAccountDtoResult.isActive());
        assertEquals("42", actualMapBankAccountEntityToBankAccountDtoResult.getBankAccountId());
        assertEquals(123L, actualMapBankAccountEntityToBankAccountDtoResult.getId());
        assertEquals("42", actualMapBankAccountEntityToBankAccountDtoResult.getBankAccountNumber());
        BankOperationDto bankOperation = actualMapBankAccountEntityToBankAccountDtoResult.getBankOperation();
        assertTrue(bankOperation.isCreditEnabled());
        assertEquals(123L, bankOperation.getId());
        assertEquals("42", bankOperation.getBankAccountId());
        assertEquals("42", balance.toString());
        assertTrue(bankOperation.isDebitEnabled());
        verify(bankAccount).isActive();
        verify(bankAccount, atLeast(1)).getBankOperation();
        verify(bankAccount).getBankAccountId();
        verify(bankAccount).getBankAccountNumber();
        verify(bankAccount).getBalance();
        verify(bankAccount).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankAccountEntityToBankAccountDto(BankAccount)}
     */
    @Test
    void testMapBankAccountEntityToBankAccountDto5() {
        BankAccount bankAccount = mock(BankAccount.class);
        when(bankAccount.isActive()).thenReturn(false);
        when(bankAccount.getBankOperation()).thenReturn(new BankOperation(123L, "42", true, true));
        when(bankAccount.getBankAccountId()).thenReturn("42");
        when(bankAccount.getBankAccountNumber()).thenReturn("42");
        BigDecimal valueOfResult = BigDecimal.valueOf(1L);
        when(bankAccount.getBalance()).thenReturn(valueOfResult);
        when(bankAccount.getId()).thenReturn(123L);
        BankAccountDto actualMapBankAccountEntityToBankAccountDtoResult = this.mappingConfiguration
                .mapBankAccountEntityToBankAccountDto(bankAccount);
        BigDecimal expectedBalance = valueOfResult.ONE;
        BigDecimal balance = actualMapBankAccountEntityToBankAccountDtoResult.getBalance();
        assertSame(expectedBalance, balance);
        assertFalse(actualMapBankAccountEntityToBankAccountDtoResult.isActive());
        assertEquals("42", actualMapBankAccountEntityToBankAccountDtoResult.getBankAccountId());
        assertEquals(123L, actualMapBankAccountEntityToBankAccountDtoResult.getId());
        assertEquals("42", actualMapBankAccountEntityToBankAccountDtoResult.getBankAccountNumber());
        BankOperationDto bankOperation = actualMapBankAccountEntityToBankAccountDtoResult.getBankOperation();
        assertTrue(bankOperation.isCreditEnabled());
        assertEquals(123L, bankOperation.getId());
        assertEquals("42", bankOperation.getBankAccountId());
        assertEquals("1", balance.toString());
        assertTrue(bankOperation.isDebitEnabled());
        verify(bankAccount).isActive();
        verify(bankAccount, atLeast(1)).getBankOperation();
        verify(bankAccount).getBankAccountId();
        verify(bankAccount).getBankAccountNumber();
        verify(bankAccount).getBalance();
        verify(bankAccount).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankOperationDtoToBankOperationEntity(BankOperationDto)}
     */
    @Test
    void testMapBankOperationDtoToBankOperationEntity() {
        BankOperation actualMapBankOperationDtoToBankOperationEntityResult = this.mappingConfiguration
                .mapBankOperationDtoToBankOperationEntity(new BankOperationDto(123L, "42", true, true));
        assertEquals("42", actualMapBankOperationDtoToBankOperationEntityResult.getBankAccountId());
        assertTrue(actualMapBankOperationDtoToBankOperationEntityResult.isDebitEnabled());
        assertTrue(actualMapBankOperationDtoToBankOperationEntityResult.isCreditEnabled());
        assertEquals(123L, actualMapBankOperationDtoToBankOperationEntityResult.getId());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankOperationDtoToBankOperationEntity(BankOperationDto)}
     */
    @Test
    void testMapBankOperationDtoToBankOperationEntity2() {
        BankOperation actualMapBankOperationDtoToBankOperationEntityResult = this.mappingConfiguration
                .mapBankOperationDtoToBankOperationEntity(new BankOperationDto());
        assertNull(actualMapBankOperationDtoToBankOperationEntityResult.getBankAccountId());
        assertFalse(actualMapBankOperationDtoToBankOperationEntityResult.isDebitEnabled());
        assertFalse(actualMapBankOperationDtoToBankOperationEntityResult.isCreditEnabled());
        assertEquals(0L, actualMapBankOperationDtoToBankOperationEntityResult.getId());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankOperationDtoToBankOperationEntity(BankOperationDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapBankOperationDtoToBankOperationEntity3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapBankOperationDtoToBankOperationEntity(MappingConfiguration.java:28)
        //   In order to prevent mapBankOperationDtoToBankOperationEntity(BankOperationDto)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapBankOperationDtoToBankOperationEntity(BankOperationDto).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapBankOperationDtoToBankOperationEntity(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankOperationDtoToBankOperationEntity(BankOperationDto)}
     */
    @Test
    void testMapBankOperationDtoToBankOperationEntity4() {
        BankOperationDto bankOperationDto = mock(BankOperationDto.class);
        when(bankOperationDto.isCreditEnabled()).thenReturn(true);
        when(bankOperationDto.isDebitEnabled()).thenReturn(true);
        when(bankOperationDto.getBankAccountId()).thenReturn("42");
        when(bankOperationDto.getId()).thenReturn(123L);
        BankOperation actualMapBankOperationDtoToBankOperationEntityResult = this.mappingConfiguration
                .mapBankOperationDtoToBankOperationEntity(bankOperationDto);
        assertEquals("42", actualMapBankOperationDtoToBankOperationEntityResult.getBankAccountId());
        assertTrue(actualMapBankOperationDtoToBankOperationEntityResult.isDebitEnabled());
        assertTrue(actualMapBankOperationDtoToBankOperationEntityResult.isCreditEnabled());
        assertEquals(123L, actualMapBankOperationDtoToBankOperationEntityResult.getId());
        verify(bankOperationDto).isCreditEnabled();
        verify(bankOperationDto).isDebitEnabled();
        verify(bankOperationDto).getBankAccountId();
        verify(bankOperationDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankOperationEntityToBankOperationDto(BankOperation)}
     */
    @Test
    void testMapBankOperationEntityToBankOperationDto() {
        BankOperationDto actualMapBankOperationEntityToBankOperationDtoResult = this.mappingConfiguration
                .mapBankOperationEntityToBankOperationDto(new BankOperation(123L, "42", true, true));
        assertEquals("42", actualMapBankOperationEntityToBankOperationDtoResult.getBankAccountId());
        assertTrue(actualMapBankOperationEntityToBankOperationDtoResult.isDebitEnabled());
        assertTrue(actualMapBankOperationEntityToBankOperationDtoResult.isCreditEnabled());
        assertEquals(123L, actualMapBankOperationEntityToBankOperationDtoResult.getId());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankOperationEntityToBankOperationDto(BankOperation)}
     */
    @Test
    void testMapBankOperationEntityToBankOperationDto2() {
        BankOperationDto actualMapBankOperationEntityToBankOperationDtoResult = this.mappingConfiguration
                .mapBankOperationEntityToBankOperationDto(new BankOperation());
        assertNull(actualMapBankOperationEntityToBankOperationDtoResult.getBankAccountId());
        assertFalse(actualMapBankOperationEntityToBankOperationDtoResult.isDebitEnabled());
        assertFalse(actualMapBankOperationEntityToBankOperationDtoResult.isCreditEnabled());
        assertEquals(0L, actualMapBankOperationEntityToBankOperationDtoResult.getId());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankOperationEntityToBankOperationDto(BankOperation)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapBankOperationEntityToBankOperationDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapBankOperationEntityToBankOperationDto(MappingConfiguration.java:32)
        //   In order to prevent mapBankOperationEntityToBankOperationDto(BankOperation)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapBankOperationEntityToBankOperationDto(BankOperation).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapBankOperationEntityToBankOperationDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankOperationEntityToBankOperationDto(BankOperation)}
     */
    @Test
    void testMapBankOperationEntityToBankOperationDto4() {
        BankOperation bankOperation = mock(BankOperation.class);
        when(bankOperation.isCreditEnabled()).thenReturn(true);
        when(bankOperation.isDebitEnabled()).thenReturn(true);
        when(bankOperation.getBankAccountId()).thenReturn("42");
        when(bankOperation.getId()).thenReturn(123L);
        BankOperationDto actualMapBankOperationEntityToBankOperationDtoResult = this.mappingConfiguration
                .mapBankOperationEntityToBankOperationDto(bankOperation);
        assertEquals("42", actualMapBankOperationEntityToBankOperationDtoResult.getBankAccountId());
        assertTrue(actualMapBankOperationEntityToBankOperationDtoResult.isDebitEnabled());
        assertTrue(actualMapBankOperationEntityToBankOperationDtoResult.isCreditEnabled());
        assertEquals(123L, actualMapBankOperationEntityToBankOperationDtoResult.getId());
        verify(bankOperation).isCreditEnabled();
        verify(bankOperation).isDebitEnabled();
        verify(bankOperation).getBankAccountId();
        verify(bankOperation).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapBankOperationEntityToBankOperationDto(BankOperation)}
     */
    @Test
    void testMapBankOperationEntityToBankOperationDto5() {
        BankOperation bankOperation = new BankOperation(123L, "42", true, true);
        bankOperation.setId(123L);
        BankOperationDto actualMapBankOperationEntityToBankOperationDtoResult = this.mappingConfiguration
                .mapBankOperationEntityToBankOperationDto(bankOperation);
        assertEquals("42", actualMapBankOperationEntityToBankOperationDtoResult.getBankAccountId());
        assertTrue(actualMapBankOperationEntityToBankOperationDtoResult.isDebitEnabled());
        assertTrue(actualMapBankOperationEntityToBankOperationDtoResult.isCreditEnabled());
        assertEquals(123L, actualMapBankOperationEntityToBankOperationDtoResult.getId());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyDtoToCompanyEntity(CompanyDto)}
     */
    @Test
    void testMapCompanyDtoToCompanyEntity() {
        Company actualMapCompanyDtoToCompanyEntityResult = this.mappingConfiguration
                .mapCompanyDtoToCompanyEntity(new CompanyDto(123L, "42", "Company Name", "Domicile", 1, true));
        assertEquals("42", actualMapCompanyDtoToCompanyEntityResult.getCompanyId());
        assertTrue(actualMapCompanyDtoToCompanyEntityResult.isActive());
        assertEquals(1, actualMapCompanyDtoToCompanyEntityResult.getYearOfEstablishment());
        assertEquals(123L, actualMapCompanyDtoToCompanyEntityResult.getId());
        assertEquals("Domicile", actualMapCompanyDtoToCompanyEntityResult.getDomicile());
        assertEquals("Company Name", actualMapCompanyDtoToCompanyEntityResult.getCompanyName());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyDtoToCompanyEntity(CompanyDto)}
     */
    @Test
    void testMapCompanyDtoToCompanyEntity2() {
        Company actualMapCompanyDtoToCompanyEntityResult = this.mappingConfiguration
                .mapCompanyDtoToCompanyEntity(new CompanyDto(3L, "42", "Company Name", "Domicile", 1, true));
        assertEquals("42", actualMapCompanyDtoToCompanyEntityResult.getCompanyId());
        assertTrue(actualMapCompanyDtoToCompanyEntityResult.isActive());
        assertEquals(1, actualMapCompanyDtoToCompanyEntityResult.getYearOfEstablishment());
        assertEquals(3L, actualMapCompanyDtoToCompanyEntityResult.getId());
        assertEquals("Domicile", actualMapCompanyDtoToCompanyEntityResult.getDomicile());
        assertEquals("Company Name", actualMapCompanyDtoToCompanyEntityResult.getCompanyName());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyDtoToCompanyEntity(CompanyDto)}
     */
    @Test
    void testMapCompanyDtoToCompanyEntity3() {
        Company actualMapCompanyDtoToCompanyEntityResult = this.mappingConfiguration
                .mapCompanyDtoToCompanyEntity(new CompanyDto(123L, "42", "42", "Domicile", 1, true));
        assertEquals("42", actualMapCompanyDtoToCompanyEntityResult.getCompanyId());
        assertTrue(actualMapCompanyDtoToCompanyEntityResult.isActive());
        assertEquals(1, actualMapCompanyDtoToCompanyEntityResult.getYearOfEstablishment());
        assertEquals(123L, actualMapCompanyDtoToCompanyEntityResult.getId());
        assertEquals("Domicile", actualMapCompanyDtoToCompanyEntityResult.getDomicile());
        assertEquals("42", actualMapCompanyDtoToCompanyEntityResult.getCompanyName());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyDtoToCompanyEntity(CompanyDto)}
     */
    @Test
    void testMapCompanyDtoToCompanyEntity4() {
        Company actualMapCompanyDtoToCompanyEntityResult = this.mappingConfiguration
                .mapCompanyDtoToCompanyEntity(new CompanyDto());
        assertNull(actualMapCompanyDtoToCompanyEntityResult.getCompanyId());
        assertFalse(actualMapCompanyDtoToCompanyEntityResult.isActive());
        assertEquals(0, actualMapCompanyDtoToCompanyEntityResult.getYearOfEstablishment());
        assertEquals(0L, actualMapCompanyDtoToCompanyEntityResult.getId());
        assertNull(actualMapCompanyDtoToCompanyEntityResult.getDomicile());
        assertNull(actualMapCompanyDtoToCompanyEntityResult.getCompanyName());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyDtoToCompanyEntity(CompanyDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapCompanyDtoToCompanyEntity5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapCompanyDtoToCompanyEntity(MappingConfiguration.java:36)
        //   In order to prevent mapCompanyDtoToCompanyEntity(CompanyDto)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapCompanyDtoToCompanyEntity(CompanyDto).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapCompanyDtoToCompanyEntity(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyDtoToCompanyEntity(CompanyDto)}
     */
    @Test
    void testMapCompanyDtoToCompanyEntity6() {
        CompanyDto companyDto = mock(CompanyDto.class);
        when(companyDto.isActive()).thenReturn(true);
        when(companyDto.getYearOfEstablishment()).thenReturn(1);
        when(companyDto.getCompanyId()).thenReturn("42");
        when(companyDto.getCompanyName()).thenReturn("Company Name");
        when(companyDto.getDomicile()).thenReturn("Domicile");
        when(companyDto.getId()).thenReturn(123L);
        Company actualMapCompanyDtoToCompanyEntityResult = this.mappingConfiguration
                .mapCompanyDtoToCompanyEntity(companyDto);
        assertEquals("42", actualMapCompanyDtoToCompanyEntityResult.getCompanyId());
        assertTrue(actualMapCompanyDtoToCompanyEntityResult.isActive());
        assertEquals(1, actualMapCompanyDtoToCompanyEntityResult.getYearOfEstablishment());
        assertEquals(123L, actualMapCompanyDtoToCompanyEntityResult.getId());
        assertEquals("Domicile", actualMapCompanyDtoToCompanyEntityResult.getDomicile());
        assertEquals("Company Name", actualMapCompanyDtoToCompanyEntityResult.getCompanyName());
        verify(companyDto).isActive();
        verify(companyDto).getYearOfEstablishment();
        verify(companyDto).getCompanyId();
        verify(companyDto).getCompanyName();
        verify(companyDto).getDomicile();
        verify(companyDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyDtoToCompanyEntity(CompanyDto)}
     */
    @Test
    void testMapCompanyDtoToCompanyEntity7() {
        CompanyDto companyDto = mock(CompanyDto.class);
        when(companyDto.isActive()).thenReturn(true);
        when(companyDto.getYearOfEstablishment()).thenReturn(Integer.MIN_VALUE);
        when(companyDto.getCompanyId()).thenReturn("42");
        when(companyDto.getCompanyName()).thenReturn("42");
        when(companyDto.getDomicile()).thenReturn("Domicile");
        when(companyDto.getId()).thenReturn(123L);
        Company actualMapCompanyDtoToCompanyEntityResult = this.mappingConfiguration
                .mapCompanyDtoToCompanyEntity(companyDto);
        assertEquals("42", actualMapCompanyDtoToCompanyEntityResult.getCompanyId());
        assertTrue(actualMapCompanyDtoToCompanyEntityResult.isActive());
        assertEquals(Integer.MIN_VALUE, actualMapCompanyDtoToCompanyEntityResult.getYearOfEstablishment());
        assertEquals(123L, actualMapCompanyDtoToCompanyEntityResult.getId());
        assertEquals("Domicile", actualMapCompanyDtoToCompanyEntityResult.getDomicile());
        assertEquals("42", actualMapCompanyDtoToCompanyEntityResult.getCompanyName());
        verify(companyDto).isActive();
        verify(companyDto).getYearOfEstablishment();
        verify(companyDto).getCompanyId();
        verify(companyDto).getCompanyName();
        verify(companyDto).getDomicile();
        verify(companyDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyEntityToCompanyDto(Company)}
     */
    @Test
    void testMapCompanyEntityToCompanyDto() {
        CompanyDto actualMapCompanyEntityToCompanyDtoResult = this.mappingConfiguration
                .mapCompanyEntityToCompanyDto(new Company(123L, "42", "Company Name", "Domicile", 1, true));
        assertEquals("42", actualMapCompanyEntityToCompanyDtoResult.getCompanyId());
        assertTrue(actualMapCompanyEntityToCompanyDtoResult.isActive());
        assertEquals(1, actualMapCompanyEntityToCompanyDtoResult.getYearOfEstablishment());
        assertEquals(123L, actualMapCompanyEntityToCompanyDtoResult.getId());
        assertEquals("Domicile", actualMapCompanyEntityToCompanyDtoResult.getDomicile());
        assertEquals("Company Name", actualMapCompanyEntityToCompanyDtoResult.getCompanyName());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyEntityToCompanyDto(Company)}
     */
    @Test
    void testMapCompanyEntityToCompanyDto2() {
        CompanyDto actualMapCompanyEntityToCompanyDtoResult = this.mappingConfiguration
                .mapCompanyEntityToCompanyDto(new Company(123L, "42", "42", "Domicile", 1, true));
        assertEquals("42", actualMapCompanyEntityToCompanyDtoResult.getCompanyId());
        assertTrue(actualMapCompanyEntityToCompanyDtoResult.isActive());
        assertEquals(1, actualMapCompanyEntityToCompanyDtoResult.getYearOfEstablishment());
        assertEquals(123L, actualMapCompanyEntityToCompanyDtoResult.getId());
        assertEquals("Domicile", actualMapCompanyEntityToCompanyDtoResult.getDomicile());
        assertEquals("42", actualMapCompanyEntityToCompanyDtoResult.getCompanyName());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyEntityToCompanyDto(Company)}
     */
    @Test
    void testMapCompanyEntityToCompanyDto3() {
        CompanyDto actualMapCompanyEntityToCompanyDtoResult = this.mappingConfiguration
                .mapCompanyEntityToCompanyDto(new Company());
        assertNull(actualMapCompanyEntityToCompanyDtoResult.getCompanyId());
        assertFalse(actualMapCompanyEntityToCompanyDtoResult.isActive());
        assertEquals(0, actualMapCompanyEntityToCompanyDtoResult.getYearOfEstablishment());
        assertEquals(0L, actualMapCompanyEntityToCompanyDtoResult.getId());
        assertNull(actualMapCompanyEntityToCompanyDtoResult.getDomicile());
        assertNull(actualMapCompanyEntityToCompanyDtoResult.getCompanyName());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyEntityToCompanyDto(Company)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapCompanyEntityToCompanyDto4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapCompanyEntityToCompanyDto(MappingConfiguration.java:40)
        //   In order to prevent mapCompanyEntityToCompanyDto(Company)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapCompanyEntityToCompanyDto(Company).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapCompanyEntityToCompanyDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyEntityToCompanyDto(Company)}
     */
    @Test
    void testMapCompanyEntityToCompanyDto5() {
        Company company = mock(Company.class);
        when(company.isActive()).thenReturn(true);
        when(company.getYearOfEstablishment()).thenReturn(1);
        when(company.getCompanyId()).thenReturn("42");
        when(company.getCompanyName()).thenReturn("Company Name");
        when(company.getDomicile()).thenReturn("Domicile");
        when(company.getId()).thenReturn(123L);
        CompanyDto actualMapCompanyEntityToCompanyDtoResult = this.mappingConfiguration
                .mapCompanyEntityToCompanyDto(company);
        assertEquals("42", actualMapCompanyEntityToCompanyDtoResult.getCompanyId());
        assertTrue(actualMapCompanyEntityToCompanyDtoResult.isActive());
        assertEquals(1, actualMapCompanyEntityToCompanyDtoResult.getYearOfEstablishment());
        assertEquals(123L, actualMapCompanyEntityToCompanyDtoResult.getId());
        assertEquals("Domicile", actualMapCompanyEntityToCompanyDtoResult.getDomicile());
        assertEquals("Company Name", actualMapCompanyEntityToCompanyDtoResult.getCompanyName());
        verify(company).isActive();
        verify(company).getYearOfEstablishment();
        verify(company).getCompanyId();
        verify(company).getCompanyName();
        verify(company).getDomicile();
        verify(company).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapCompanyEntityToCompanyDto(Company)}
     */
    @Test
    void testMapCompanyEntityToCompanyDto6() {
        Company company = mock(Company.class);
        when(company.isActive()).thenReturn(true);
        when(company.getYearOfEstablishment()).thenReturn(Integer.MIN_VALUE);
        when(company.getCompanyId()).thenReturn("42");
        when(company.getCompanyName()).thenReturn("Company Name");
        when(company.getDomicile()).thenReturn("Domicile");
        when(company.getId()).thenReturn(Long.MIN_VALUE);
        CompanyDto actualMapCompanyEntityToCompanyDtoResult = this.mappingConfiguration
                .mapCompanyEntityToCompanyDto(company);
        assertEquals("42", actualMapCompanyEntityToCompanyDtoResult.getCompanyId());
        assertTrue(actualMapCompanyEntityToCompanyDtoResult.isActive());
        assertEquals(Integer.MIN_VALUE, actualMapCompanyEntityToCompanyDtoResult.getYearOfEstablishment());
        assertEquals(Long.MIN_VALUE, actualMapCompanyEntityToCompanyDtoResult.getId());
        assertEquals("Domicile", actualMapCompanyEntityToCompanyDtoResult.getDomicile());
        assertEquals("Company Name", actualMapCompanyEntityToCompanyDtoResult.getCompanyName());
        verify(company).isActive();
        verify(company).getYearOfEstablishment();
        verify(company).getCompanyId();
        verify(company).getCompanyName();
        verify(company).getDomicile();
        verify(company).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioDtoToPortfolioEntity(PortfolioDto)}
     */
    @Test
    void testMapPortfolioDtoToPortfolioEntity() {
        Portfolio actualMapPortfolioDtoToPortfolioEntityResult = this.mappingConfiguration
                .mapPortfolioDtoToPortfolioEntity(new PortfolioDto());
        assertNull(actualMapPortfolioDtoToPortfolioEntityResult.getCreationDate());
        assertFalse(actualMapPortfolioDtoToPortfolioEntityResult.isActive());
        assertNull(actualMapPortfolioDtoToPortfolioEntityResult.getPositions());
        assertNull(actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioName());
        assertNull(actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioId());
        assertEquals(0L, actualMapPortfolioDtoToPortfolioEntityResult.getId());
        assertNull(actualMapPortfolioDtoToPortfolioEntityResult.getFundSize());
        assertNull(actualMapPortfolioDtoToPortfolioEntityResult.getCurrency());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioDtoToPortfolioEntity(PortfolioDto)}
     */
    @Test
    void testMapPortfolioDtoToPortfolioEntity2() {
        ArrayList<PositionDto> positionDtoList = new ArrayList<>();
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        Portfolio actualMapPortfolioDtoToPortfolioEntityResult = this.mappingConfiguration
                .mapPortfolioDtoToPortfolioEntity(new PortfolioDto(123L, true, positionDtoList, valueOfResult, fromResult,
                        com.company.dto.Currency.GBP, "Portfolio Name", "42"));
        assertSame(fromResult, actualMapPortfolioDtoToPortfolioEntityResult.getCreationDate());
        assertTrue(actualMapPortfolioDtoToPortfolioEntityResult.isActive());
        assertEquals(positionDtoList, actualMapPortfolioDtoToPortfolioEntityResult.getPositions());
        assertEquals("Portfolio Name", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioDtoToPortfolioEntityResult.getId());
        BigDecimal fundSize = actualMapPortfolioDtoToPortfolioEntityResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.entity.Currency.GBP, actualMapPortfolioDtoToPortfolioEntityResult.getCurrency());
        assertEquals("42", fundSize.toString());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioDtoToPortfolioEntity(PortfolioDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapPortfolioDtoToPortfolioEntity3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapPortfolioDtoToPortfolioEntity(MappingConfiguration.java:44)
        //   In order to prevent mapPortfolioDtoToPortfolioEntity(PortfolioDto)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapPortfolioDtoToPortfolioEntity(PortfolioDto).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapPortfolioDtoToPortfolioEntity(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioDtoToPortfolioEntity(PortfolioDto)}
     */
    @Test
    void testMapPortfolioDtoToPortfolioEntity4() {
        PortfolioDto portfolioDto = mock(PortfolioDto.class);
        when(portfolioDto.isActive()).thenReturn(true);
        when(portfolioDto.getCurrency()).thenReturn(com.company.dto.Currency.GBP);
        when(portfolioDto.getPortfolioId()).thenReturn("42");
        when(portfolioDto.getPortfolioName()).thenReturn("Portfolio Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(portfolioDto.getFundSize()).thenReturn(valueOfResult);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(portfolioDto.getCreationDate()).thenReturn(fromResult);
        ArrayList<PositionDto> positionDtoList = new ArrayList<>();
        when(portfolioDto.getPositions()).thenReturn(positionDtoList);
        when(portfolioDto.getId()).thenReturn(123L);
        Portfolio actualMapPortfolioDtoToPortfolioEntityResult = this.mappingConfiguration
                .mapPortfolioDtoToPortfolioEntity(portfolioDto);
        assertSame(fromResult, actualMapPortfolioDtoToPortfolioEntityResult.getCreationDate());
        assertTrue(actualMapPortfolioDtoToPortfolioEntityResult.isActive());
        assertEquals(positionDtoList, actualMapPortfolioDtoToPortfolioEntityResult.getPositions());
        assertEquals("Portfolio Name", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioDtoToPortfolioEntityResult.getId());
        BigDecimal fundSize = actualMapPortfolioDtoToPortfolioEntityResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.entity.Currency.GBP, actualMapPortfolioDtoToPortfolioEntityResult.getCurrency());
        assertEquals("42", fundSize.toString());
        verify(portfolioDto).isActive();
        verify(portfolioDto).getCurrency();
        verify(portfolioDto).getPortfolioId();
        verify(portfolioDto).getPortfolioName();
        verify(portfolioDto).getFundSize();
        verify(portfolioDto).getCreationDate();
        verify(portfolioDto).getPositions();
        verify(portfolioDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioDtoToPortfolioEntity(PortfolioDto)}
     */
    @Test
    void testMapPortfolioDtoToPortfolioEntity5() {
        PortfolioDto portfolioDto = mock(PortfolioDto.class);
        when(portfolioDto.isActive()).thenReturn(true);
        when(portfolioDto.getCurrency()).thenReturn(com.company.dto.Currency.GBP);
        when(portfolioDto.getPortfolioId()).thenReturn("42");
        when(portfolioDto.getPortfolioName()).thenReturn("42");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(portfolioDto.getFundSize()).thenReturn(valueOfResult);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(portfolioDto.getCreationDate()).thenReturn(fromResult);
        ArrayList<PositionDto> positionDtoList = new ArrayList<>();
        when(portfolioDto.getPositions()).thenReturn(positionDtoList);
        when(portfolioDto.getId()).thenReturn(123L);
        Portfolio actualMapPortfolioDtoToPortfolioEntityResult = this.mappingConfiguration
                .mapPortfolioDtoToPortfolioEntity(portfolioDto);
        assertSame(fromResult, actualMapPortfolioDtoToPortfolioEntityResult.getCreationDate());
        assertTrue(actualMapPortfolioDtoToPortfolioEntityResult.isActive());
        assertEquals(positionDtoList, actualMapPortfolioDtoToPortfolioEntityResult.getPositions());
        assertEquals("42", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioDtoToPortfolioEntityResult.getId());
        BigDecimal fundSize = actualMapPortfolioDtoToPortfolioEntityResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.entity.Currency.GBP, actualMapPortfolioDtoToPortfolioEntityResult.getCurrency());
        assertEquals("42", fundSize.toString());
        verify(portfolioDto).isActive();
        verify(portfolioDto).getCurrency();
        verify(portfolioDto).getPortfolioId();
        verify(portfolioDto).getPortfolioName();
        verify(portfolioDto).getFundSize();
        verify(portfolioDto).getCreationDate();
        verify(portfolioDto).getPositions();
        verify(portfolioDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioDtoToPortfolioEntity(PortfolioDto)}
     */
    @Test
    void testMapPortfolioDtoToPortfolioEntity6() {
        PortfolioDto portfolioDto = mock(PortfolioDto.class);
        when(portfolioDto.isActive()).thenReturn(true);
        when(portfolioDto.getCurrency()).thenReturn(com.company.dto.Currency.GBP);
        when(portfolioDto.getPortfolioId()).thenReturn("42");
        when(portfolioDto.getPortfolioName()).thenReturn("Portfolio Name");
        when(portfolioDto.getFundSize()).thenReturn(null);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(portfolioDto.getCreationDate()).thenReturn(fromResult);
        ArrayList<PositionDto> positionDtoList = new ArrayList<>();
        when(portfolioDto.getPositions()).thenReturn(positionDtoList);
        when(portfolioDto.getId()).thenReturn(123L);
        Portfolio actualMapPortfolioDtoToPortfolioEntityResult = this.mappingConfiguration
                .mapPortfolioDtoToPortfolioEntity(portfolioDto);
        assertSame(fromResult, actualMapPortfolioDtoToPortfolioEntityResult.getCreationDate());
        assertTrue(actualMapPortfolioDtoToPortfolioEntityResult.isActive());
        assertEquals(positionDtoList, actualMapPortfolioDtoToPortfolioEntityResult.getPositions());
        assertEquals("Portfolio Name", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioDtoToPortfolioEntityResult.getId());
        assertNull(actualMapPortfolioDtoToPortfolioEntityResult.getFundSize());
        assertEquals(com.company.entity.Currency.GBP, actualMapPortfolioDtoToPortfolioEntityResult.getCurrency());
        verify(portfolioDto).isActive();
        verify(portfolioDto).getCurrency();
        verify(portfolioDto).getPortfolioId();
        verify(portfolioDto).getPortfolioName();
        verify(portfolioDto).getFundSize();
        verify(portfolioDto).getCreationDate();
        verify(portfolioDto).getPositions();
        verify(portfolioDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioDtoToPortfolioEntity(PortfolioDto)}
     */
    @Test
    void testMapPortfolioDtoToPortfolioEntity7() {
        ArrayList<PositionDto> positionDtoList = new ArrayList<>();
        positionDtoList.add(new PositionDto());
        PortfolioDto portfolioDto = mock(PortfolioDto.class);
        when(portfolioDto.isActive()).thenReturn(true);
        when(portfolioDto.getCurrency()).thenReturn(com.company.dto.Currency.GBP);
        when(portfolioDto.getPortfolioId()).thenReturn("42");
        when(portfolioDto.getPortfolioName()).thenReturn("Portfolio Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(portfolioDto.getFundSize()).thenReturn(valueOfResult);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(portfolioDto.getCreationDate()).thenReturn(fromResult);
        when(portfolioDto.getPositions()).thenReturn(positionDtoList);
        when(portfolioDto.getId()).thenReturn(123L);
        Portfolio actualMapPortfolioDtoToPortfolioEntityResult = this.mappingConfiguration
                .mapPortfolioDtoToPortfolioEntity(portfolioDto);
        assertSame(fromResult, actualMapPortfolioDtoToPortfolioEntityResult.getCreationDate());
        assertTrue(actualMapPortfolioDtoToPortfolioEntityResult.isActive());
        assertEquals(1, actualMapPortfolioDtoToPortfolioEntityResult.getPositions().size());
        assertEquals("Portfolio Name", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioDtoToPortfolioEntityResult.getId());
        BigDecimal fundSize = actualMapPortfolioDtoToPortfolioEntityResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.entity.Currency.GBP, actualMapPortfolioDtoToPortfolioEntityResult.getCurrency());
        assertEquals("42", fundSize.toString());
        verify(portfolioDto).isActive();
        verify(portfolioDto).getCurrency();
        verify(portfolioDto).getPortfolioId();
        verify(portfolioDto).getPortfolioName();
        verify(portfolioDto).getFundSize();
        verify(portfolioDto).getCreationDate();
        verify(portfolioDto).getPositions();
        verify(portfolioDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioDtoToPortfolioEntity(PortfolioDto)}
     */
    @Test
    void testMapPortfolioDtoToPortfolioEntity8() {
        ArrayList<PositionDto> positionDtoList = new ArrayList<>();
        positionDtoList.add(new PositionDto());
        positionDtoList.add(new PositionDto());
        PortfolioDto portfolioDto = mock(PortfolioDto.class);
        when(portfolioDto.isActive()).thenReturn(true);
        when(portfolioDto.getCurrency()).thenReturn(com.company.dto.Currency.GBP);
        when(portfolioDto.getPortfolioId()).thenReturn("42");
        when(portfolioDto.getPortfolioName()).thenReturn("Portfolio Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(portfolioDto.getFundSize()).thenReturn(valueOfResult);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(portfolioDto.getCreationDate()).thenReturn(fromResult);
        when(portfolioDto.getPositions()).thenReturn(positionDtoList);
        when(portfolioDto.getId()).thenReturn(123L);
        Portfolio actualMapPortfolioDtoToPortfolioEntityResult = this.mappingConfiguration
                .mapPortfolioDtoToPortfolioEntity(portfolioDto);
        assertSame(fromResult, actualMapPortfolioDtoToPortfolioEntityResult.getCreationDate());
        assertTrue(actualMapPortfolioDtoToPortfolioEntityResult.isActive());
        assertEquals(2, actualMapPortfolioDtoToPortfolioEntityResult.getPositions().size());
        assertEquals("Portfolio Name", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioDtoToPortfolioEntityResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioDtoToPortfolioEntityResult.getId());
        BigDecimal fundSize = actualMapPortfolioDtoToPortfolioEntityResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.entity.Currency.GBP, actualMapPortfolioDtoToPortfolioEntityResult.getCurrency());
        assertEquals("42", fundSize.toString());
        verify(portfolioDto).isActive();
        verify(portfolioDto).getCurrency();
        verify(portfolioDto).getPortfolioId();
        verify(portfolioDto).getPortfolioName();
        verify(portfolioDto).getFundSize();
        verify(portfolioDto).getCreationDate();
        verify(portfolioDto).getPositions();
        verify(portfolioDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioEntityToPortfolioDto(Portfolio)}
     */
    @Test
    void testMapPortfolioEntityToPortfolioDto() {
        PortfolioDto actualMapPortfolioEntityToPortfolioDtoResult = this.mappingConfiguration
                .mapPortfolioEntityToPortfolioDto(new Portfolio());
        assertNull(actualMapPortfolioEntityToPortfolioDtoResult.getCreationDate());
        assertFalse(actualMapPortfolioEntityToPortfolioDtoResult.isActive());
        assertNull(actualMapPortfolioEntityToPortfolioDtoResult.getPositions());
        assertNull(actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioName());
        assertNull(actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioId());
        assertEquals(0L, actualMapPortfolioEntityToPortfolioDtoResult.getId());
        assertNull(actualMapPortfolioEntityToPortfolioDtoResult.getFundSize());
        assertNull(actualMapPortfolioEntityToPortfolioDtoResult.getCurrency());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioEntityToPortfolioDto(Portfolio)}
     */
    @Test
    void testMapPortfolioEntityToPortfolioDto2() {
        ArrayList<Position> positionList = new ArrayList<>();
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        PortfolioDto actualMapPortfolioEntityToPortfolioDtoResult = this.mappingConfiguration
                .mapPortfolioEntityToPortfolioDto(new Portfolio(123L, true, positionList, valueOfResult, fromResult,
                        com.company.entity.Currency.GBP, "Portfolio Name", "42"));
        assertSame(fromResult, actualMapPortfolioEntityToPortfolioDtoResult.getCreationDate());
        assertTrue(actualMapPortfolioEntityToPortfolioDtoResult.isActive());
        assertEquals(positionList, actualMapPortfolioEntityToPortfolioDtoResult.getPositions());
        assertEquals("Portfolio Name", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioEntityToPortfolioDtoResult.getId());
        BigDecimal fundSize = actualMapPortfolioEntityToPortfolioDtoResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.dto.Currency.GBP, actualMapPortfolioEntityToPortfolioDtoResult.getCurrency());
        assertEquals("42", fundSize.toString());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioEntityToPortfolioDto(Portfolio)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapPortfolioEntityToPortfolioDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapPortfolioEntityToPortfolioDto(MappingConfiguration.java:48)
        //   In order to prevent mapPortfolioEntityToPortfolioDto(Portfolio)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapPortfolioEntityToPortfolioDto(Portfolio).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapPortfolioEntityToPortfolioDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioEntityToPortfolioDto(Portfolio)}
     */
    @Test
    void testMapPortfolioEntityToPortfolioDto4() {
        Portfolio portfolio = mock(Portfolio.class);
        when(portfolio.isActive()).thenReturn(true);
        when(portfolio.getCurrency()).thenReturn(com.company.entity.Currency.GBP);
        when(portfolio.getPortfolioId()).thenReturn("42");
        when(portfolio.getPortfolioName()).thenReturn("Portfolio Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(portfolio.getFundSize()).thenReturn(valueOfResult);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(portfolio.getCreationDate()).thenReturn(fromResult);
        ArrayList<Position> positionList = new ArrayList<>();
        when(portfolio.getPositions()).thenReturn(positionList);
        when(portfolio.getId()).thenReturn(123L);
        PortfolioDto actualMapPortfolioEntityToPortfolioDtoResult = this.mappingConfiguration
                .mapPortfolioEntityToPortfolioDto(portfolio);
        assertSame(fromResult, actualMapPortfolioEntityToPortfolioDtoResult.getCreationDate());
        assertTrue(actualMapPortfolioEntityToPortfolioDtoResult.isActive());
        assertEquals(positionList, actualMapPortfolioEntityToPortfolioDtoResult.getPositions());
        assertEquals("Portfolio Name", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioEntityToPortfolioDtoResult.getId());
        BigDecimal fundSize = actualMapPortfolioEntityToPortfolioDtoResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.dto.Currency.GBP, actualMapPortfolioEntityToPortfolioDtoResult.getCurrency());
        assertEquals("42", fundSize.toString());
        verify(portfolio).isActive();
        verify(portfolio).getCurrency();
        verify(portfolio).getPortfolioId();
        verify(portfolio).getPortfolioName();
        verify(portfolio).getFundSize();
        verify(portfolio).getCreationDate();
        verify(portfolio).getPositions();
        verify(portfolio).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioEntityToPortfolioDto(Portfolio)}
     */
    @Test
    void testMapPortfolioEntityToPortfolioDto5() {
        Portfolio portfolio = mock(Portfolio.class);
        when(portfolio.isActive()).thenReturn(true);
        when(portfolio.getCurrency()).thenReturn(com.company.entity.Currency.GBP);
        when(portfolio.getPortfolioId()).thenReturn("42");
        when(portfolio.getPortfolioName()).thenReturn("42");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(portfolio.getFundSize()).thenReturn(valueOfResult);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(portfolio.getCreationDate()).thenReturn(fromResult);
        ArrayList<Position> positionList = new ArrayList<>();
        when(portfolio.getPositions()).thenReturn(positionList);
        when(portfolio.getId()).thenReturn(123L);
        PortfolioDto actualMapPortfolioEntityToPortfolioDtoResult = this.mappingConfiguration
                .mapPortfolioEntityToPortfolioDto(portfolio);
        assertSame(fromResult, actualMapPortfolioEntityToPortfolioDtoResult.getCreationDate());
        assertTrue(actualMapPortfolioEntityToPortfolioDtoResult.isActive());
        assertEquals(positionList, actualMapPortfolioEntityToPortfolioDtoResult.getPositions());
        assertEquals("42", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioEntityToPortfolioDtoResult.getId());
        BigDecimal fundSize = actualMapPortfolioEntityToPortfolioDtoResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.dto.Currency.GBP, actualMapPortfolioEntityToPortfolioDtoResult.getCurrency());
        assertEquals("42", fundSize.toString());
        verify(portfolio).isActive();
        verify(portfolio).getCurrency();
        verify(portfolio).getPortfolioId();
        verify(portfolio).getPortfolioName();
        verify(portfolio).getFundSize();
        verify(portfolio).getCreationDate();
        verify(portfolio).getPositions();
        verify(portfolio).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioEntityToPortfolioDto(Portfolio)}
     */
    @Test
    void testMapPortfolioEntityToPortfolioDto6() {
        ArrayList<Position> positionList = new ArrayList<>();
        positionList.add(new Position());
        Portfolio portfolio = mock(Portfolio.class);
        when(portfolio.isActive()).thenReturn(true);
        when(portfolio.getCurrency()).thenReturn(com.company.entity.Currency.GBP);
        when(portfolio.getPortfolioId()).thenReturn("42");
        when(portfolio.getPortfolioName()).thenReturn("Portfolio Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(portfolio.getFundSize()).thenReturn(valueOfResult);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(portfolio.getCreationDate()).thenReturn(fromResult);
        when(portfolio.getPositions()).thenReturn(positionList);
        when(portfolio.getId()).thenReturn(123L);
        PortfolioDto actualMapPortfolioEntityToPortfolioDtoResult = this.mappingConfiguration
                .mapPortfolioEntityToPortfolioDto(portfolio);
        assertSame(fromResult, actualMapPortfolioEntityToPortfolioDtoResult.getCreationDate());
        assertTrue(actualMapPortfolioEntityToPortfolioDtoResult.isActive());
        assertEquals(1, actualMapPortfolioEntityToPortfolioDtoResult.getPositions().size());
        assertEquals("Portfolio Name", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioEntityToPortfolioDtoResult.getId());
        BigDecimal fundSize = actualMapPortfolioEntityToPortfolioDtoResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.dto.Currency.GBP, actualMapPortfolioEntityToPortfolioDtoResult.getCurrency());
        assertEquals("42", fundSize.toString());
        verify(portfolio).isActive();
        verify(portfolio).getCurrency();
        verify(portfolio).getPortfolioId();
        verify(portfolio).getPortfolioName();
        verify(portfolio).getFundSize();
        verify(portfolio).getCreationDate();
        verify(portfolio).getPositions();
        verify(portfolio).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioEntityToPortfolioDto(Portfolio)}
     */
    @Test
    void testMapPortfolioEntityToPortfolioDto7() {
        ArrayList<Position> positionList = new ArrayList<>();
        positionList.add(new Position());
        positionList.add(new Position());
        Portfolio portfolio = mock(Portfolio.class);
        when(portfolio.isActive()).thenReturn(true);
        when(portfolio.getCurrency()).thenReturn(com.company.entity.Currency.GBP);
        when(portfolio.getPortfolioId()).thenReturn("42");
        when(portfolio.getPortfolioName()).thenReturn("Portfolio Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(portfolio.getFundSize()).thenReturn(valueOfResult);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(portfolio.getCreationDate()).thenReturn(fromResult);
        when(portfolio.getPositions()).thenReturn(positionList);
        when(portfolio.getId()).thenReturn(123L);
        PortfolioDto actualMapPortfolioEntityToPortfolioDtoResult = this.mappingConfiguration
                .mapPortfolioEntityToPortfolioDto(portfolio);
        assertSame(fromResult, actualMapPortfolioEntityToPortfolioDtoResult.getCreationDate());
        assertTrue(actualMapPortfolioEntityToPortfolioDtoResult.isActive());
        assertEquals(2, actualMapPortfolioEntityToPortfolioDtoResult.getPositions().size());
        assertEquals("Portfolio Name", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioEntityToPortfolioDtoResult.getId());
        BigDecimal fundSize = actualMapPortfolioEntityToPortfolioDtoResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.dto.Currency.GBP, actualMapPortfolioEntityToPortfolioDtoResult.getCurrency());
        assertEquals("42", fundSize.toString());
        verify(portfolio).isActive();
        verify(portfolio).getCurrency();
        verify(portfolio).getPortfolioId();
        verify(portfolio).getPortfolioName();
        verify(portfolio).getFundSize();
        verify(portfolio).getCreationDate();
        verify(portfolio).getPositions();
        verify(portfolio).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPortfolioEntityToPortfolioDto(Portfolio)}
     */
    @Test
    void testMapPortfolioEntityToPortfolioDto8() {
        Portfolio portfolio = mock(Portfolio.class);
        when(portfolio.isActive()).thenReturn(true);
        when(portfolio.getCurrency()).thenReturn(com.company.entity.Currency.GBP);
        when(portfolio.getPortfolioId()).thenReturn("42");
        when(portfolio.getPortfolioName()).thenReturn("42");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(portfolio.getFundSize()).thenReturn(valueOfResult);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneOffset.ofTotalSeconds(14)).toInstant());
        when(portfolio.getCreationDate()).thenReturn(fromResult);
        ArrayList<Position> positionList = new ArrayList<>();
        when(portfolio.getPositions()).thenReturn(positionList);
        when(portfolio.getId()).thenReturn(123L);
        PortfolioDto actualMapPortfolioEntityToPortfolioDtoResult = this.mappingConfiguration
                .mapPortfolioEntityToPortfolioDto(portfolio);
        assertSame(fromResult, actualMapPortfolioEntityToPortfolioDtoResult.getCreationDate());
        assertTrue(actualMapPortfolioEntityToPortfolioDtoResult.isActive());
        assertEquals(positionList, actualMapPortfolioEntityToPortfolioDtoResult.getPositions());
        assertEquals("42", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioName());
        assertEquals("42", actualMapPortfolioEntityToPortfolioDtoResult.getPortfolioId());
        assertEquals(123L, actualMapPortfolioEntityToPortfolioDtoResult.getId());
        BigDecimal fundSize = actualMapPortfolioEntityToPortfolioDtoResult.getFundSize();
        assertSame(valueOfResult, fundSize);
        assertEquals(com.company.dto.Currency.GBP, actualMapPortfolioEntityToPortfolioDtoResult.getCurrency());
        assertEquals("42", fundSize.toString());
        verify(portfolio).isActive();
        verify(portfolio).getCurrency();
        verify(portfolio).getPortfolioId();
        verify(portfolio).getPortfolioName();
        verify(portfolio).getFundSize();
        verify(portfolio).getCreationDate();
        verify(portfolio).getPositions();
        verify(portfolio).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionDtoToPositionEntity(PositionDto)}
     */
    @Test
    void testMapPositionDtoToPositionEntity() {
        Position actualMapPositionDtoToPositionEntityResult = this.mappingConfiguration
                .mapPositionDtoToPositionEntity(new PositionDto());
        assertNull(actualMapPositionDtoToPositionEntityResult.getCurrency());
        assertNull(actualMapPositionDtoToPositionEntityResult.getStartDate());
        assertEquals(0, actualMapPositionDtoToPositionEntityResult.getPositionMarketValue());
        assertNull(actualMapPositionDtoToPositionEntityResult.getPortfolioName());
        assertNull(actualMapPositionDtoToPositionEntityResult.getPortfolioId());
        assertEquals(0, actualMapPositionDtoToPositionEntityResult.getNumberShares());
        assertEquals(0L, actualMapPositionDtoToPositionEntityResult.getId());
        assertNull(actualMapPositionDtoToPositionEntityResult.getEndDate());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionDtoToPositionEntity(PositionDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapPositionDtoToPositionEntity2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapPositionDtoToPositionEntity(MappingConfiguration.java:52)
        //   In order to prevent mapPositionDtoToPositionEntity(PositionDto)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapPositionDtoToPositionEntity(PositionDto).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapPositionDtoToPositionEntity(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionDtoToPositionEntity(PositionDto)}
     */
    @Test
    void testMapPositionDtoToPositionEntity3() {
        PositionDto positionDto = mock(PositionDto.class);
        when(positionDto.getCurrency()).thenReturn(com.company.dto.Currency.GBP);
        when(positionDto.getNumberShares()).thenReturn(10);
        when(positionDto.getPositionMarketValue()).thenReturn(1);
        when(positionDto.getPortfolioId()).thenReturn("42");
        when(positionDto.getPortfolioName()).thenReturn("Portfolio Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(positionDto.getEndDate()).thenReturn(fromResult);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        when(positionDto.getStartDate()).thenReturn(fromResult1);
        when(positionDto.getId()).thenReturn(123L);
        Position actualMapPositionDtoToPositionEntityResult = this.mappingConfiguration
                .mapPositionDtoToPositionEntity(positionDto);
        assertEquals(com.company.entity.Currency.GBP, actualMapPositionDtoToPositionEntityResult.getCurrency());
        assertSame(fromResult1, actualMapPositionDtoToPositionEntityResult.getStartDate());
        assertEquals(1, actualMapPositionDtoToPositionEntityResult.getPositionMarketValue());
        assertEquals("Portfolio Name", actualMapPositionDtoToPositionEntityResult.getPortfolioName());
        assertEquals("42", actualMapPositionDtoToPositionEntityResult.getPortfolioId());
        assertEquals(10, actualMapPositionDtoToPositionEntityResult.getNumberShares());
        assertEquals(123L, actualMapPositionDtoToPositionEntityResult.getId());
        assertSame(fromResult, actualMapPositionDtoToPositionEntityResult.getEndDate());
        verify(positionDto).getCurrency();
        verify(positionDto).getNumberShares();
        verify(positionDto).getPositionMarketValue();
        verify(positionDto).getPortfolioId();
        verify(positionDto).getPortfolioName();
        verify(positionDto).getEndDate();
        verify(positionDto).getStartDate();
        verify(positionDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionDtoToPositionEntity(PositionDto)}
     */
    @Test
    void testMapPositionDtoToPositionEntity4() {
        PositionDto positionDto = mock(PositionDto.class);
        when(positionDto.getCurrency()).thenReturn(com.company.dto.Currency.GBP);
        when(positionDto.getNumberShares()).thenReturn(10);
        when(positionDto.getPositionMarketValue()).thenReturn(1);
        when(positionDto.getPortfolioId()).thenReturn("42");
        when(positionDto.getPortfolioName()).thenReturn("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(positionDto.getEndDate()).thenReturn(fromResult);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        when(positionDto.getStartDate()).thenReturn(fromResult1);
        when(positionDto.getId()).thenReturn(123L);
        Position actualMapPositionDtoToPositionEntityResult = this.mappingConfiguration
                .mapPositionDtoToPositionEntity(positionDto);
        assertEquals(com.company.entity.Currency.GBP, actualMapPositionDtoToPositionEntityResult.getCurrency());
        assertSame(fromResult1, actualMapPositionDtoToPositionEntityResult.getStartDate());
        assertEquals(1, actualMapPositionDtoToPositionEntityResult.getPositionMarketValue());
        assertEquals("42", actualMapPositionDtoToPositionEntityResult.getPortfolioName());
        assertEquals("42", actualMapPositionDtoToPositionEntityResult.getPortfolioId());
        assertEquals(10, actualMapPositionDtoToPositionEntityResult.getNumberShares());
        assertEquals(123L, actualMapPositionDtoToPositionEntityResult.getId());
        assertSame(fromResult, actualMapPositionDtoToPositionEntityResult.getEndDate());
        verify(positionDto).getCurrency();
        verify(positionDto).getNumberShares();
        verify(positionDto).getPositionMarketValue();
        verify(positionDto).getPortfolioId();
        verify(positionDto).getPortfolioName();
        verify(positionDto).getEndDate();
        verify(positionDto).getStartDate();
        verify(positionDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionDtoToPositionEntity(PositionDto)}
     */
    @Test
    void testMapPositionDtoToPositionEntity5() {
        PositionDto positionDto = mock(PositionDto.class);
        when(positionDto.getCurrency()).thenReturn(com.company.dto.Currency.GBP);
        when(positionDto.getNumberShares()).thenReturn(10);
        when(positionDto.getPositionMarketValue()).thenReturn(1);
        when(positionDto.getPortfolioId()).thenReturn("42");
        when(positionDto.getPortfolioName()).thenReturn("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(positionDto.getEndDate()).thenReturn(fromResult);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        when(positionDto.getStartDate()).thenReturn(fromResult1);
        when(positionDto.getId()).thenReturn(123L);
        Position actualMapPositionDtoToPositionEntityResult = this.mappingConfiguration
                .mapPositionDtoToPositionEntity(positionDto);
        assertEquals(com.company.entity.Currency.GBP, actualMapPositionDtoToPositionEntityResult.getCurrency());
        assertSame(fromResult1, actualMapPositionDtoToPositionEntityResult.getStartDate());
        assertEquals(1, actualMapPositionDtoToPositionEntityResult.getPositionMarketValue());
        assertEquals("42", actualMapPositionDtoToPositionEntityResult.getPortfolioName());
        assertEquals("42", actualMapPositionDtoToPositionEntityResult.getPortfolioId());
        assertEquals(10, actualMapPositionDtoToPositionEntityResult.getNumberShares());
        assertEquals(123L, actualMapPositionDtoToPositionEntityResult.getId());
        assertSame(fromResult, actualMapPositionDtoToPositionEntityResult.getEndDate());
        verify(positionDto).getCurrency();
        verify(positionDto).getNumberShares();
        verify(positionDto).getPositionMarketValue();
        verify(positionDto).getPortfolioId();
        verify(positionDto).getPortfolioName();
        verify(positionDto).getEndDate();
        verify(positionDto).getStartDate();
        verify(positionDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionEntityToPositionDto(Position)}
     */
    @Test
    void testMapPositionEntityToPositionDto() {
        PositionDto actualMapPositionEntityToPositionDtoResult = this.mappingConfiguration
                .mapPositionEntityToPositionDto(new Position());
        assertNull(actualMapPositionEntityToPositionDtoResult.getCurrency());
        assertNull(actualMapPositionEntityToPositionDtoResult.getStartDate());
        assertEquals(0, actualMapPositionEntityToPositionDtoResult.getPositionMarketValue());
        assertNull(actualMapPositionEntityToPositionDtoResult.getPortfolioName());
        assertNull(actualMapPositionEntityToPositionDtoResult.getPortfolioId());
        assertEquals(0, actualMapPositionEntityToPositionDtoResult.getNumberShares());
        assertEquals(0L, actualMapPositionEntityToPositionDtoResult.getId());
        assertNull(actualMapPositionEntityToPositionDtoResult.getEndDate());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionEntityToPositionDto(Position)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapPositionEntityToPositionDto2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapPositionEntityToPositionDto(MappingConfiguration.java:56)
        //   In order to prevent mapPositionEntityToPositionDto(Position)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapPositionEntityToPositionDto(Position).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapPositionEntityToPositionDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionEntityToPositionDto(Position)}
     */
    @Test
    void testMapPositionEntityToPositionDto3() {
        Position position = mock(Position.class);
        when(position.getCurrency()).thenReturn(com.company.entity.Currency.GBP);
        when(position.getNumberShares()).thenReturn(10);
        when(position.getPositionMarketValue()).thenReturn(1);
        when(position.getPortfolioId()).thenReturn("42");
        when(position.getPortfolioName()).thenReturn("Portfolio Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(position.getEndDate()).thenReturn(fromResult);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        when(position.getStartDate()).thenReturn(fromResult1);
        when(position.getId()).thenReturn(123L);
        PositionDto actualMapPositionEntityToPositionDtoResult = this.mappingConfiguration
                .mapPositionEntityToPositionDto(position);
        assertEquals(com.company.dto.Currency.GBP, actualMapPositionEntityToPositionDtoResult.getCurrency());
        assertSame(fromResult1, actualMapPositionEntityToPositionDtoResult.getStartDate());
        assertEquals(1, actualMapPositionEntityToPositionDtoResult.getPositionMarketValue());
        assertEquals("Portfolio Name", actualMapPositionEntityToPositionDtoResult.getPortfolioName());
        assertEquals("42", actualMapPositionEntityToPositionDtoResult.getPortfolioId());
        assertEquals(10, actualMapPositionEntityToPositionDtoResult.getNumberShares());
        assertEquals(123L, actualMapPositionEntityToPositionDtoResult.getId());
        assertSame(fromResult, actualMapPositionEntityToPositionDtoResult.getEndDate());
        verify(position).getCurrency();
        verify(position).getNumberShares();
        verify(position).getPositionMarketValue();
        verify(position).getPortfolioId();
        verify(position).getPortfolioName();
        verify(position).getEndDate();
        verify(position).getStartDate();
        verify(position).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionEntityToPositionDto(Position)}
     */
    @Test
    void testMapPositionEntityToPositionDto4() {
        Position position = mock(Position.class);
        when(position.getCurrency()).thenReturn(com.company.entity.Currency.GBP);
        when(position.getNumberShares()).thenReturn(10);
        when(position.getPositionMarketValue()).thenReturn(1);
        when(position.getPortfolioId()).thenReturn("42");
        when(position.getPortfolioName()).thenReturn("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(position.getEndDate()).thenReturn(fromResult);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        when(position.getStartDate()).thenReturn(fromResult1);
        when(position.getId()).thenReturn(123L);
        PositionDto actualMapPositionEntityToPositionDtoResult = this.mappingConfiguration
                .mapPositionEntityToPositionDto(position);
        assertEquals(com.company.dto.Currency.GBP, actualMapPositionEntityToPositionDtoResult.getCurrency());
        assertSame(fromResult1, actualMapPositionEntityToPositionDtoResult.getStartDate());
        assertEquals(1, actualMapPositionEntityToPositionDtoResult.getPositionMarketValue());
        assertEquals("42", actualMapPositionEntityToPositionDtoResult.getPortfolioName());
        assertEquals("42", actualMapPositionEntityToPositionDtoResult.getPortfolioId());
        assertEquals(10, actualMapPositionEntityToPositionDtoResult.getNumberShares());
        assertEquals(123L, actualMapPositionEntityToPositionDtoResult.getId());
        assertSame(fromResult, actualMapPositionEntityToPositionDtoResult.getEndDate());
        verify(position).getCurrency();
        verify(position).getNumberShares();
        verify(position).getPositionMarketValue();
        verify(position).getPortfolioId();
        verify(position).getPortfolioName();
        verify(position).getEndDate();
        verify(position).getStartDate();
        verify(position).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapPositionEntityToPositionDto(Position)}
     */
    @Test
    void testMapPositionEntityToPositionDto5() {
        Position position = mock(Position.class);
        when(position.getCurrency()).thenReturn(com.company.entity.Currency.GBP);
        when(position.getNumberShares()).thenReturn(10);
        when(position.getPositionMarketValue()).thenReturn(1);
        when(position.getPortfolioId()).thenReturn("42");
        when(position.getPortfolioName()).thenReturn("Portfolio Name");
        when(position.getEndDate()).thenReturn(mock(java.sql.Date.class));
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        java.util.Date fromResult = java.util.Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(position.getStartDate()).thenReturn(fromResult);
        when(position.getId()).thenReturn(123L);
        PositionDto actualMapPositionEntityToPositionDtoResult = this.mappingConfiguration
                .mapPositionEntityToPositionDto(position);
        assertEquals(com.company.dto.Currency.GBP, actualMapPositionEntityToPositionDtoResult.getCurrency());
        assertSame(fromResult, actualMapPositionEntityToPositionDtoResult.getStartDate());
        assertEquals(1, actualMapPositionEntityToPositionDtoResult.getPositionMarketValue());
        assertEquals("Portfolio Name", actualMapPositionEntityToPositionDtoResult.getPortfolioName());
        assertEquals("42", actualMapPositionEntityToPositionDtoResult.getPortfolioId());
        assertEquals(10, actualMapPositionEntityToPositionDtoResult.getNumberShares());
        assertEquals(123L, actualMapPositionEntityToPositionDtoResult.getId());
        verify(position).getCurrency();
        verify(position).getNumberShares();
        verify(position).getPositionMarketValue();
        verify(position).getPortfolioId();
        verify(position).getPortfolioName();
        verify(position).getEndDate();
        verify(position).getStartDate();
        verify(position).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserDtoToUserEntity(UserDto)}
     */
    @Test
    void testMapUserDtoToUserEntity() {
        User actualMapUserDtoToUserEntityResult = this.mappingConfiguration.mapUserDtoToUserEntity(new UserDto());
        assertNull(actualMapUserDtoToUserEntityResult.getUserLastName());
        assertNull(actualMapUserDtoToUserEntityResult.getUserId());
        assertNull(actualMapUserDtoToUserEntityResult.getUserFirstName());
        assertNull(actualMapUserDtoToUserEntityResult.getMobileNumbers());
        assertEquals(0L, actualMapUserDtoToUserEntityResult.getId());
        assertNull(actualMapUserDtoToUserEntityResult.getEmail());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserDtoToUserEntity(UserDto)}
     */
    @Test
    void testMapUserDtoToUserEntity2() {
        AddressDto address = new AddressDto(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654");

        ArrayList<String> stringList = new ArrayList<>();
        User actualMapUserDtoToUserEntityResult = this.mappingConfiguration
                .mapUserDtoToUserEntity(new UserDto(123L, address, stringList, "jane.doe@example.org", "Jane", "42", "Doe"));
        assertEquals("Doe", actualMapUserDtoToUserEntityResult.getUserLastName());
        assertEquals("jane.doe@example.org", actualMapUserDtoToUserEntityResult.getEmail());
        assertEquals(stringList, actualMapUserDtoToUserEntityResult.getMobileNumbers());
        assertEquals("Jane", actualMapUserDtoToUserEntityResult.getUserFirstName());
        assertEquals(123L, actualMapUserDtoToUserEntityResult.getId());
        assertEquals("42", actualMapUserDtoToUserEntityResult.getUserId());
        Address address1 = actualMapUserDtoToUserEntityResult.getAddress();
        assertEquals("Oxford", address1.getCity());
        assertEquals("42 Main St", address1.getAddressType());
        assertEquals("42 Main St", address1.getAddressId());
        assertEquals(123L, address1.getId());
        assertEquals("Street", address1.getStreet());
        assertEquals("21654", address1.getZip());
        assertEquals("GB", address1.getCountry());
        assertEquals("MD", address1.getState());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserDtoToUserEntity(UserDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapUserDtoToUserEntity3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapUserDtoToUserEntity(MappingConfiguration.java:60)
        //   In order to prevent mapUserDtoToUserEntity(UserDto)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapUserDtoToUserEntity(UserDto).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapUserDtoToUserEntity(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserDtoToUserEntity(UserDto)}
     */
    @Test
    void testMapUserDtoToUserEntity4() {
        UserDto userDto = mock(UserDto.class);
        when(userDto.getAddress())
                .thenReturn(new AddressDto(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654"));
        when(userDto.getEmail()).thenReturn("jane.doe@example.org");
        when(userDto.getUserFirstName()).thenReturn("Jane");
        when(userDto.getUserId()).thenReturn("42");
        when(userDto.getUserLastName()).thenReturn("Doe");
        ArrayList<String> stringList = new ArrayList<>();
        when(userDto.getMobileNumbers()).thenReturn(stringList);
        when(userDto.getId()).thenReturn(123L);
        User actualMapUserDtoToUserEntityResult = this.mappingConfiguration.mapUserDtoToUserEntity(userDto);
        assertEquals("Doe", actualMapUserDtoToUserEntityResult.getUserLastName());
        assertEquals("jane.doe@example.org", actualMapUserDtoToUserEntityResult.getEmail());
        assertEquals(stringList, actualMapUserDtoToUserEntityResult.getMobileNumbers());
        assertEquals("Jane", actualMapUserDtoToUserEntityResult.getUserFirstName());
        assertEquals(123L, actualMapUserDtoToUserEntityResult.getId());
        assertEquals("42", actualMapUserDtoToUserEntityResult.getUserId());
        Address address = actualMapUserDtoToUserEntityResult.getAddress();
        assertEquals("Oxford", address.getCity());
        assertEquals("42 Main St", address.getAddressType());
        assertEquals("42 Main St", address.getAddressId());
        assertEquals(123L, address.getId());
        assertEquals("Street", address.getStreet());
        assertEquals("21654", address.getZip());
        assertEquals("GB", address.getCountry());
        assertEquals("MD", address.getState());
        verify(userDto, atLeast(1)).getAddress();
        verify(userDto).getEmail();
        verify(userDto).getUserFirstName();
        verify(userDto).getUserId();
        verify(userDto).getUserLastName();
        verify(userDto).getMobileNumbers();
        verify(userDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserDtoToUserEntity(UserDto)}
     */
    @Test
    void testMapUserDtoToUserEntity5() {
        UserDto userDto = mock(UserDto.class);
        when(userDto.getAddress())
                .thenReturn(new AddressDto(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654"));
        when(userDto.getEmail()).thenReturn("com.company.dto.UserDto");
        when(userDto.getUserFirstName()).thenReturn("Jane");
        when(userDto.getUserId()).thenReturn("42");
        when(userDto.getUserLastName()).thenReturn("Doe");
        ArrayList<String> stringList = new ArrayList<>();
        when(userDto.getMobileNumbers()).thenReturn(stringList);
        when(userDto.getId()).thenReturn(123L);
        User actualMapUserDtoToUserEntityResult = this.mappingConfiguration.mapUserDtoToUserEntity(userDto);
        assertEquals("Doe", actualMapUserDtoToUserEntityResult.getUserLastName());
        assertEquals("com.company.dto.UserDto", actualMapUserDtoToUserEntityResult.getEmail());
        assertEquals(stringList, actualMapUserDtoToUserEntityResult.getMobileNumbers());
        assertEquals("Jane", actualMapUserDtoToUserEntityResult.getUserFirstName());
        assertEquals(123L, actualMapUserDtoToUserEntityResult.getId());
        assertEquals("42", actualMapUserDtoToUserEntityResult.getUserId());
        Address address = actualMapUserDtoToUserEntityResult.getAddress();
        assertEquals("Oxford", address.getCity());
        assertEquals("42 Main St", address.getAddressType());
        assertEquals("42 Main St", address.getAddressId());
        assertEquals(123L, address.getId());
        assertEquals("Street", address.getStreet());
        assertEquals("21654", address.getZip());
        assertEquals("GB", address.getCountry());
        assertEquals("MD", address.getState());
        verify(userDto, atLeast(1)).getAddress();
        verify(userDto).getEmail();
        verify(userDto).getUserFirstName();
        verify(userDto).getUserId();
        verify(userDto).getUserLastName();
        verify(userDto).getMobileNumbers();
        verify(userDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserDtoToUserEntity(UserDto)}
     */
    @Test
    void testMapUserDtoToUserEntity6() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        UserDto userDto = mock(UserDto.class);
        when(userDto.getAddress())
                .thenReturn(new AddressDto(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654"));
        when(userDto.getEmail()).thenReturn("jane.doe@example.org");
        when(userDto.getUserFirstName()).thenReturn("Jane");
        when(userDto.getUserId()).thenReturn("42");
        when(userDto.getUserLastName()).thenReturn("Doe");
        when(userDto.getMobileNumbers()).thenReturn(stringList);
        when(userDto.getId()).thenReturn(123L);
        User actualMapUserDtoToUserEntityResult = this.mappingConfiguration.mapUserDtoToUserEntity(userDto);
        assertEquals("Doe", actualMapUserDtoToUserEntityResult.getUserLastName());
        assertEquals("jane.doe@example.org", actualMapUserDtoToUserEntityResult.getEmail());
        List<String> mobileNumbers = actualMapUserDtoToUserEntityResult.getMobileNumbers();
        assertEquals(stringList, mobileNumbers);
        assertEquals(1, mobileNumbers.size());
        assertEquals("foo", mobileNumbers.get(0));
        assertEquals("Jane", actualMapUserDtoToUserEntityResult.getUserFirstName());
        assertEquals(123L, actualMapUserDtoToUserEntityResult.getId());
        assertEquals("42", actualMapUserDtoToUserEntityResult.getUserId());
        Address address = actualMapUserDtoToUserEntityResult.getAddress();
        assertEquals("Oxford", address.getCity());
        assertEquals("42 Main St", address.getAddressType());
        assertEquals("42 Main St", address.getAddressId());
        assertEquals(123L, address.getId());
        assertEquals("Street", address.getStreet());
        assertEquals("21654", address.getZip());
        assertEquals("GB", address.getCountry());
        assertEquals("MD", address.getState());
        verify(userDto, atLeast(1)).getAddress();
        verify(userDto).getEmail();
        verify(userDto).getUserFirstName();
        verify(userDto).getUserId();
        verify(userDto).getUserLastName();
        verify(userDto).getMobileNumbers();
        verify(userDto).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserEntityToUserDto(User)}
     */
    @Test
    void testMapUserEntityToUserDto() {
        UserDto actualMapUserEntityToUserDtoResult = this.mappingConfiguration.mapUserEntityToUserDto(new User());
        assertNull(actualMapUserEntityToUserDtoResult.getUserLastName());
        assertNull(actualMapUserEntityToUserDtoResult.getUserId());
        assertNull(actualMapUserEntityToUserDtoResult.getUserFirstName());
        assertNull(actualMapUserEntityToUserDtoResult.getMobileNumbers());
        assertEquals(0L, actualMapUserEntityToUserDtoResult.getId());
        assertNull(actualMapUserEntityToUserDtoResult.getEmail());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserEntityToUserDto(User)}
     */
    @Test
    void testMapUserEntityToUserDto2() {
        Address address = new Address(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654");

        ArrayList<String> stringList = new ArrayList<>();
        UserDto actualMapUserEntityToUserDtoResult = this.mappingConfiguration
                .mapUserEntityToUserDto(new User(123L, address, stringList, "jane.doe@example.org", "Jane", "42", "Doe"));
        assertEquals("Doe", actualMapUserEntityToUserDtoResult.getUserLastName());
        assertEquals("jane.doe@example.org", actualMapUserEntityToUserDtoResult.getEmail());
        assertEquals(stringList, actualMapUserEntityToUserDtoResult.getMobileNumbers());
        assertEquals("Jane", actualMapUserEntityToUserDtoResult.getUserFirstName());
        assertEquals(123L, actualMapUserEntityToUserDtoResult.getId());
        assertEquals("42", actualMapUserEntityToUserDtoResult.getUserId());
        AddressDto address1 = actualMapUserEntityToUserDtoResult.getAddress();
        assertEquals("Oxford", address1.getCity());
        assertEquals("42 Main St", address1.getAddressType());
        assertEquals("42 Main St", address1.getAddressId());
        assertEquals(123L, address1.getId());
        assertEquals("Street", address1.getStreet());
        assertEquals("21654", address1.getZip());
        assertEquals("GB", address1.getCountry());
        assertEquals("MD", address1.getState());
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserEntityToUserDto(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapUserEntityToUserDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapUserEntityToUserDto(MappingConfiguration.java:64)
        //   In order to prevent mapUserEntityToUserDto(User)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapUserEntityToUserDto(User).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapUserEntityToUserDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserEntityToUserDto(User)}
     */
    @Test
    void testMapUserEntityToUserDto4() {
        User user = mock(User.class);
        when(user.getAddress())
                .thenReturn(new Address(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654"));
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getUserFirstName()).thenReturn("Jane");
        when(user.getUserId()).thenReturn("42");
        when(user.getUserLastName()).thenReturn("Doe");
        ArrayList<String> stringList = new ArrayList<>();
        when(user.getMobileNumbers()).thenReturn(stringList);
        when(user.getId()).thenReturn(123L);
        UserDto actualMapUserEntityToUserDtoResult = this.mappingConfiguration.mapUserEntityToUserDto(user);
        assertEquals("Doe", actualMapUserEntityToUserDtoResult.getUserLastName());
        assertEquals("jane.doe@example.org", actualMapUserEntityToUserDtoResult.getEmail());
        assertEquals(stringList, actualMapUserEntityToUserDtoResult.getMobileNumbers());
        assertEquals("Jane", actualMapUserEntityToUserDtoResult.getUserFirstName());
        assertEquals(123L, actualMapUserEntityToUserDtoResult.getId());
        assertEquals("42", actualMapUserEntityToUserDtoResult.getUserId());
        AddressDto address = actualMapUserEntityToUserDtoResult.getAddress();
        assertEquals("Oxford", address.getCity());
        assertEquals("42 Main St", address.getAddressType());
        assertEquals("42 Main St", address.getAddressId());
        assertEquals(123L, address.getId());
        assertEquals("Street", address.getStreet());
        assertEquals("21654", address.getZip());
        assertEquals("GB", address.getCountry());
        assertEquals("MD", address.getState());
        verify(user, atLeast(1)).getAddress();
        verify(user).getEmail();
        verify(user).getUserFirstName();
        verify(user).getUserId();
        verify(user).getUserLastName();
        verify(user).getMobileNumbers();
        verify(user).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserEntityToUserDto(User)}
     */
    @Test
    void testMapUserEntityToUserDto5() {
        User user = mock(User.class);
        when(user.getAddress())
                .thenReturn(new Address(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654"));
        when(user.getEmail()).thenReturn("42");
        when(user.getUserFirstName()).thenReturn("Jane");
        when(user.getUserId()).thenReturn("42");
        when(user.getUserLastName()).thenReturn("Doe");
        ArrayList<String> stringList = new ArrayList<>();
        when(user.getMobileNumbers()).thenReturn(stringList);
        when(user.getId()).thenReturn(123L);
        UserDto actualMapUserEntityToUserDtoResult = this.mappingConfiguration.mapUserEntityToUserDto(user);
        assertEquals("Doe", actualMapUserEntityToUserDtoResult.getUserLastName());
        assertEquals("42", actualMapUserEntityToUserDtoResult.getEmail());
        assertEquals(stringList, actualMapUserEntityToUserDtoResult.getMobileNumbers());
        assertEquals("Jane", actualMapUserEntityToUserDtoResult.getUserFirstName());
        assertEquals(123L, actualMapUserEntityToUserDtoResult.getId());
        assertEquals("42", actualMapUserEntityToUserDtoResult.getUserId());
        AddressDto address = actualMapUserEntityToUserDtoResult.getAddress();
        assertEquals("Oxford", address.getCity());
        assertEquals("42 Main St", address.getAddressType());
        assertEquals("42 Main St", address.getAddressId());
        assertEquals(123L, address.getId());
        assertEquals("Street", address.getStreet());
        assertEquals("21654", address.getZip());
        assertEquals("GB", address.getCountry());
        assertEquals("MD", address.getState());
        verify(user, atLeast(1)).getAddress();
        verify(user).getEmail();
        verify(user).getUserFirstName();
        verify(user).getUserId();
        verify(user).getUserLastName();
        verify(user).getMobileNumbers();
        verify(user).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapUserEntityToUserDto(User)}
     */
    @Test
    void testMapUserEntityToUserDto6() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        User user = mock(User.class);
        when(user.getAddress())
                .thenReturn(new Address(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654"));
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getUserFirstName()).thenReturn("Jane");
        when(user.getUserId()).thenReturn("42");
        when(user.getUserLastName()).thenReturn("Doe");
        when(user.getMobileNumbers()).thenReturn(stringList);
        when(user.getId()).thenReturn(123L);
        UserDto actualMapUserEntityToUserDtoResult = this.mappingConfiguration.mapUserEntityToUserDto(user);
        assertEquals("Doe", actualMapUserEntityToUserDtoResult.getUserLastName());
        assertEquals("jane.doe@example.org", actualMapUserEntityToUserDtoResult.getEmail());
        List<String> mobileNumbers = actualMapUserEntityToUserDtoResult.getMobileNumbers();
        assertEquals(stringList, mobileNumbers);
        assertEquals(1, mobileNumbers.size());
        assertEquals("foo", mobileNumbers.get(0));
        assertEquals("Jane", actualMapUserEntityToUserDtoResult.getUserFirstName());
        assertEquals(123L, actualMapUserEntityToUserDtoResult.getId());
        assertEquals("42", actualMapUserEntityToUserDtoResult.getUserId());
        AddressDto address = actualMapUserEntityToUserDtoResult.getAddress();
        assertEquals("Oxford", address.getCity());
        assertEquals("42 Main St", address.getAddressType());
        assertEquals("42 Main St", address.getAddressId());
        assertEquals(123L, address.getId());
        assertEquals("Street", address.getStreet());
        assertEquals("21654", address.getZip());
        assertEquals("GB", address.getCountry());
        assertEquals("MD", address.getState());
        verify(user, atLeast(1)).getAddress();
        verify(user).getEmail();
        verify(user).getUserFirstName();
        verify(user).getUserId();
        verify(user).getUserLastName();
        verify(user).getMobileNumbers();
        verify(user).getId();
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToAddressDto(Object)}
     */
    @Test
    void testMapObjectToAddressDto() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToAddressDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToAddressDto("Object");
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToAddressDto(Object)}
     */
    @Test
    void testMapObjectToAddressDto2() {
        AddressDto addressDto = new AddressDto(123L, "42 Main St", "42 Main St", "Oxford", "Street", "MD", "GB", "21654");

        assertSame(addressDto, this.mappingConfiguration.mapObjectToAddressDto(addressDto));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToAddressDto(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapObjectToAddressDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapObjectToAddressDto(MappingConfiguration.java:68)
        //   In order to prevent mapObjectToAddressDto(Object)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapObjectToAddressDto(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapObjectToAddressDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToAddressDto(Object)}
     */
    @Test
    void testMapObjectToAddressDto4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToAddressDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToAddressDto(mock(AddressDto.class));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToAddressDto(Object)}
     */
    @Test
    void testMapObjectToAddressDto5() {
        assertNull(this.mappingConfiguration.mapObjectToAddressDto(1));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankAccountDto(Object)}
     */
    @Test
    void testMapObjectToBankAccountDto() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToBankAccountDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToBankAccountDto("Object");
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankAccountDto(Object)}
     */
    @Test
    void testMapObjectToBankAccountDto2() {
        assertNull(this.mappingConfiguration.mapObjectToBankAccountDto(3));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankAccountDto(Object)}
     */
    @Test
    void testMapObjectToBankAccountDto3() {
        BankAccountDto bankAccountDto = new BankAccountDto();
        assertSame(bankAccountDto, this.mappingConfiguration.mapObjectToBankAccountDto(bankAccountDto));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankAccountDto(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapObjectToBankAccountDto4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapObjectToBankAccountDto(MappingConfiguration.java:72)
        //   In order to prevent mapObjectToBankAccountDto(Object)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapObjectToBankAccountDto(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapObjectToBankAccountDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankAccountDto(Object)}
     */
    @Test
    void testMapObjectToBankAccountDto5() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToBankAccountDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToBankAccountDto(mock(BankAccountDto.class));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankOperationDto(Object)}
     */
    @Test
    void testMapObjectToBankOperationDto() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToBankOperationDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToBankOperationDto("Object");
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankOperationDto(Object)}
     */
    @Test
    void testMapObjectToBankOperationDto2() {
        BankOperationDto bankOperationDto = new BankOperationDto(123L, "42", true, true);

        assertSame(bankOperationDto, this.mappingConfiguration.mapObjectToBankOperationDto(bankOperationDto));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankOperationDto(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapObjectToBankOperationDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapObjectToBankOperationDto(MappingConfiguration.java:76)
        //   In order to prevent mapObjectToBankOperationDto(Object)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapObjectToBankOperationDto(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapObjectToBankOperationDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankOperationDto(Object)}
     */
    @Test
    void testMapObjectToBankOperationDto4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToBankOperationDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToBankOperationDto(mock(BankOperationDto.class));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankOperationDto(Object)}
     */
    @Test
    void testMapObjectToBankOperationDto5() {
        assertNull(this.mappingConfiguration.mapObjectToBankOperationDto(1));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToBankOperationDto(Object)}
     */
    @Test
    void testMapObjectToBankOperationDto6() {
        BankOperationDto bankOperationDto = new BankOperationDto(0L, "Bank Account Id", true, true);

        assertSame(bankOperationDto, this.mappingConfiguration.mapObjectToBankOperationDto(bankOperationDto));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToCompanyDto(Object)}
     */
    @Test
    void testMapObjectToCompanyDto() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToCompanyDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToCompanyDto("Object");
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToCompanyDto(Object)}
     */
    @Test
    void testMapObjectToCompanyDto2() {
        CompanyDto companyDto = new CompanyDto(123L, "42", "Company Name", "Domicile", 1, true);

        assertSame(companyDto, this.mappingConfiguration.mapObjectToCompanyDto(companyDto));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToCompanyDto(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapObjectToCompanyDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapObjectToCompanyDto(MappingConfiguration.java:80)
        //   In order to prevent mapObjectToCompanyDto(Object)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapObjectToCompanyDto(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapObjectToCompanyDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToCompanyDto(Object)}
     */
    @Test
    void testMapObjectToCompanyDto4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToCompanyDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToCompanyDto(mock(CompanyDto.class));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToCompanyDto(Object)}
     */
    @Test
    void testMapObjectToCompanyDto5() {
        assertNull(this.mappingConfiguration.mapObjectToCompanyDto(1));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPortfolioDto(Object)}
     */
    @Test
    void testMapObjectToPortfolioDto() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToPortfolioDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToPortfolioDto("Object");
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPortfolioDto(Object)}
     */
    @Test
    void testMapObjectToPortfolioDto2() {
        PortfolioDto portfolioDto = new PortfolioDto();
        assertSame(portfolioDto, this.mappingConfiguration.mapObjectToPortfolioDto(portfolioDto));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPortfolioDto(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapObjectToPortfolioDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapObjectToPortfolioDto(MappingConfiguration.java:84)
        //   In order to prevent mapObjectToPortfolioDto(Object)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapObjectToPortfolioDto(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapObjectToPortfolioDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPortfolioDto(Object)}
     */
    @Test
    void testMapObjectToPortfolioDto4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToPortfolioDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToPortfolioDto(mock(PortfolioDto.class));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPortfolioDto(Object)}
     */
    @Test
    void testMapObjectToPortfolioDto5() {
        assertNull(this.mappingConfiguration.mapObjectToPortfolioDto(1));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPortfolioDto(Object)}
     */
    @Test
    void testMapObjectToPortfolioDto6() {
        PortfolioDto portfolioDto = new PortfolioDto();
        portfolioDto.setId(123L);
        assertSame(portfolioDto, this.mappingConfiguration.mapObjectToPortfolioDto(portfolioDto));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPositionDto(Object)}
     */
    @Test
    void testMapObjectToPositionDto() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToPositionDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToPositionDto("Object");
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPositionDto(Object)}
     */
    @Test
    void testMapObjectToPositionDto2() {
        PositionDto positionDto = new PositionDto();
        assertSame(positionDto, this.mappingConfiguration.mapObjectToPositionDto(positionDto));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPositionDto(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapObjectToPositionDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapObjectToPositionDto(MappingConfiguration.java:88)
        //   In order to prevent mapObjectToPositionDto(Object)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapObjectToPositionDto(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapObjectToPositionDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPositionDto(Object)}
     */
    @Test
    void testMapObjectToPositionDto4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToPositionDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToPositionDto(mock(PositionDto.class));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToPositionDto(Object)}
     */
    @Test
    void testMapObjectToPositionDto5() {
        assertNull(this.mappingConfiguration.mapObjectToPositionDto(1));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToUserDto(Object)}
     */
    @Test
    void testMapObjectToUserDto() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToUserDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToUserDto("Object");
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToUserDto(Object)}
     */
    @Test
    void testMapObjectToUserDto2() {
        UserDto userDto = new UserDto();
        assertSame(userDto, this.mappingConfiguration.mapObjectToUserDto(userDto));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToUserDto(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMapObjectToUserDto3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: source cannot be null
        //       at org.modelmapper.internal.util.Assert.notNull(Assert.java:53)
        //       at org.modelmapper.ModelMapper.map(ModelMapper.java:404)
        //       at com.company.configuration.MappingConfiguration.mapObjectToUserDto(MappingConfiguration.java:92)
        //   In order to prevent mapObjectToUserDto(Object)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   mapObjectToUserDto(Object).
        //   See https://diff.blue/R013 to resolve this issue.

        this.mappingConfiguration.mapObjectToUserDto(null);
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToUserDto(Object)}
     */
    @Test
    void testMapObjectToUserDto4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by mapObjectToUserDto(Object)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.mappingConfiguration.mapObjectToUserDto(mock(UserDto.class));
    }

    /**
     * Method under test: {@link MappingConfiguration#mapObjectToUserDto(Object)}
     */
    @Test
    void testMapObjectToUserDto5() {
        assertNull(this.mappingConfiguration.mapObjectToUserDto(1));
    }
}

