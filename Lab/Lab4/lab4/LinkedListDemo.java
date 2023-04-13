package lab4;
import java.util.Scanner;

public class LinkedListDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        create a LinkedList
        LinkedList<String> names = new LinkedList<>();

        System.out.println("Enter Pokemon names, one on each line \nEnter quit to end");
        String name = in.next();

//        adding the names into the list
        while (!name.equals("quit")){
            names.add(name);
            name = in.nextLine();
        }

        System.out.println("Here is the linked list: ");
        names.enumerate();
        System.out.println();

//        display EVEN indexes
        displayEven(names);
        System.out.println();

//        display ODD indexes
        displayOdd(names);
        System.out.println();

        LinkedList<String> reverseLL = reverse(names);
        System.out.println("Here is the reversed linked list:");
        reverseLL.enumerate();
        System.out.println();

        System.out.println("Here is the linked list with the middle node removed:");
        removeMiddle(names);
        names.enumerate();
    } //main


//    method to display even-numbered nodes
    public static void displayEven(LinkedList<String> list){
        System.out.println("Here is the linked list with even-numbered nodes:");
        if (list.getFront() != null){
            int i = 0;
            while (i < list.size()){
                if (i%2 == 0){
                    System.out.print(list.getAt(i)+ "\t");
                }
                i++;
//                System.out.println();
            }
        }
        System.out.println();
    }

//    method to display odd-numbered nodes
    public static void displayOdd(LinkedList<String> list){
        System.out.println("Here is the linked list with odd-numbered nodes:");
        if (list.getFront() != null){
            int i = 0;
            while (i < list.size()){
                if (i%2 != 0){
                    System.out.print(list.getAt(i)+ "\t");
                }
                i++;
//                System.out.println();
            }
        }
        System.out.println();
    }

//    method to create a reversed linked list
    public static LinkedList<String> reverse(LinkedList<String> list){
        LinkedList<String> namesReverse = new LinkedList<>();
        for (int i = 0; i < list.size() ; i++) {
            namesReverse.add(list.getAt(i));
        }
        return namesReverse;
    }

//    method to remove the middle node in the linked list
    public static void removeMiddle(LinkedList<String> list){
        Node first = list.getFront();
        Node next = first.getNext();
        Node temp;
        if (first == null){
            return;
        }
        else {
            int position = 0;
            if (list.size()%2 == 0){
                position = (list.size()/2) - 1;
            }
            else {
                position = list.size()/2;
            }
            list.removeAt(position);
        }
    }

}
