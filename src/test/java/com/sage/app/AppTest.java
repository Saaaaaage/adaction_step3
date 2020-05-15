package com.sage.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.*;

public class AppTest 
{
    /*
    * Pulled from StackOverflow
    * https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    // End StackOverflow pull
    


    @Test(expected = IllegalArgumentException.class)
    public void testFizzBuzzReverseRange() {
        // Given
        App appTest = new App();

        // When
        int testStart = 20;
        int testEnd = 1;
        appTest.fizzBuzz(testStart, testEnd);

        // Then
        // Expect IllegalArgumentException
    }

    @Test
    public void testFizzBuzzNumber() throws Throwable {
        // Given
        App appTest = new App();

        // When
        int testStart = 1;
        int testEnd = 1;
        appTest.fizzBuzz(testStart, testEnd);

        // Then
        assertEquals("1 \nfizz: 0\nbuzz: 0\nfizzbuzz: 0\nlucky: 0\ninteger: 1\n", outContent.toString());
    }

    @Test
    public void testFizzBuzzLucky() throws Throwable {
        // Given
        App appTest = new App();

        // When
        int testStart = 37;
        int testEnd = 37;
        appTest.fizzBuzz(testStart, testEnd);

        // Then
        assertEquals("lucky \nfizz: 0\nbuzz: 0\nfizzbuzz: 0\nlucky: 1\ninteger: 0\n", outContent.toString());
    }

    @Test
    public void testFizzBuzzLuckyOverride() throws Throwable {
        // Given
        App appTest = new App();

        // When
        int testStart = 3;
        int testEnd = 3;
        appTest.fizzBuzz(testStart, testEnd);

        // Then
        assertEquals("lucky \nfizz: 0\nbuzz: 0\nfizzbuzz: 0\nlucky: 1\ninteger: 0\n", outContent.toString());
    }

    @Test
    public void testFizzBuzzBuzz() throws Throwable {
        // Given
        App appTest = new App();

        // When
        int testStart = 55;
        int testEnd = 55;
        appTest.fizzBuzz(testStart, testEnd);

        // Then
        assertEquals("buzz \nfizz: 0\nbuzz: 1\nfizzbuzz: 0\nlucky: 0\ninteger: 0\n", outContent.toString());
    }

    @Test
    public void testFizzBuzzFizz() throws Throwable {
        // Given
        App appTest = new App();

        // When
        int testStart = 24;
        int testEnd = 24;
        appTest.fizzBuzz(testStart, testEnd);

        // Then
        assertEquals("fizz \nfizz: 1\nbuzz: 0\nfizzbuzz: 0\nlucky: 0\ninteger: 0\n", outContent.toString());
    }

    @Test
    public void testFizzBuzzFizzBuzz() throws Throwable {
        // Given
        App appTest = new App();

        // When
        int testStart = 75;
        int testEnd = 75;
        appTest.fizzBuzz(testStart, testEnd);

        // Then
        assertEquals("fizzbuzz \nfizz: 0\nbuzz: 0\nfizzbuzz: 1\nlucky: 0\ninteger: 0\n", outContent.toString());
    }

    @Test
    public void testFizzBuzzMulti() throws Throwable {
        // Given
        App appTest = new App();

        // When
        int testStart = 1;
        int testEnd = 20;
        appTest.fizzBuzz(testStart, testEnd);

        // Then
        String expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz \nfizz: 4\nbuzz: 3\nfizzbuzz: 1\nlucky: 2\ninteger: 10\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void testFizzBuzzNegative() throws Throwable {
        // Given
        App appTest = new App();

        // When
        int testStart = -20;
        int testEnd = -1;
        appTest.fizzBuzz(testStart, testEnd);

        // Then
        String expected = "buzz -19 fizz -17 -16 fizzbuzz -14 lucky fizz -11 buzz fizz -8 -7 fizz buzz -4 lucky -2 -1 \nfizz: 4\nbuzz: 3\nfizzbuzz: 1\nlucky: 2\ninteger: 10\n";
        assertEquals(expected, outContent.toString());
    }
}
