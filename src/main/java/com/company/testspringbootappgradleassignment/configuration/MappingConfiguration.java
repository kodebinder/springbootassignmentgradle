package com.company.testspringbootappgradleassignment.configuration;

import com.company.testspringbootappgradleassignment.dto.*;
import com.company.testspringbootappgradleassignment.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfiguration {

    public Address mapAddressDtoToAddressEntity(AddressDto addressDto) {
        return new ModelMapper().map(addressDto, Address.class);
    }

    public AddressDto mapAddressEntityToAddressDto(Address address) {
        return new ModelMapper().map(address, AddressDto.class);
    }

    public BankAccount mapBankAccountDtoToBankAccountEntity(BankAccountDto bankAccountDto) {
        return new ModelMapper().map(bankAccountDto, BankAccount.class);
    }

    public BankAccountDto mapBankAccountEntityToBankAccountDto(BankAccount bankAccount) {
        return new ModelMapper().map(bankAccount, BankAccountDto.class);
    }

    public BankOperation mapBankOperationDtoToBankOperationEntity(BankOperationDto bankOperationDto) {
        return new ModelMapper().map(bankOperationDto, BankOperation.class);
    }

    public BankOperationDto mapBankOperationEntityToBankOperationDto(BankOperation bankOperation) {
        return new ModelMapper().map(bankOperation, BankOperationDto.class);
    }

    public Company mapCompanyDtoToCompanyEntity(CompanyDto companyDto) {
        return new ModelMapper().map(companyDto, Company.class);
    }

    public CompanyDto mapCompanyEntityToCompanyDto(Company company) {
        return new ModelMapper().map(company, CompanyDto.class);
    }

    public Portfolio mapPortfolioDtoToPortfolioEntity(PortfolioDto portfolioDto) {
        return new ModelMapper().map(portfolioDto, Portfolio.class);
    }

    public PortfolioDto mapPortfolioEntityToPortfolioDto(Portfolio portfolio) {
        return new ModelMapper().map(portfolio, PortfolioDto.class);
    }

    public Position mapPositionDtoToPositionEntity(PositionDto positionDto) {
        return new ModelMapper().map(positionDto, Position.class);
    }

    public PositionDto mapPositionEntityToPositionDto(Position position) {
        return new ModelMapper().map(position, PositionDto.class);
    }

    public User mapUserDtoToUserEntity(UserDto userDto) {
        return new ModelMapper().map(userDto, User.class);
    }

    public UserDto mapUserEntityToUserDto(User user) {
        return new ModelMapper().map(user, UserDto.class);
    }

    public AddressDto mapObjectToAddressDto(Object object) {
        return new ModelMapper().map(object, AddressDto.class);
    }

    public BankAccountDto mapObjectToBankAccountDto(Object object) {
        return new ModelMapper().map(object, BankAccountDto.class);
    }

    public BankOperationDto mapObjectToBankOperationDto(Object object) {
        return new ModelMapper().map(object, BankOperationDto.class);
    }

    public CompanyDto mapObjectToCompanyDto(Object object) {
        return new ModelMapper().map(object, CompanyDto.class);
    }

    public PortfolioDto mapObjectToPortfolioDto(Object object) {
        return new ModelMapper().map(object, PortfolioDto.class);
    }

    public PositionDto mapObjectToPositionDto(Object object) {
        return new ModelMapper().map(object, PositionDto.class);
    }

    public UserDto mapObjectToUserDto(Object object) {
        return new ModelMapper().map(object, UserDto.class);
    }

}
