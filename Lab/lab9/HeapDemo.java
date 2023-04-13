package lab9;

import java.util.Scanner;

public class HeapDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Heap<Integer> myHeap = new Heap<Integer>();

        System.out.println("Enter a series of positive integers (end with -1):\t");
        int input = in.nextInt();
        while (input != -1) {
            myHeap.add(input);
            input = in.nextInt();
        }

        System.out.print("The heap is:\t");
        myHeap.enumerate();

        System.out.print("The minimum key is:\t" + myHeap.findMin());

        System.out.print("\nEnter a key to be replaced:\t");
        int replace = in.nextInt();

        if (myHeap.find(replace) == 0){
            System.out.println("Key "+ replace +" not found.");
            return;
        }
        else {
            System.out.print("Enter the new key:\t");
            int newKey = in.nextInt();

            myHeap.replace(replace,newKey);
            System.out.print("The new heap is:\t");
            myHeap.enumerate();
        }
    }
}
