package com.app.codes.TaxCalculator.domain;

import java.math.BigDecimal;

public class TaxRate {
    private final BigDecimal minSalaryRange;
    private final BigDecimal maxSalaryRange;
    private final BigDecimal taxBandAmount;

    public TaxRate(BigDecimal minSalaryRange, BigDecimal maxSalaryRange, BigDecimal taxBandAmount) {
        this.minSalaryRange = minSalaryRange;
        this.maxSalaryRange = maxSalaryRange;
        this.taxBandAmount = taxBandAmount;
    }

    public BigDecimal getMinSalaryRange() {
        return minSalaryRange;
    }

    public BigDecimal getMaxSalaryRange() {
        return maxSalaryRange;
    }

    public BigDecimal getTaxBandAmount() {
        return taxBandAmount;
    }
}
