package com.app.test.review;

// Since this object is handling collection framework, should overrride equals() and hashcode() methods.
class Person {

    private final int age;
    private final String firstName;
    private final String lastName;
    String gender;  // There is no option given for setting the gender

    public Person(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public int getAge() {
        return age;
    }
   //equals() method should include all properties for object comparisons - Else this will cause improper output.
   // A NullPointerException could be thrown if obj is nullable here

    //This class override equals() and should therefore also override hashCode()
    @Override
    public boolean equals(Object obj) {
        return this.lastName == ((Person)obj).lastName;
    }

}

