package com.app.codes.TaxCalculator;

import com.app.codes.TaxCalculator.domain.TaxRate;
import com.app.codes.TaxCalculator.exception.OutOfRangeException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TaxCalculator {
    List<TaxRate> taxRates = new ArrayList<>();
    Map<BigDecimal,BigDecimal> bandMap= new TreeMap<>();
    BigDecimal OUT_OFF_RANGE=new BigDecimal("-1");
    BigDecimal ONE_HUNDRED=new BigDecimal("100");

    public BigDecimal calculateTax(BigDecimal salary) throws OutOfRangeException {
        BigDecimal totalTax = new BigDecimal("0");
        BigDecimal sal = new BigDecimal("0");
        if(salary.intValue()<0){
            throw  new OutOfRangeException("Out of Range");
        }
        BigDecimal taxRate= getTaxRate(salary);
        if(taxRate.intValue()==-1){
            throw new OutOfRangeException("Out of Range");
        }
        for (Map.Entry<BigDecimal,BigDecimal> entry:bandMap.entrySet()
             ) {
            totalTax =totalTax.add(entry.getKey().subtract(sal).multiply(entry.getValue()).divide(ONE_HUNDRED, RoundingMode.UP).setScale(0,RoundingMode.UP));
            sal=entry.getKey();
        }
        salary = salary.subtract(sal);
        totalTax=totalTax.add(salary.multiply(taxRate).divide(ONE_HUNDRED,RoundingMode.UP).setScale(0,RoundingMode.UP));
        return totalTax;
    }

    private BigDecimal getTaxRate(BigDecimal salary){
        for (TaxRate rate:taxRates
             ) {
            if(salary.intValue()<=rate.getMaxSalaryRange().intValue() && salary.intValue()>=rate.getMinSalaryRange().intValue())
                return rate.getTaxBandAmount();
            bandMap.put(rate.getMaxSalaryRange(),rate.getTaxBandAmount());
            if(salary.intValue()>=rate.getMinSalaryRange().intValue() && rate.getMaxSalaryRange().intValue()==0){
                bandMap.put(rate.getMaxSalaryRange(),rate.getTaxBandAmount());
                return rate.getTaxBandAmount();
            }
        }
        return OUT_OFF_RANGE;
    }
}
