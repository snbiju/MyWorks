package com.app.codes.interview;



import java.lang.reflect.Field;

public class Test {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


      //  Integer a=100,b=100,c=1000,d=1000;
      //  System.out.println(a==b);
      //  System.out.println(c==d);
       // Integer i = Integer.valueOf(100);

        Class cache = Integer.class.getDeclaredClasses()[0]; //1
        Field myCache = cache.getDeclaredField("cache"); //2
        myCache.setAccessible(true);//3

        Integer[] newCache = (Integer[]) myCache.get(cache); //4
        newCache[132] = newCache[133]; //5

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b); //
    }

}
