/**
 * this program checks if a given point is contained in the rectangle and checks if the given rectangle is contained
 * in the previous rectangle.
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 **/
import java.util.Scanner;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int repetitions = in.nextInt();

        while(repetitions > 0){
            double[][] points = new double[repetitions][2];

            System.out.print("Enter " + points.length + " points: ");
            for (int i = 0; i < points.length; i++) {
                points[i][0] = in.nextDouble();
                points[i][1] = in.nextDouble();
            }

            Rectangle boundingRectangle = getRectangle(points);

            System.out.println("The bounding rectangle's center " +
                    "(" + boundingRectangle.getX() + "," + boundingRectangle.getY() + "), width "
                    + boundingRectangle.getWidth() + ", height " + boundingRectangle.getHeight());
            repetitions = in.nextInt();
        }
    }

    /**
     * This method finds the xpos, ypos, width and height of the bounding rectangle constructs it and returns it
     * @param points coordinates of the Rectangle object
     * @return a new Rectangle object with
     */
    public static Rectangle getRectangle(double[][] points) {
        double maxXpos = points[0][0];
        double minXpos = points[0][0];
        double maxYpos = points[0][1];
        double minYpos = points[0][1];

        //finding the max and min coordinates for the new object Rectangle
        for (int row = 0; row < points.length; row++) {
            for (int col = 0; col < points[row].length; col++) {
                if (points[row][col] < minXpos && col == 0)
                    minXpos = points[row][col];

                if (points[row][col] < minYpos && col == 1)
                    minYpos = points[row][col];

                if (points[row][col] > maxXpos && col == 0)
                    maxXpos = points[row][col];

                if (points[row][col] > maxYpos && col == 1)
                    maxYpos = points[row][col];
            }
        }

        double xpos = (maxXpos + minXpos) / 2;
        double ypos = (maxYpos + minYpos) / 2;
        double width = maxXpos - minXpos;
        double height = maxYpos - minYpos;
        return (new Rectangle(xpos, ypos, width, height));
    }
}