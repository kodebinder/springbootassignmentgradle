package com.company.configuration;

import com.company.dto.*;
import com.company.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfiguration {

    private final ModelMapper modelMapper;

    public MappingConfiguration(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public Address mapAddressDtoToAddressEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }

    public AddressDto mapAddressEntityToAddressDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    public BankAccount mapBankAccountDtoToBankAccountEntity(BankAccountDto bankAccountDto) {
        return modelMapper.map(bankAccountDto, BankAccount.class);
    }

    public BankAccountDto mapBankAccountEntityToBankAccountDto(BankAccount bankAccount) {
        return modelMapper.map(bankAccount, BankAccountDto.class);
    }

    public Company mapCompanyDtoToCompanyEntity(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }

    public CompanyDto mapCompanyEntityToCompanyDto(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }

    public Portfolio mapPortfolioDtoToPortfolioEntity(PortfolioDto portfolioDto) {
        return modelMapper.map(portfolioDto, Portfolio.class);
    }

    public PortfolioDto mapPortfolioEntityToPortfolioDto(Portfolio portfolio) {
        return modelMapper.map(portfolio, PortfolioDto.class);
    }

    public Position mapPositionDtoToPositionEntity(PositionDto positionDto) {
        return modelMapper.map(positionDto, Position.class);
    }

    public PositionDto mapPositionEntityToPositionDto(Position position) {
        return modelMapper.map(position, PositionDto.class);
    }

    public User mapUserDtoToUserEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public UserDto mapUserEntityToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

}
