package lab6;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number for countdown: ");
        int countdown = in.nextInt();
        System.out.println("countDown("+countdown+") would print: ");
        countDown(countdown);
    }
    public static void countDown(int n){
        int m = n;
        if (n == 0 || n < 0) //base case
            System.out.println("BlastOff!");
        if (n > 0) //glue case
        {
            if (m % n == 0) {
                System.out.println(n);
                countDown(n - 2);
            }
        }
    }
}
