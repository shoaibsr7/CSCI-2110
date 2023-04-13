package lab8;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BinarySearchTree<Integer> newBinarySearchTree = new BinarySearchTree<>();
        System.out.print("Enter int or '0':\t");
        int input = in.nextInt();
        newBinarySearchTree.insert(input);

        while (input != 0) {
            System.out.print("Enter int or '0':\t");
            input = in.nextInt();
            if (input != 0) {
                newBinarySearchTree.insert(input);
            }
        }

        System.out.println("The max data value in the BST is: " + newBinarySearchTree.findMax());
        System.out.println("The min data value in the BST is: " + newBinarySearchTree.findMin());
        System.out.print("What key would you like to search for?\t");
        int search = in.nextInt();
        newBinarySearchTree.recursiveSearch(search);
    }
}
