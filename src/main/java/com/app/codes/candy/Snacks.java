package com.app.codes.candy;

public class Snacks {
    int count;
    double percentage;

    public Snacks(int count, double percentage) {
        this.count = count;
        this.percentage = percentage;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPercentage() {
        return this.percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String toString() {
        return "Snacks{count=" + this.count + ", percentage=" + this.percentage + "}";
    }
}

