package lab6;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number n: ");
        int n = in.nextInt();
        System.out.println("Enter another number m to find its multiples: ");
        int m = in.nextInt();
        System.out.println("multiples(" + n + ", " + m + ") would print: ");
        multiples(n, m);
    }

    public static void multiples(int n, int m){
        if (n == 0) //base case
            return;
        if(m!=0) //glue case
        {
            multiples(n, m - 1);
            System.out.println(n * m);
        }
    }
}
