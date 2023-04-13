/**
 * This class moves the piece left or right
 * If the piece would take off the edge of the board, simply return without doing anything
 */
import java.awt.*;
public class SlowPiece extends Piece{
    public SlowPiece(String name, String colour, Point position) {
        super(name, colour, position);
    }

    @Override
    public String toString() {
        return super.toString() + "S";
    }

    /**
     * the origin is 0,0 top left corner
     * if left x-1
     * if right x+1
     * @param direction left or right
     * @return
     */
    public Boolean move (String direction){
        String directionLower = direction.toLowerCase();
        if (directionLower.equals("left")){
            if (getPositionX() == 0){
                return null;
            }
            if(getPositionX() > 0){
                setPosition(getPositionX() - 1,getPositionY());
            }
        }
        if (directionLower.equals("right")){
            if (getPositionX() == 7){
                return null;
            }
            if (getPositionX() < 7){
                setPosition(getPositionX() + 1,getPositionY());
            }
        }
        return null;
    }

}
