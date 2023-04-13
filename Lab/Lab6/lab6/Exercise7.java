package lab6;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter an integer to specify the number of discs in the tower of Hanoi: ");
        int numberOfDiscs = in.nextInt();

        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();

        System.out.println(solve(numberOfDiscs)); // 8, 12, 16, 20, 24, 28, and 32

        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("The execution time for the solve method was: " + executionTime + "ms");
    }

    public static long solve(int n){
        return solve(n, n-2, n, n-1);
    }

    private static long x = 0;
    public static long solve(int n, int start, int end, int temporary){
        if(n>0){
            solve(n-1, start, temporary, end);
            solve(n-1, temporary, end, start);
            x++;
        }
        return x;
    }
}
