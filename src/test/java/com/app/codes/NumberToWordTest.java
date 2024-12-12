package com.app.codes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberToWordTest {
    NumberToWord numberToWord;

    @BeforeEach
    public void setUp() {
        numberToWord = new NumberToWord();
    }
    @Test
    public void whenEnter100thenReturnHundred() throws InvalidNumberException {
      String word=  numberToWord.getNumberInWord(100);
        assertEquals("Hundred",word.trim());
    }
    @Test
    public void whenEnter10034thenReturnTenthoundThirtyFour() throws InvalidNumberException {
        String word=  numberToWord.getNumberInWord(10034);
        assertEquals("Ten Thousand Thirty Four",word.trim());
    }
    @Test
    public void whenEnter100034thenReturnOneLakhsThirtyFour() throws InvalidNumberException {
        String word=  numberToWord.getNumberInWord(100034);
        assertEquals("One Lakhs Thirty Four",word.trim());
    }
    @Test
    public void whenEnter1000034thenReturnOneMillionThirtyFour() throws InvalidNumberException {
        String word=  numberToWord.getNumberInWord(1000034);
        assertEquals("One Million Thirty Four",word.trim());
    }

    @Test
    public void whenEnterNegativeNumberThenExceptionWillbeThrown() {
        Exception exception=assertThrows(InvalidNumberException.class,()->numberToWord.getNumberInWord(-1));
        String expected = "Negative Number Not Allowed";
        assertEquals(expected,exception.getMessage());


    }
}