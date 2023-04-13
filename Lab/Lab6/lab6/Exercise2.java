package lab6;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number for countdown: ");
        int countdown = in.nextInt();
        System.out.println("countDown("+countdown+") would print: ");
        countDown(countdown);
    }
    public static void countDown(int n){
        if (n == 0) //base case
            System.out.println("BlastOff!");
        if (n > 0) //glue case
        {
            System.out.println(n);
            countDown(n - 1);
        }
    }
}
