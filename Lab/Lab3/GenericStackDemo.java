import java.util.*;
public class GenericStackDemo {
    public static void main(String[] args) {
//        Construct GenericStack object with String type
        GenericStack<String> stack1 = new GenericStack<String>();

//        Construct GenericStack object with Integers type
        GenericStack<Integer> stack2 = new GenericStack<Integer>();

        Scanner in = new Scanner(System.in);

        String inputS = "";
        int inputI = 0;
        boolean exitS = true;
        boolean exitI = true;

        while (exitS){
            inputS = in.next();
//            exit the loop if the user enters quit and change boolean variable to false
            if (inputS.equalsIgnoreCase("quit")){
                exitS = false;
                break;
            }
//            push the values into the stack
            stack1.push(inputS);
        }

        while (exitI){
            inputI = in.nextInt();
//            exit the loop if the user enters -1 and change boolean variable to false
            if (inputI == -1){
                exitI = false;
                break;
            }
//            push the values into the stack
            stack2.push(inputI);
        }

        System.out.println("String Stack Contents: ");
        while (!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }

        System.out.println("Integer Stack Contents: ");
        while (!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }

    }
}