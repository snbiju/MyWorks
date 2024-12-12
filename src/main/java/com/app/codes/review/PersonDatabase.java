package com.app.codes.review;

import java.io.IOException;

//E is not used in the interface
// Interface is not used any implementation for database access
public interface PersonDatabase<E> {

    Person[] getAllPersons() throws IOException;

}