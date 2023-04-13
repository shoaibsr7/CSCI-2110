/**
 * Rectangle class that defines a Rectangle object with xpos, ypos, width and height has two contains methods
 */
public class Rectangle{
//    instance variables
    private double xpos, ypos, width, height;

//    constructors
    public Rectangle(){}
    public Rectangle(double xpos, double ypos, double width, double height){
        this.xpos=xpos;
        this.ypos=ypos;
        this.width=width;
        this.height=height;
    }

//    setters
    public void setX(double xpos){
        this.xpos=xpos;
    }
    public void setY(double ypos){
        this.ypos=ypos;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public void setHeight(double height){
        this.height=height;
    }

//    getters
    public double getX(){
        return xpos;
    }
    public double getY(){
        return ypos;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }

//    other methods: moveTo changes xpos and ypos and resize changes width and height
    public void moveTo(double xpos, double ypos){
        this.xpos=xpos; this.ypos=ypos;
    }
    public void resize(double width, double height){
        this.width=width; this.height=height;
    }

//    toString method
    public String toString(){
        return "[xpos= " +xpos+","+"ypos= " + ypos+"] width: " + width+",height: "+height;
    }


    /**
     * returns true if a point (px, py) is contained within this rectangle contains also returns true
     * if the point touches the rectangle
     * @param px point x
     * @param py point y
     * @return true if the point is contained in the rectangle
     */
    public boolean contains(double px, double py)
    {
        return (px>=xpos && px<=xpos+width && py>=ypos && py<= ypos+height);
    }

    /**
     * returns true if another rectangle r is contained in other rectangle it uses the point contains method
     * @param r Object Rectangle
     * @return returns true if another rectangle r is contained within this rectangle
     */
    public boolean contains(Rectangle r)
    {
        return(this.contains(r.getX(),r.getY()) && this.contains(r.getX() + r.getWidth(), r.getY()+r.getHeight()));
    }

    /**
     * returns true if the point touches the rectangle
     * @param px point x
     * @param py point y
     * @return true if point touches the rectangle false otherwise
     */
    public boolean touches(double px, double py){
        if(px == xpos || px == (xpos+getWidth()) && (py >= ypos && py <= (ypos+getHeight()))){
            return true;
        }
        if(py == ypos || py == (ypos+getHeight()) && (px >= xpos && px <= (xpos+getWidth()))){
            return true;
        }
        return false;
    }

    /**
     * returns true if the new rectangle is contained in the old rectangle. Checked using points of the rectangles
     * @param r Object Rectangle
     * @return true if rectangle is contained false otherwise
     */
    public boolean touches(Rectangle r){
        return(touches(r.xpos, r.ypos) || touches(r.xpos, r.ypos+getHeight()) ||
                touches(r.xpos + r.getWidth(), r.ypos)
                || touches(r.xpos + r.getWidth(), r.ypos + getHeight()));
    }
}