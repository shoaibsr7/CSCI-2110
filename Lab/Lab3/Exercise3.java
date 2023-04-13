import java.util.*;
import java.io.*;
public class Exercise3{
    public static void main(String[] args)throws IOException{
//TODO: Create stack1 to hold StudentRecord Objects
        Stack<StudentRecord> stack1 = new Stack<StudentRecord>();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the filename to read from: ");
        String filename = in.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        StringTokenizer token;

        while (inputFile.hasNext()){
            String line = inputFile.nextLine();
            token = new StringTokenizer(line, " ");
            String firstName = token.nextToken();
            String lastName = token.nextToken();
            String IDString = token.nextToken();
//convert String IDString to an Integer Object IDNum
            Integer IDNum = Integer.valueOf(IDString);
//TODO: Create a StudentRecord Object with the first name, last name and ID number, push it into stack1
            StudentRecord register = new StudentRecord();
            register.setFirstName(firstName);
            register.setLastName(lastName);
            register.setBannerID(IDNum);
//            push register values into stack1
            stack1.push(register);
        }

//        create stack2 to push values off from stack1 to stack2
        Stack<String> stack2 = new Stack<String>();
//        use an iterator to iterate through the stack
        Iterator<StudentRecord> studentRecordIterator = stack1.iterator();

        while (studentRecordIterator.hasNext()) {
            StudentRecord register = studentRecordIterator.next();
            stack2.push(register.getLastName());
        }

        System.out.println("Printing last name in reverse order: ");
        ArrayList<String> stack2Array = new ArrayList<String>();
        while (!stack2.isEmpty()) {
            stack2Array.add(stack2.pop());
        }
//        printing the list in reverse order using array list
        for (int i = stack2Array.size() - 1; i >= 0 ; i--) {
            System.out.println(stack2Array.get(i));
        }
        inputFile.close();
    }
}