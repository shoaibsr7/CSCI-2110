/**
 * Circle class that defines a Circle object with xpos, ypos and radius has two contains methods
 */
public class Circle {
    private double xpos,ypos, radius;

//    Constructors
    public Circle(){}
    public Circle(double xpos, double ypos, double radius){
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
    }

//    Setter method
    public void setX(double xpos){
        this.xpos = xpos;
    }
    public void setY(double xpos){
        this.ypos = ypos;
    }
    public void setRadius(double xpos){
        this.radius = radius;
    }

//    Getter methods
    public double getX(){
        return(this.xpos);
    }
    public double getY(){
        return(this.ypos);
    }
    public double getRadius(){
        return(this.radius);
    }


//    Area of the circle
    public double getArea(){
        return (Math.PI*this.radius*this.radius);
    }

//    Circumference of the circle
    public double getCircumference(){
        return(2*this.radius*Math.PI);
    }

//    overlap means both circles have the same radius

    /**
     * Checks weather point x,y is contained in the circle
     * @param x point x
     * @param y point y
     * @return true if coordinates are present in the circle
     */
    public boolean contains(double x, double y){
        if((this.xpos == x && this.ypos == y) || (x <= (this.radius+this.xpos) && y <= (this.radius+this.ypos))){
            return true;
        }
        return false;
    }

    /**
     * Checks weather point x,y is touches the circle
     * @param x point x
     * @param y point y
     * @return true if coordinates are touching the circle
     */
    public boolean touches(double x, double y){
        if((x == this.radius && y == this.radius)){
            return true;
        }
        return false;
    }

    /**
     * Checks weather point Circle c is contained in the circle
     * @param c Object Circle
     * @return true if Circle is present in this circle
     */
    public boolean contains(Circle c){
        if(contains(c.getX(),c.getY())){

            if(c.getRadius() < this.radius)
                return true;
        }
        if(c.getRadius() == this.getRadius()){
            return false;
        }
        return false;
    }

//
    /**
     * to check if they are touching find dist bw two points and then add the radius of both the circles and then
     * compare it with the dist bw the two points
     * @param c Object Circle
     * @return true if Circle touches this circle
     */
    public boolean touches(Circle c){
        double distance = Math.sqrt(Math.pow( (c.getX() - this.getX()) ,2) + Math.pow( (c.getY() - this.getY()) ,2));
        double radiusAdd = c.getRadius() + this.getRadius();
        if(distance == radiusAdd){
            return true;
        }
        return false;
    }

}
