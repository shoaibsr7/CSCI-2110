/**
 * this class moves the Piece up or down as well as right or left
 */
import java.awt.*;
public class SlowFlexible extends SlowPiece {
    public SlowFlexible(String name, String colour, Point position) {
        super(name, colour, position);
    }

    /**
     * the origin is 0,0 top left corner
     * if left x-1
     * if right x+1
     * if up y-1
     * if down y+1
     *
     * @param direction up or down or left or right
     * @return
     */
    public Boolean move(String direction) {
        String directionLower = direction.toLowerCase();
        if (directionLower.equals("left")) {
            if (getPositionX() == 0) {
                return null;
            }
            if (getPositionX() > 0) {
                setPosition(getPositionX() - 1, getPositionY());
            }
        }
        if (directionLower.equals("right")) {
            if (getPositionX() == 7) {
                return null;
            }
            if (getPositionX() < 7) {
                setPosition(getPositionX() + 1, getPositionY());
            }
        }

        if (directionLower.equals("up")) {
            if (getPositionY() == 0) {
                return null;
            }
            if (getPositionY() > 0) {
                setPosition(getPositionX(), getPositionY() - 1);
            }
        }

        if (directionLower.equals("down")) {
            if (getPositionY() == 7) {
                return null;
            }
            if (getPositionY() < 7) {
                setPosition(getPositionX(), getPositionY() + 1);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "F";
    }
}
