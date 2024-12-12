package com.app.codes;


@FunctionalInterface
interface Product {

    float Mul(float x, float y);

}

public class LambdaMP {

    public static void main(String[] args) {

        Product Mul1 = (x, y) -> (x * y);

        System.out.println(Mul1.Mul(2, 5));

        Product Mul2 = (float x, float y) -> (x * y);

        System.out.println(Mul2.Mul(100, 200));
        Product prod =(x,y)->(x-y);
        System.out.println(prod.Mul(5,2));

    }

}