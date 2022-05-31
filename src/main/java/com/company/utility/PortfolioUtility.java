package com.company.utility;

import com.company.dto.Currency;
import com.company.dto.PortfolioDto;
import com.company.dto.PositionDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class PortfolioUtility {

    public PortfolioUtility() {
    }

    public List<PortfolioDto> loadPortfolios() throws ParseException {
        List<PortfolioDto> portfolios = new LinkedList<>();

        PortfolioDto conservative_portfolio = PortfolioDto.builder()
                .id(21L)
                .portfolioId("1001")
                .portfolioName("Conservative Portfolio")
                .currency(Currency.GBP)
                .isActive(Boolean.TRUE)
                .fundSize(new BigDecimal(70000))
                .creationDate(getDateForPortfolio())
                .positions(getPositionsForConservativePortfolio())
                .build();

        PortfolioDto aggressive_portfolio = PortfolioDto.builder()
                .id(20L)
                .portfolioId("1002")
                .portfolioName("Aggressive Portfolio")
                .currency(Currency.USD)
                .isActive(Boolean.TRUE)
                .fundSize(new BigDecimal(80000))
                .creationDate(getDateForPortfolio())
                .positions(getPositionsForAggressivePortfolio())
                .build();

        portfolios.add(conservative_portfolio);
        portfolios.add(aggressive_portfolio);

        return portfolios;
    }

    public Date getDateForPortfolio() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20201230");
    }

    public List<PositionDto> getPositionsForConservativePortfolio() throws ParseException {
        List<PositionDto> positions = new LinkedList<>();

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

        positions.add(position_start_of_month);
        positions.add(position_end_of_month);

        return positions;
    }

    public Date getStartDateStartOfMonth() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20201230");
    }

    public Date getEndDateTimeStartOfMonth() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20211230");
    }

    public Date getStartDateEndOfMonth() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20201230");
    }

    public Date getEndDateTimeEndOfMonth() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20201230");
    }

    public List<PositionDto> getPositionsForAggressivePortfolio() throws ParseException {
        List<PositionDto> positions = new LinkedList<>();

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

        positions.add(position_start_of_month);
        positions.add(position_end_of_month);

        return positions;
    }
}
