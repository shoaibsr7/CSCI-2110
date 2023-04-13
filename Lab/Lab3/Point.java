// A generic class is the one in which we can define the type of variable accordingly
public class Point<G>{

    private G xpos,ypos;

    public Point(G x, G y){
        this.xpos = x;
        this.ypos = y;
    }

    public G getXpos() {
        return xpos;
    }

    public void setXpos(G xpos) {
        this.xpos = xpos;
    }

    public G getYpos() {
        return ypos;
    }

    public void setYpos(G ypos) {
        this.ypos = ypos;
    }

    public String toString(){
        return "Xpos: "+getXpos()+" Ypos: "+getYpos();
    }
}