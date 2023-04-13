/**
 * Initially we create a maxHeap in which the node at X is greater than the children
 * we destroy that heap and print the list in descending order using the deleteMax method in Heap class
 */
package lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        Heap<String> myHeap = new Heap<String>();
        System.out.print("Enter the name of the text file:\t");
        String filename = in.nextLine();

//I've set the parent file path so that the user can simply type in the file name
        File file = new File("src/lab9/",filename);
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext()){
            myHeap.add(inputFile.next());
        }
        inputFile.close();

        System.out.println("List in the file stored in heap:");
        myHeap.enumerate();

        System.out.println("Here’s the list sorted in descending order:");
        while (!myHeap.isEmpty()){
            String max = myHeap.deleteMax();
            System.out.println(max);
        }
    }
}
