package Lab10;

import java.util.*;
public class Exercise1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter how many items are in the list?");
//        size for the array
        int size = in.nextInt();

        Integer[] integerArray = new Integer[size];
        String[] stringArray = new String[size];

        System.out.println("Are we sorting Strings or Integers?");
        String stringOrInteger = in.next();

        System.out.println("Enter values:-");
//        check if the user wants to sort string or integers
        if (stringOrInteger.equalsIgnoreCase("Integers")){
            for (int i = 0; i < size; i++) {
                Integer value = in.nextInt();
                integerArray[i] = value;
            }
        }
        else if (stringOrInteger.equalsIgnoreCase("Strings")){
            String value = in.nextLine();
            for (int i = 0; i < size; i++) {
                stringArray[i] = value;
                value = in.nextLine();
            }
        }

        System.out.println("Do you want to sort Min or Max?");
        String maxOrMin = in.next();

        if (maxOrMin.equalsIgnoreCase("Min")) {
            if (stringOrInteger.equalsIgnoreCase("Integers")) {
                Integer[] sorted = bubbleSortMin(integerArray);
                for (Integer integer : sorted) {
                    System.out.print(integer + " ");
                }
            }
            else if (stringOrInteger.equalsIgnoreCase("Strings")) {
                String[] sort = bubbleSortMin(stringArray);
                for (String s : sort) {
                    System.out.print(s + " ");
                }
            }
        }
        else if (maxOrMin.equalsIgnoreCase("Max")) {
            if (stringOrInteger.equalsIgnoreCase("Integers")) {
                Integer[] sorted = bubbleSortMax(integerArray);
                for (Integer integer : sorted) {
                    System.out.print(integer + " ");
                }
            } else if (stringOrInteger.equalsIgnoreCase("Strings")) {
                String[] sort = bubbleSortMax(stringArray);
                for (String s : sort) {
                    System.out.print(s + " ");
                }
            }
        }
    } //main

    public static <T extends Comparable<T>> T[] bubbleSortMin (T[] list){
        T temp;
//        count the number of swaps
        int counter = 0;

        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list.length - i; j++) {
                if (list[j - 1].compareTo(list[j]) > 0) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    counter++;
                }
            }
        }
        System.out.println("Sorting Complete. Total Swaps:\t" + counter);
        return list;
    }

    public static <T extends Comparable<T>> T[] bubbleSortMax (T[] list){
        T temp;
//        count the number of swaps
        int counter = 0;

        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list.length - i; j++) {
                if (list[j - 1].compareTo(list[j]) < 0) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    counter++;
                }
            }
        }
        System.out.println("Sorting Complete. Total Swaps:\t" + counter);
        return list;
    }
}
