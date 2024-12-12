package com.app.test.ubs;


class Ex0 extends Exception{ }
class Ex1 extends Ex0{}
public class ExceTest {
    public static void main(String[] args) {
        try {
            throw new Ex1();
        }catch (Ex0 ex0){
            System.out.println("Ex0 caught");
        }
        catch (Exception e){
            System.out.println("Exception caught");
        }
    }
}
