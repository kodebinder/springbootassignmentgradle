package com.company.testspringbootappgradleassignment.utility;

import com.company.testspringbootappgradleassignment.constant.Currency;
import com.company.testspringbootappgradleassignment.dto.PortfolioDto;
import com.company.testspringbootappgradleassignment.dto.PositionDto;
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
        PortfolioDto portfolioDto = new PortfolioDto();
        portfolioDto.setId(21L);
        portfolioDto.setPortfolioId("1001");
        portfolioDto.setPortfolioName("Conservative Portfolio");
        portfolioDto.setCurrency(Currency.GBP);
        portfolioDto.setActive(Boolean.TRUE);
        portfolioDto.setFundSize(new BigDecimal(70000));
        portfolioDto.setCreationDate(new SimpleDateFormat("yyyyMMdd").parse("20201230"));
        portfolioDto.setPositions(getPositionsForConservativePortfolio());
        return portfolioDto;
    }

    public PortfolioDto getAggressivePortfolioDetails() throws ParseException {
        PortfolioDto portfolioDto = new PortfolioDto();
        portfolioDto.setId(20L);
        portfolioDto.setPortfolioId("1002");
        portfolioDto.setPortfolioName("Aggressive Portfolio");
        portfolioDto.setCurrency(Currency.USD);
        portfolioDto.setActive(Boolean.TRUE);
        portfolioDto.setFundSize(new BigDecimal(80000));
        portfolioDto.setCreationDate(new SimpleDateFormat("yyyyMMdd").parse("20201230"));
        portfolioDto.setPositions(getPositionsForAggressivePortfolio());
        return portfolioDto;
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
