package lab6;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number to print vertically: ");
        int integerToPrint = in.nextInt();
        System.out.println("writeVertical("+integerToPrint+") would return: ");
        writeVertical(integerToPrint);
    }


    public static void writeVertical(int n){
        String number = String.valueOf(n);

        if(n==0) //base case
            return;

        if(n>0) //glue case
        {
            char sub = number.charAt(0); //0
            System.out.println(sub);

            String temporary = number.substring(1);
            if(!temporary.equalsIgnoreCase("")) //store the substring from 1 till end into a new variable and
                //keep calling writeVertical until we come across empty string
            {
                int input = Integer.parseInt(temporary);
                writeVertical(input);
            }
        }
    }
}
