package com.company.testspringbootappgradleassignment.utility;

import com.company.testspringbootappgradleassignment.constant.Currency;
import com.company.testspringbootappgradleassignment.dto.PositionDto;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PositionUtility {

    public PositionUtility(){

    }

    public PositionDto getPositionAtStartOfMonthForAggressivePortfolio() throws ParseException {
        PositionDto positionDto = new PositionDto();
        positionDto.setId(1L);
        positionDto.setPortfolioId("1002");
        positionDto.setPortfolioName("Aggressive Portfolio");
        positionDto.setCurrency(Currency.GBP);
        positionDto.setNumberShares(100);
        positionDto.setPositionMarketValue(10000);
        positionDto.setStartDate(getStartDateStartOfMonth());
        positionDto.setEndDate(getEndDateTimeStartOfMonth());
        return positionDto;
    }

    public PositionDto getPositionAtEndOfMonthForAggressivePortfolio() throws ParseException {
        PositionDto positionDto = new PositionDto();
        positionDto.setId(2L);
        positionDto.setPortfolioId("1001");
        positionDto.setPortfolioName("Conservative Portfolio");
        positionDto.setCurrency(Currency.GBP);
        positionDto.setNumberShares(200);
        positionDto.setPositionMarketValue(20000);
        positionDto.setStartDate(getStartDateEndOfMonth());
        positionDto.setEndDate(getEndDateTimeEndOfMonth());
        return positionDto;
    }

    private Date getStartDateStartOfMonth() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20201230");
    }

    private Date getEndDateTimeStartOfMonth() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20211230");
    }

    private Date getStartDateEndOfMonth() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20201230");
    }

    private Date getEndDateTimeEndOfMonth() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20201230");
    }

    public PositionDto getPositionAtStartOfMonthForConservativePortfolio() throws ParseException {
        PositionDto positionDto = new PositionDto();
        positionDto.setId(1L);
        positionDto.setPortfolioId("1001");
        positionDto.setPortfolioName("Conservative Portfolio");
        positionDto.setCurrency(Currency.GBP);
        positionDto.setNumberShares(100);
        positionDto.setPositionMarketValue(10000);
        positionDto.setStartDate(getStartDateStartOfMonth());
        positionDto.setEndDate(getEndDateTimeEndOfMonth());
        return positionDto;
    }

    public PositionDto getPositionAtEndOfMonthForConservativePortfolio() throws ParseException {
        PositionDto positionDto = new PositionDto();
        positionDto.setId(2L);
        positionDto.setPortfolioId("1001");
        positionDto.setPortfolioName("Conservative Portfolio");
        positionDto.setCurrency(Currency.GBP);
        positionDto.setNumberShares(200);
        positionDto.setPositionMarketValue(20000);
        positionDto.setStartDate(getStartDateStartOfMonth());
        positionDto.setEndDate(getEndDateTimeEndOfMonth());
        return positionDto;
    }

}
