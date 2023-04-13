package lab6;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a positive integer n as a parameter and calculate the sum of the squares of all" +
                " digits 1 through n: ");
        int numberToSquare = in.nextInt();
        System.out.println("squares("+numberToSquare+") would return: ");
        System.out.println(squares(numberToSquare));
    }


    public static int squares(int n){
        if(n==1) //BASE CASE
        {
            return 1;
        }
        if(n>1) //GLUE CASE
        {
            return (n*n)+squares(n-1);
        }
        return -1;
    }
}
