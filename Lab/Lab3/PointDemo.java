import java.util.Scanner;
public class PointDemo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int xI = in.nextInt();
        int yI = in.nextInt();
//        Construct Point object with Integers type
        Point<Integer> point1 = new Point<Integer>(xI, yI);

        double xD = in.nextDouble();
        double yD = in.nextDouble();
//        Construct Point object with Double type
        Point<Double> point2 = new Point<Double>(xD, yD);

        String xS = in.next();
        String yS = in.next();
//      Construct Point object with Strings type
        Point<String> point3 = new Point<String>(xS, yS);

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
    }
}
