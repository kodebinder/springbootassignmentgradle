package com.company.testspringbootappgradleassignment.entity;

import java.util.Date;

public class Position {
    private long id;
    private int numberShares;
    private int positionMarketValue;
    private Date endDate;
    private Date startDate;
    private Currency currency;
    private String portfolioId;
    private String portfolioName;

    public Position(){}

    public Position(long id, int numberShares, int positionMarketValue, Date endDate, Date startDate, Currency currency, String portfolioId, String portfolioName) {
        this.id = id;
        this.numberShares = numberShares;
        this.positionMarketValue = positionMarketValue;
        this.endDate = endDate;
        this.startDate = startDate;
        this.currency = currency;
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberShares() {
        return numberShares;
    }

    public void setNumberShares(int numberShares) {
        this.numberShares = numberShares;
    }

    public int getPositionMarketValue() {
        return positionMarketValue;
    }

    public void setPositionMarketValue(int positionMarketValue) {
        this.positionMarketValue = positionMarketValue;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (id != position.id) return false;
        if (numberShares != position.numberShares) return false;
        if (positionMarketValue != position.positionMarketValue) return false;
        if (endDate != null ? !endDate.equals(position.endDate) : position.endDate != null) return false;
        if (startDate != null ? !startDate.equals(position.startDate) : position.startDate != null) return false;
        if (currency != position.currency) return false;
        if (portfolioId != null ? !portfolioId.equals(position.portfolioId) : position.portfolioId != null)
            return false;
        return portfolioName != null ? portfolioName.equals(position.portfolioName) : position.portfolioName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + numberShares;
        result = 31 * result + positionMarketValue;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (portfolioId != null ? portfolioId.hashCode() : 0);
        result = 31 * result + (portfolioName != null ? portfolioName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", numberShares=" + numberShares +
                ", positionMarketValue=" + positionMarketValue +
                ", endDate=" + endDate +
                ", startDate=" + startDate +
                ", currency=" + currency +
                ", portfolioId='" + portfolioId + '\'' +
                ", portfolioName='" + portfolioName + '\'' +
                '}';
    }
}
