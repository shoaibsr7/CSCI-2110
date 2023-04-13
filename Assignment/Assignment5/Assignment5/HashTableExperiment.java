/**
 * Author: Ahmed Rajgoli Shoaib Shakeel B00878695
 */
/**
 * Hash Table Experiment
 * This is a simple demo program that
 * creates an ArrayList of LinkedList of Integer objects
 * It first displays the empty linked lists
 * It then hashes some keys and displays the linked lists again
 * It uses the generic LinkedList class and the generic Node class
 */
// ToDo MODIFY THIS PROGRAM TO DO EXERCISE 1

package Assignment5;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HashTableExperiment
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

//		prompt the user to enter the table size
		System.out.print("Enter the hash table size: ");
		int tableSize = in.nextInt();

//		prompt the user to enter the number of keys to be hashed
		System.out.print("Enter the number of keys to be hashed: ");
		int keys = in.nextInt();
		ArrayList<Integer> keysArrayList = new ArrayList<>();

		int collision = 0;
		int longestList = 0;
		
//		create an Arraylist of size tableSize
//		The ArrayList holds a LinkedList object
//		The LinkedList consists of nodes that hold integer objects
		ArrayList<LinkedList<Integer>> hashtable = new ArrayList<>();
		/**
		 * Create an empty arrayList with LinkedList in each index
		 * 	for eg.
		 * 	0: [LinkedList<Integers>()]
		 * 	1: [LinkedList<Integers>()]
		 * 	2: [LinkedList<Integers>()]
		 * 	3: [LinkedList<Integers>()]
		 * 	4: [LinkedList<Integers>()]
		 * 	etc.
		 */
		for (int i = 0; i < tableSize; i++)
		{
			hashtable.add(i, new LinkedList<Integer>());
		}

/**
//		Display the arraylist of linked lists
		System.out.println("Empty lists");
		for (int i = 0; i < tableSize; i++)
		{
			System.out.print(i + ": ");
			hashtable.get(i).enumerate();
		}
 */

//		generate random keys
		int j = 0;
		while (j < keys){
//			https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
			int randomInteger = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
			if (keysArrayList.contains(randomInteger))
				continue;
			keysArrayList.add(randomInteger);
			j++;
		}

//		print the arrayList of keys
		System.out.println("\nArrayList of Keys:\t" + keysArrayList);

//		Add keys to the appropriate linked list
//		random_Key will be added to the linked list at index random_Key % tableSize
		for (int i = 0; i < keysArrayList.size(); i++) {
			int index = keysArrayList.get(i) % tableSize;
			hashtable.get(index).add(keysArrayList.get(i));
		}

//		count the number of collisions and the longest list in the hashtable
		for (int i = 0; i < hashtable.size(); i++) {
			if (hashtable.get(i).size() > 1 ){
				collision++;
			}

			longestList = hashtable.get(0).size();
			if (hashtable.get(i).size() > longestList){
				longestList = hashtable.get(i).size();
			}
		}

		/**
		 * Add keys 187, 105, 120, 205, 189 to the appropriate linked list
		 * 187 will be added to the linked list at index 187 % tableSize
		 * 105 will be added to the linked list at index 105 % tableSize
		 * etc.
		 * int index = 187%tableSize;
		 * hashtable.get(index).add(187);
		 * index = 105%tableSize;
		 * hashtable.get(index).add(105);
		 * index = 120%tableSize;
		 * hashtable.get(index).add(120);
		 * index = 205%tableSize;
		 * hashtable.get(index).add(205);
		 * index = 189%tableSize;
		 * hashtable.get(index).add(189);
		 */

//		Display the arraylist of linked lists
//		System.out.println("\nAfter the keys are hashed");
		System.out.println("\nHash Table created:");
		for (int i = 0; i < tableSize; i++)
		{
			System.out.print(i + ": ");
			hashtable.get(i).enumerate();
		}

		System.out.println("\nStatistics:- ");
		System.out.println("Table size: " + tableSize);
		System.out.println("Number of keys: " + keys);
		int loadFactor = keys/tableSize;
		System.out.println("Load factor: " + loadFactor);
		System.out.println("Number of collisions: " + collision);
		System.out.println("Longest list: " + longestList);
			
	}
}
			
		
