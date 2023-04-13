/**
 * Prime Solution
 * This class tests the code for Lab2: Exercise1. It calls a method to
 * calculate the nth prime and prints information about running time.
 */
import java.util.*;
public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long number = in.nextInt();

        while (number != 0) {
            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis();      // Method to measure the elapsed time (start time - end time)

            long prime = nthPrime(number);
            System.out.print(number + " " + prime + " ");

            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;         // Calculating execution time

            System.out.println(executionTime);
            number = in.nextInt();                               // Next number
        }
    }

    public static long nthPrime(long number) {
        int nth = 0;       // to store the nth prime number
        int counter = 0;   // counter keeps a track of count that should be always less than the number to end the loop

        while (counter < number) {
            nth++;       // prime number position at that moment
            int i;
            for (i = 2; i <= nth; i++) {     // For all numbers from 2 till nth (2 since it's the first prime, nth=1)
                if (nth % i == 0) {
                    break;
                }
            }
            if (i == nth) {                 // If i = nth, count the number
                counter += 1;
            }
        }
        return nth;
    }
}