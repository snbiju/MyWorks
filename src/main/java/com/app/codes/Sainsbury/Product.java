package com.app.codes.Sainsbury;

public class Product {

    private String product_uid;
    private String product_type;
    private String name;
    private String full_url;
    private double unit_price;
    private String unit_price_measure;
    private int unit_price_measure_amount;

    public String getProduct_uid() {
        return product_uid;
    }

    public void setProduct_uid(String product_uid) {
        this.product_uid = product_uid;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getUnit_price_measure() {
        return unit_price_measure;
    }

    public void setUnit_price_measure(String unit_price_measure) {
        this.unit_price_measure = unit_price_measure;
    }

    public int getUnit_price_measure_amount() {
        return unit_price_measure_amount;
    }

    public void setUnit_price_measure_amount(int unit_price_measure_amount) {
        this.unit_price_measure_amount = unit_price_measure_amount;
    }


}
