package com.app.test.TaxCalculator;

import com.app.test.TaxCalculator.domain.TaxRate;
import com.app.test.TaxCalculator.exception.OutOfRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {
TaxCalculator taxCalculator;

@BeforeEach
public void setUp(){
    taxCalculator = new TaxCalculator();
    List<TaxRate> taxRates = new ArrayList<>();
    taxRates.add(new TaxRate(new BigDecimal("0"),new BigDecimal("11000"),new BigDecimal("0")));
    taxRates.add(new TaxRate(new BigDecimal("11001"),new BigDecimal("20000"),new BigDecimal("10")));
    taxRates.add(new TaxRate(new BigDecimal("20001"),new BigDecimal("30000"),new BigDecimal("15")));
    taxRates.add(new TaxRate(new BigDecimal("30001"),new BigDecimal("40000"),new BigDecimal("20")));
    taxRates.add(new TaxRate(new BigDecimal("40001"),new BigDecimal("50000"),new BigDecimal("25")));
    taxRates.add(new TaxRate(new BigDecimal("50001"),new BigDecimal("100000"),new BigDecimal("30")));
    taxRates.add(new TaxRate(new BigDecimal("100001"),new BigDecimal("0"),new BigDecimal("40")));
    taxCalculator.taxRates.addAll(taxRates);
}
    @Test
    public void calculateTaxWithNoTaxPayment() throws OutOfRangeException{
         assertEquals(taxCalculator.calculateTax(new BigDecimal("1000")),new BigDecimal("0"));
    }

    @Test
    public void calculateTaxWithTaxPayment() throws OutOfRangeException{
        assertEquals(taxCalculator.calculateTax(new BigDecimal("15000")),new BigDecimal("400"));
    }
    @Test
    public void calculateTaxWithTaxPayment65000() throws OutOfRangeException{
        assertEquals(new BigDecimal("11400"),taxCalculator.calculateTax(new BigDecimal("65000")));
    }

    @Test
    public void calculateTaxWithTaxPayment100000() throws OutOfRangeException{
        assertEquals(new BigDecimal("37900"),taxCalculator.calculateTax(new BigDecimal("140000")));
    }

    @Test
    public void calculateTaxWithNegativeValue(){
        Exception exception = assertThrows(OutOfRangeException.class,()->taxCalculator.calculateTax(new BigDecimal("-1")));
        String expected = "Out of Range";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }


}