package com.company.utility;

import com.company.model.Currency;
import com.company.model.Portfolio;
import com.company.model.Position;
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

    public List<Portfolio> loadPortfolios() throws ParseException {
        List<Portfolio> portfolios = new LinkedList<>();

        Portfolio conservative_portfolio = Portfolio.builder()
                .id(21L)
                .portfolioId("1001")
                .portfolioName("Conservative Portfolio")
                .currency(Currency.GBP)
                .isActive(Boolean.TRUE)
                .fundSize(new BigDecimal(70000))
                .creationDate(getDateForPortfolio())
                .positions(getPositionsForConservativePortfolio())
                .build();

        Portfolio aggressive_portfolio = Portfolio.builder()
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

    public List<Position> getPositionsForConservativePortfolio() throws ParseException {
        List<Position> positions = new LinkedList<>();

        Position position_start_of_month = Position.builder()
                .portfolioId("1001")
                .portfolioName("Conservative Portfolio")
                .currency(Currency.GBP)
                .numberShares(100)
                .positionMarketValue(10000)
                .startDate(getStartDateStartOfMonth())
                .endDate(getEndDateTimeStartOfMonth())
                .build();

        Position position_end_of_month = Position.builder()
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

    public List<Position> getPositionsForAggressivePortfolio() throws ParseException {
        List<Position> positions = new LinkedList<>();

        Position position_start_of_month = Position.builder()
                .portfolioId("1002")
                .portfolioName("Aggressive Portfolio")
                .currency(Currency.GBP)
                .numberShares(100)
                .positionMarketValue(10000)
                .startDate(getStartDateStartOfMonth())
                .endDate(getEndDateTimeStartOfMonth())
                .build();

        Position position_end_of_month = Position.builder()
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
