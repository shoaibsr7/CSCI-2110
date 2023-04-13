package lab6;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Factorial
        System.out.println("first 10 factorials are: ");
        for (int i = 1; i <= 10; i++) {
            System.out.println(factorial(i));
        }

        System.out.println();
        //Fibonacci
        System.out.println("Fibonacci numbers" + "\nfirst 20 numbers in the Fibonacci series are: ");
        for (int i = 0; i < 20; i++) {
            System.out.println(fib(i));
        }

        System.out.println();
        //Power
        System.out.println("Power of a number" + "\nEnter a positive integer x to the base n: ");
        int x = in.nextInt();
        System.out.println("Enter another positive integer to be the exponent: ");
        int n = in.nextInt();
        System.out.println(x + " to the power of " + n + " is " + power(x,n) );
    }

    public static int factorial (int n){
        if (n == 0)
        return  1; //base case
        if (n > 0)
        return n * factorial(n-1); //glue case
        return -1;
    }

    public static int fib(int n){
        if (n==0)
            return 0; //base case
        if (n==1)
            return 1; //base case
        if (n>1)
            return fib(n-1) + fib(n-2); //glue case
        return -1;
    }

    public static int power(int x, int n){
        if (n == 0)
            return 1; //base case
        if (n>0)
            return power(x,n-1)*x; //glue case
        return -1;
    }
}
