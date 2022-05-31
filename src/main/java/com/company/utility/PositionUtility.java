package com.company.utility;

import com.company.dto.Currency;
import com.company.dto.PositionDto;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PositionUtility {

    public PositionUtility(){

    }

    public PositionDto getPositionAtStartOfMonthForAggressivePortfolio() throws ParseException {
        PositionDto position_start_of_month = PositionDto.builder()
                .id(1L)
                .portfolioId("1002")
                .portfolioName("Aggressive Portfolio")
                .currency(Currency.GBP)
                .numberShares(100)
                .positionMarketValue(10000)
                .startDate(getStartDateStartOfMonth())
                .endDate(getEndDateTimeStartOfMonth())
                .build();
        return position_start_of_month;
    }

    public PositionDto getPositionAtEndOfMonthForAggressivePortfolio() throws ParseException {
        PositionDto position_end_of_month = PositionDto.builder()
                .id(2L)
                .portfolioId("1001")
                .portfolioName("Conservative Portfolio")
                .currency(Currency.GBP)
                .numberShares(200)
                .positionMarketValue(20000)
                .startDate(getStartDateEndOfMonth())
                .endDate(getEndDateTimeEndOfMonth())
                .build();
        return position_end_of_month;
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
        PositionDto position_start_of_month = PositionDto.builder()
                .id(1L)
                .portfolioId("1001")
                .portfolioName("Conservative Portfolio")
                .currency(Currency.GBP)
                .numberShares(100)
                .positionMarketValue(10000)
                .startDate(getStartDateStartOfMonth())
                .endDate(getEndDateTimeStartOfMonth())
                .build();
        return position_start_of_month;
    }

    public PositionDto getPositionAtEndOfMonthForConservativePortfolio() throws ParseException {
        PositionDto position_end_of_month = PositionDto.builder()
                .id(2L)
                .portfolioId("1001")
                .portfolioName("Conservative Portfolio")
                .currency(Currency.GBP)
                .numberShares(200)
                .positionMarketValue(20000)
                .startDate(getStartDateStartOfMonth())
                .endDate(getEndDateTimeEndOfMonth())
                .build();
        return position_end_of_month;
    }

}
