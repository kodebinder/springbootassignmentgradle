package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDto {
    private long id;
    private boolean isActive;
    private List<PositionDto> positions;
    private BigDecimal fundSize;
    private Date creationDate;
    private Currency currency;
    private String portfolioName;
    private String portfolioId;
}
