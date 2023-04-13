import java.util.*;
public class Binary {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int input = in.nextInt();

        int totalRange = (int) (Math.pow(2, input) - 1);
        long start = System.currentTimeMillis();

        Binary.generateBinary(input);
        long end = System.currentTimeMillis();
        double totalTime = end - start;

        System.out.println("The execution time to generate binary numbers from 0 to " + totalRange+ " is "
                + totalTime + " ms");
    }

    public static void generateBinary(int n) {
        double totalRange = Math.pow(2,n);
        for (int i = 0; i < totalRange; i++){
            String output = Integer.toBinaryString(i);
        }
    }
}
