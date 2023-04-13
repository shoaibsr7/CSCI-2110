/**
 * this program checks if a given point/circle is contained/touches the circle
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 **/
import java.util.Scanner;
public class Exercise2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < in.nextInt(); i++) {
            double xpos1 = in.nextDouble();
            double ypos1 = in.nextDouble();
            double radius1 = in.nextDouble();

            double xpos2 = in.nextDouble();
            double ypos2 = in.nextDouble();
            double radius2 = in.nextDouble();

            Circle c1 = new Circle(xpos1, ypos1, radius1);
            Circle c2 = new Circle(xpos2, ypos2, radius2);

            System.out.println("The first Circle's centre is: " + c1.getX() + ", " + c1.getY());
            System.out.println("It's radius is: " + c1.getRadius());

            System.out.println("The second Circle's top corner is: " + c2.getX() + ", " + c2.getY());
            System.out.println("It's radius is: " + c2.getRadius());

            System.out.println("The 'contains' method returns:" + c1.contains(c2));
            System.out.println("The 'touches' method returns:" + c1.touches(c2));
        }
    }
}
