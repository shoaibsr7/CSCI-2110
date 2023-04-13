/**
 * This program:
 * 1.   Prompt the user to enter two text files, each consisting of words (names) and create two ordered lists.
 * 2.   Creates and returns a third list that is an ordered list with the items in list1 and list2 that is a MERGER of
 *      the two ordered lists. Using the two-finger walking algorithm
 * 3.   Creates and returns a third list that is an ordered list with the items in list1 that are NOT in list2.
 * 4.   Creates and returns a third list that is an ordered list with the items that are COMMON in list1 and list2.
 *
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 **/
package Assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OrderedListDemo {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner((System.in));

//        input file name
        System.out.println("Enter the first filename to read from: ");
        String filename1 = in.nextLine();

//        store file
        File file1 = new File(filename1);

        OrderedList<String> names1 = new OrderedList<String>();
        Scanner inputFile1 = new Scanner(file1);
        while (inputFile1.hasNext()){
            String s = inputFile1.nextLine();
            names1.insert(s);
        }
        inputFile1.close();

//        input file name
        System.out.println("Enter the second filename to read from: ");
        String filename2 = in.nextLine();

//        store file
        File file2 = new File(filename2);

        OrderedList<String> names2 = new OrderedList<String>();
        Scanner inputFile2 = new Scanner(file2);
        while (inputFile2.hasNext()){
            String s = inputFile2.nextLine();
            names2.insert(s);
        }
        inputFile2.close();

        System.out.println();
        names1.enumerate();
        names2.enumerate();

        OrderedList<String> mergeList = new OrderedList<String>();
        mergeList = merge(names1,names2);
        System.out.println("\nMerged List: ");
        mergeList.enumerate();

        OrderedList<String> differenceList = new OrderedList<String>();
        differenceList = difference(names1,names2);
        System.out.println("\nDifference List: ");
        differenceList.enumerate();

        OrderedList<String> commonList = new OrderedList<String>();
        commonList = common(names1,names2);
        System.out.println("\nCommon List: ");
        commonList.enumerate();


        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nEnter the name of the .txt file to write merge into: ");
        String writeFile1 = keyboard.nextLine();
        PrintWriter outputFile1 = new PrintWriter(new FileWriter(writeFile1));

        System.out.print("\nEnter the name of the .txt file to write difference into: ");
        String writeFile2 = keyboard.nextLine();
        PrintWriter outputFile2 = new PrintWriter(new FileWriter(writeFile2));

        System.out.print("\nEnter the name of the .txt file to write common into: ");
        String writeFile3 = keyboard.nextLine();
        PrintWriter outputFile3 = new PrintWriter(new FileWriter(writeFile3));

        for (int i = 0; i < mergeList.size(); i++) {
            outputFile1.println(mergeList.get(i));
        }
        outputFile1.close();

        for (int i = 0; i < differenceList.size(); i++) {
            outputFile2.println(differenceList.get(i));
        }
        outputFile2.close();

        for (int i = 0; i < commonList.size() ; i++) {
            outputFile3.println(commonList.get(i));
        }
        outputFile3.close();

        System.out.println("\nThe merge operations are complete and the results are in: " +
                "\nmerged.txt" +
                "\ndiff.txt" +
                "\ncommon.txt");
    } //main

    /**
     * This method merges the two lists into a new list
     * @param list1
     * @param list2
     * @param <T>
     * @return new list with merge of list 1 and 2
     */
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> list3 = new OrderedList<T>();
        int lengthOfList1 = list1.size();
        int lengthOfList2 = list2.size();
        int f1 = 0;
        int f2 = 0;

        while (f1 < lengthOfList1 && f2 < lengthOfList2){
            if (list1.get(f1).compareTo(list2.get(f2)) < 0){
                list3.add(list1.get(f1));
                f1++;
            }
            else if (list1.get(f1).compareTo(list2.get(f2)) > 0){
                list3.add(list2.get(f2));
                f2++;
            }
            else{
                list3.add(list1.get(f1));
                f1++;
                f2++;
            }
        }

        while (f1 < lengthOfList1 || f2 < lengthOfList2){
            if (f1 == lengthOfList1){
                    list3.add(list2.get(f2));
                    f2++;
            }
            else if (f2 == lengthOfList2){
                    list3.add(list1.get(f1));
                    f1++;
            }
        }
        return list3;
    }

    /**
     * This list returns a new list consisting of items in list 1 that are not in list 2
     * @param list1
     * @param list2
     * @param <T>
     * @return new list with items in list 1 not in list 2
     */
    public static <T extends Comparable<T>> OrderedList<T> difference(OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> list3 = merge(list1,list2);
        int lengthOfList1 = list1.size();
        int lengthOfList2 = list2.size();
        int lengthOfList3 = list3.size();
        int f1 = 0;
        int f2 = 0;

        while (f1 < lengthOfList3 && f2 < lengthOfList2){
            if (list2.get(f2).compareTo(list3.get(f1)) == 0){
                list3.remove(list3.get(f1));
                f2++;
                f1 = 0;
            }
            else if (list2.get(f2).compareTo(list3.get(f1)) < 0){
                f2++;
            }
            else if (list2.get(f2).compareTo(list3.get(f1)) > 0){
                f1++;
            }
            else if (f2 == lengthOfList2){
                list3.remove(list3.get(f1));
                f1++;
            }
        }
        return list3;
    }

    /**
     * returns a third list that is an ordered list with the items that are common in list1 and list2
     * @param list1
     * @param list2
     * @param <T>
     * @return a new list with items that are common in list1 and list2
     */
    public static <T extends Comparable<T>> OrderedList<T> common(OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> list3 = new OrderedList<T>();
        int lengthOfList1 = list1.size();
        int lengthOfList2 = list2.size();
        int f1 = 0;
        int f2 = 0;

        while (f1 < lengthOfList1 && f2 < lengthOfList2){
            if (list1.get(f1).compareTo(list2.get(f2)) < 0){
                f1++;
            }
            else if (list2.get(f2).compareTo(list1.get(f1)) < 0){
                f2++;
            }
            else{
                list3.add(list1.get(f1));
                f1++;
                f2++;
            }
        }

        if (f2 == lengthOfList2){
            while (f1 < lengthOfList2){
                list3.add(list1.get(f1));
                f1++;
            }
        }
        return list3;
    }
}
