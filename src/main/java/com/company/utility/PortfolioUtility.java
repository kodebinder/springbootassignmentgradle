package com.company.utility;

import com.company.constant.Currency;
import com.company.dto.PortfolioDto;
import com.company.dto.PositionDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Component
public class PortfolioUtility {

    private final PositionUtility positionUtility;

    public PortfolioUtility(final PositionUtility positionUtility) {
        this.positionUtility = positionUtility;
    }

    public List<PortfolioDto> loadPortfolios() throws ParseException {
        List<PortfolioDto> portfolios = new LinkedList<>();
        portfolios.add(getConservativePortfolioDetails());
        portfolios.add(getAggressivePortfolioDetails());
        return portfolios;
    }

    public PortfolioDto getConservativePortfolioDetails() throws ParseException {
        PortfolioDto conservative_portfolio = PortfolioDto.builder()
                .id(21L)
                .portfolioId("1001")
                .portfolioName("Conservative Portfolio")
                .currency(Currency.GBP)
                .isActive(Boolean.TRUE)
                .fundSize(new BigDecimal(70000))
                .creationDate(new SimpleDateFormat("yyyyMMdd").parse("20201230"))
                .positions(getPositionsForConservativePortfolio())
                .build();
        return conservative_portfolio;
    }

    public PortfolioDto getAggressivePortfolioDetails() throws ParseException {
        PortfolioDto aggressive_portfolio = PortfolioDto.builder()
                .id(20L)
                .portfolioId("1002")
                .portfolioName("Aggressive Portfolio")
                .currency(Currency.USD)
                .isActive(Boolean.TRUE)
                .fundSize(new BigDecimal(80000))
                .creationDate(new SimpleDateFormat("yyyyMMdd").parse("20201230"))
                .positions(getPositionsForAggressivePortfolio())
                .build();
        return aggressive_portfolio;
    }

    public List<PositionDto> getPositionsForConservativePortfolio() throws ParseException {
        List<PositionDto> positions = new LinkedList<>();
        positions.add(positionUtility.getPositionAtStartOfMonthForConservativePortfolio());
        positions.add(positionUtility.getPositionAtEndOfMonthForConservativePortfolio());
        return positions;
    }

    public List<PositionDto> getPositionsForAggressivePortfolio() throws ParseException {
        List<PositionDto> positions = new LinkedList<>();
        positions.add(positionUtility.getPositionAtStartOfMonthForAggressivePortfolio());
        positions.add(positionUtility.getPositionAtEndOfMonthForAggressivePortfolio());
        return positions;
    }

}
