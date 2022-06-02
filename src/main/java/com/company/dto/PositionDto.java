package com.company.dto;

import com.company.constant.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {
    private long id;
    private int numberShares;
    private int positionMarketValue;
    private Date endDate;
    private Date startDate;
    private Currency currency;
    private String portfolioId;
    private String portfolioName;
}
