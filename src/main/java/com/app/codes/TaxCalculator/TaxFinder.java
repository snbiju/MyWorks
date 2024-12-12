package com.app.codes.TaxCalculator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class TaxFinder {
    Map<String,Integer> bandMap= new TreeMap<>();
    int ONE_HUNDRED=100;

   public BigDecimal calculateTax(BigDecimal Salary){
       return null;
   }
    private Integer getTaxRate(BigDecimal salary){
        int first,second=0;
        for (Map.Entry<String,Integer> entry:bandMap.entrySet()
             ) {
            first=Integer.parseInt(entry.getKey().split("-")[0]);
            second=Integer.parseInt(entry.getKey().split("-")[1]);
            if(salary.intValue()>=first && salary.intValue()<=second){
                return bandMap.get(entry.getKey());
            }
        }

        return null;
    }

    private void setBandMap(){
        bandMap.put("1000-10000",0);
        bandMap.put("10001-20000",10);
        bandMap.put("20001-30000",15);
        bandMap.put("30001-40000",20);
        bandMap.put("40001-50000",30);
        bandMap.put("50001-100000",40);

    }
    public static void main(String[] args) {
        TaxFinder finder= new TaxFinder();
        finder.setBandMap();
        System.out.println(finder.getTaxRate(new BigDecimal(20004)));
    }
}
