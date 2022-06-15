package com.company.testspringbootappgradleassignment.dto;

import com.company.testspringbootappgradleassignment.constant.Currency;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PortfolioDto {
    private long id;
    private boolean isActive;
    private List<PositionDto> positions;
    private BigDecimal fundSize;
    private Date creationDate;
    private Currency currency;
    private String portfolioName;
    private String portfolioId;

    public PortfolioDto(){}

    public PortfolioDto(long id, boolean isActive, List<PositionDto> positions, BigDecimal fundSize, Date creationDate, Currency currency, String portfolioName, String portfolioId) {
        this.id = id;
        this.isActive = isActive;
        this.positions = positions;
        this.fundSize = fundSize;
        this.creationDate = creationDate;
        this.currency = currency;
        this.portfolioName = portfolioName;
        this.portfolioId = portfolioId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<PositionDto> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionDto> positions) {
        this.positions = positions;
    }

    public BigDecimal getFundSize() {
        return fundSize;
    }

    public void setFundSize(BigDecimal fundSize) {
        this.fundSize = fundSize;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortfolioDto that = (PortfolioDto) o;

        if (id != that.id) return false;
        if (isActive != that.isActive) return false;
        if (positions != null ? !positions.equals(that.positions) : that.positions != null) return false;
        if (fundSize != null ? !fundSize.equals(that.fundSize) : that.fundSize != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (currency != that.currency) return false;
        if (portfolioName != null ? !portfolioName.equals(that.portfolioName) : that.portfolioName != null)
            return false;
        return portfolioId != null ? portfolioId.equals(that.portfolioId) : that.portfolioId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (positions != null ? positions.hashCode() : 0);
        result = 31 * result + (fundSize != null ? fundSize.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (portfolioName != null ? portfolioName.hashCode() : 0);
        result = 31 * result + (portfolioId != null ? portfolioId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PortfolioDto{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", positions=" + positions +
                ", fundSize=" + fundSize +
                ", creationDate=" + creationDate +
                ", currency=" + currency +
                ", portfolioName='" + portfolioName + '\'' +
                ", portfolioId='" + portfolioId + '\'' +
                '}';
    }
}
