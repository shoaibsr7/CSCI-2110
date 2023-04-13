/**
 * This class moves the piece left or right by user input steps.
 * If the piece would take off the edge of the board, simply return without doing anything
 */

import java.awt.*;
public class FastPiece extends Piece{
    public FastPiece(String name, String colour, Point position) {
        super(name, colour, position);
    }

    @Override
    public String toString() {
        return super.toString() + "F";
    }

    /**
     * the origin is 0,0 top left corner
     * move the piece by specified steps
     * if left x - (user input steps)
     * if right x + (user input steps)
     * @param direction left or right
     * @param steps number of steps the piece should move
     * @return
     */
    public Boolean move (String direction, int steps){
        String directionLower = direction.toLowerCase();
        if (directionLower.equals("left")){
            if (getPositionX() == 0){
                return null;
            }
            if(getPositionX() > 0){
                setPosition(getPositionX() - steps,getPositionY());
            }
        }
        if (directionLower.equals("right")){
            if (getPositionY() == 7){
                return null;
            }
            if (getPositionX() < 7){
                setPosition(getPositionX() + steps,getPositionY());
            }
        }
        return null;
    }

}
