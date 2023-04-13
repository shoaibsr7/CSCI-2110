/**
 * Author: Ahmed Rajgoli Shoaib Shakeel B00878695
 */

/**
 * Simple illustration of hashmap in java
 * Creates a hashmap of student id numbers as Keys and student names as Records.
 */

package Assignment5;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class HashMapDemo
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);

		HashMap<String, String> usernamePassword_HashMap = new HashMap<>();
		HashMap<String, String> usernameFullName_HashMap = new HashMap<>();
		String fullName, username, password;

//		System.out.print("Enter the filename to read from: ");
		String filename = "username_password.txt";
//		String filename = keyboard.nextLine();

//		I've set the parent file path so that the user can simply type in the file name
		File file = new File("src/Assignment5/",filename);
		Scanner inputFile = new Scanner(file);

//		read the file and "put" the fullName, username, password into the HashMap
		while (inputFile.hasNext())
		{
			fullName = inputFile.next();
			fullName += " ";
			fullName += inputFile.next();
			username = inputFile.next();
			password = inputFile.next();
			usernamePassword_HashMap.put(username,password);
			usernameFullName_HashMap.put(username,fullName);
		}
		inputFile.close();

//		System.out.println("usernamePassword_HashMap:");
//		System.out.println("Username as KEYS:-");
//		System.out.println(usernamePassword_HashMap.keySet());
//		System.out.println("Password as VALUES:-");
//		System.out.println(usernamePassword_HashMap.values());
//
//		System.out.println("\nusernameFullName_HashMap");
//		System.out.println("Username as KEYS:-");
//		System.out.println(usernameFullName_HashMap.keySet());
//		System.out.println("Full Name as VALUES:-");
//		System.out.println(usernameFullName_HashMap.values());
//		System.out.println();

		System.out.print("Login (username): ");
		String inputUsername = in.next();
		System.out.print("Password: ");
		String inputPassword = in.next();

		int tries = 0;
		while (tries <3) {
			if (usernamePassword_HashMap.containsKey(inputUsername) && usernamePassword_HashMap.containsValue(inputPassword)){
				fullName = usernameFullName_HashMap.get(inputUsername);
				System.out.println("Welcome " + fullName);
				return;
			}
			else {
				if (!usernamePassword_HashMap.containsKey(inputUsername)){
					System.out.println("Username incorrect. Please make sure you are entering the correct Username.");
					tries++;
					System.out.println("You have " + (3 - tries) + " more attempts.\n");
				}
				else if (!usernamePassword_HashMap.containsValue(inputPassword)){
					System.out.println("Password incorrect. Please make sure you are entering the correct Password.");
					tries++;
					System.out.println("You have " + (3 - tries) + " more attempts.\n");
				}
				if (tries == 3) {
					System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
					return;
				}
				System.out.print("Login (username): ");
				inputUsername = in.next();
				System.out.print("Password: ");
				inputPassword = in.next();
			}
		} // while (tries <3)

	} // main
}
