package com.app.codes.concurrent;

import reactor.core.publisher.Flux;

/*

Reactive programming is a paradigm that allows you to build systems that react to changes.
In Java, you can use libraries like Project Reactor or RxJava to implement reactive streams.

Introduction to Reactive Programming
Reactive programming is based on the idea of building asynchronous data streams and reacting to changes in these streams.

Using Project Reactor
 */
public class ReactiveExample {
    public static void main(String[] args) {
        Flux.just("Hello", "World")
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }
}