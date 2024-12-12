package com.app.test.concurrent;

import reactor.core.publisher.Flux;

/*
Real-life Example: Real-time Data Processing in a Stock Trading Application

Reactive streams can be used to process real-time stock market data, allowing applications to react to price changes and execute trades automatically.
 */
public class StockTradingExample {
    public static void main(String[] args) {
        Flux.just(100, 102, 101, 103, 105)
                .filter(price -> price > 102)
                .subscribe(price -> System.out.println("Trade executed at price: " + price));
    }
}