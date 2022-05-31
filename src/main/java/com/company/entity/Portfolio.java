package com.company.entity;

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
public class Portfolio {
    private long id;
    private boolean isActive;
    private List<Position> positions;
    private BigDecimal fundSize;
    private Date creationDate;
    private Currency currency;
    private String portfolioName;
    private String portfolioId;
}
