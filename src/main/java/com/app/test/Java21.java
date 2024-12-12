package com.app.test;

public class Java21 {

   int x,y;
    record Point(int x, int y) {
    }

    public void print(Object o) {

        switch (o) {

            case Point p 		-> System.out.printf("o is a position: %d/%d%n", p.x(), p.y());
            case String s   -> System.out.printf("o is a string: %s%n", s);
            default         -> System.out.printf("o is something else: %s%n", o);
        }
    }
    public static void main(String[] args) {
      Java21 java21= new Java21();
      Point point = new Point(3,4);
      java21.print(point);
      java21.print("Hello");
    }
}
