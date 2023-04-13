/**
 * this program checks if a given point is contained in the rectangle and checks if the given rectangle is contained
 * in the previous rectangle.
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 **/
import java.util.Scanner;
public class Exercise1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            for (int i = 0; i < in.nextInt(); i++) {
                double xpos1 = in.nextDouble();
                double ypos1 = in.nextDouble();
                double width1 = in.nextDouble();
                double height1 = in.nextDouble();

                double xpos2 = in.nextDouble();
                double ypos2 = in.nextDouble();
                double width2 = in.nextDouble();
                double height2 = in.nextDouble();

                Rectangle rect1 = new Rectangle(xpos1, ypos1, width1, height1);
                Rectangle rect2 = new Rectangle(xpos2, ypos2, width2, height2);

                System.out.println("The first Rectangle's top corner is: " + rect1.getX() + ", " + rect1.getY());
                System.out.println("It's width is: " + rect1.getWidth());
                System.out.println("It's height is: " + rect1.getHeight());

                System.out.println("The second Rectangle's top corner is: " + rect2.getX() + ", " + rect2.getY());
                System.out.println("It's width is: " + rect2.getWidth());
                System.out.println("It's height is: " + rect2.getHeight());

                System.out.println("Contains method returns: " + rect1.contains(rect2));
                System.out.println("Touches method returns: " + rect1.touches(rect2));
            }
        }
}
