/**
 * this class moves the Piece up or down as well as right or left
 */
import java.awt.*;
public class FastFlexible extends FastPiece {
    public FastFlexible(String name, String colour, Point position) {
        super(name, colour, position);
    }

    /**
     * the origin is 0,0 top left corner
     * move the piece by specified steps
     * if left x - (user input steps)
     * if right x + (user input steps)
     * if up y - (user input steps)
     * if down y + (user input steps)
     * @param direction up or down or left or right
     * @param steps number of steps the piece should move
     * @return
     */
    public Boolean move(String direction, int steps) {
        String directionLower = direction.toLowerCase();
        if (directionLower.equals("left")) {
            if (getPositionX() == 0) {
                return null;
            }
            if (getPositionX() > 0) {
                setPosition(getPositionX() - steps, getPositionY());
            }
        }
        if (directionLower.equals("right")) {
            if (getPositionX() == 7) {
                return null;
            }
            if (getPositionX() < 7) {
                setPosition(getPositionX() + steps, getPositionY());
            }
        }

        if (directionLower.equals("up")) {
            if (getPositionY() == 0) {
                return null;
            }
            if (getPositionY() > 0) {
                setPosition(getPositionX(), getPositionY() - steps);
            }
        }

        if (directionLower.equals("down")) {
            if (getPositionY() == 7) {
                return null;
            }
            if (getPositionY() < 7) {
                setPosition(getPositionX(), getPositionY() + steps);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "F";
    }
}
