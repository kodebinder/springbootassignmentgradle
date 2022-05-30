package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private long id;
    private int numberShares;
    private int positionMarketValue;
    private Date endDate;
    private Date startDate;
    private Currency currency;
    private String portfolioId;
    private String portfolioName;
}
