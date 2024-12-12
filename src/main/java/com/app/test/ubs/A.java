package com.app.test.ubs;

public class A {
    public static void main(String[] args) {
       // B b = new B();
     //   System.out.println(b instanceof B);
      //  System.out.println(b instanceof B && (!(b instanceof A)));
      //  System.out.println(b instanceof B && (!(b instanceof C)));

        boolean a= false;
        if (a=true){
            System.out.println("hello");
        }else{
            System.out.println("good bye");
        }

        Float f1 = new Float("3.0");
        int x = f1.intValue();
        byte b = f1.byteValue();
        double d = f1.doubleValue();
        System.out.println(x+b+d);

    }
}
class B extends A{}
class C extends B{}
