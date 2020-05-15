package com.sage.app;
import java.util.*;

/**
 * FizzBuzz
 */
public class App 
{
    public static void main( String[] args ) {}

    public void fizzBuzz(int start, int end) {
        
        // Define FizzBuzz numbers
        String luckyVal = "3";
        int fizzVal = 3;
        int buzzVal = 5;

        // Define FizzBuzz text (so compiler can pick up typos)
        String fizz = "fizz";
        String buzz = "buzz";
        String fizzbuzz = "fizzbuzz";
        String lucky = "lucky";
        String integer = "integer";
        String[] order = {fizz, buzz, fizzbuzz, lucky, integer};

        // Define FizzBuzz ledger
        Hashtable<String, Integer> totals = new Hashtable<String, Integer>();
        for (int i = 0; i < order.length; i++ ) {
            totals.put(order[i], 0);
        }

        if (end < start) {
            throw new IllegalArgumentException();
        }

        // Define FizzBuzz logic
        String output;
        boolean isInteger = false;
        for ( int i = start; i <= end; i++ ) {
            if (Integer.toString(i).contains(luckyVal)) {
                output = lucky;
            } else if ( i % fizzVal == 0 && i % buzzVal == 0) {
                output = fizzbuzz;
            } else if ( i % buzzVal == 0 ) {
                output = buzz;
            } else if ( i % fizzVal == 0 ) {
                output = fizz;
            } else {
                output = String.valueOf(i);
                isInteger = true;
            }

            /*
            * Add a tally to the ledger here so we don't type the same
            * line in each conditional above.
            */
            if (isInteger) {
                totals.put(integer, totals.get(integer) + 1);
            } else {
                totals.put(output, totals.get(output) + 1);
            }
            isInteger = false;

            System.out.print(output + " ");
        }

        // Print ledger
        System.out.println();
        for (int i = 0; i < order.length; i++ ) {
            System.out.println(order[i] + ": " + totals.get(order[i]));
        }
    }
}
