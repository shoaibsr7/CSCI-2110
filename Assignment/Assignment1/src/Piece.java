import java.awt.*;
import java.util.*;

public class Piece {
    private String Name;
    private String Colour;
    private Point Position;

    public Piece(){
//        this.Name = "";
//        this.Colour = "";
//        this.Position = Point();  //IF I WAS MAKING THIS CONSTRUCTOR HOW WOULD I INITIALIZE POSITION?
    }

//    public Piece(int x, int y){
//        this.Position.setLocation(x,y);
//    }

    public Piece(String name, String colour, Point position) {
        this.Name = name;
        this.Colour = colour;
        this.Position = position;
    }

    public Piece(int xpos, int ypos) {
        setPosition(xpos,ypos);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        this.Colour = colour;
    }

    public int getPositionX() {
        return (int) Position.getX();
    }

    public int getPositionY() {
        return (int) Position.getY();
    }

    public Point getPosition(){
        return Position;
    }

    public void setPosition(int x, int y) {
        Position.setLocation(x,y);
    }

    public Boolean move(String direction){return true;}
    public Boolean move(String direction, int n){return true;}

    @Override
    public String toString() {
        return Name + Colour;
    }
}
