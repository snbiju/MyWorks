package com.app.test.ubs;

class Constructor{
    static String str;
    public void Constructor(){
        System.out.println("In Constructor");
        str = "Hello world";
    }
    public static void main(String [] arg){
        Constructor c = new Constructor();
        System.out.println(str);
    }
}


