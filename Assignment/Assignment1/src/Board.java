/**
 * The Board class will hold the 8 X 8 game board
 */
import javax.swing.text.Position;
import java.awt.*;
public class Board {
    Piece[][] boardGame;

    public Board(){
        boardGame = new Piece[8][8];
    }

    public void add(Piece newPiece){
        int x = newPiece.getPositionX();
        int y = newPiece.getPositionY();
//        System.out.println("XPOS = " + x + " YPOS = " + y);
        if (boardGame[x][y] == null){
            boardGame[x][y] = newPiece;
        }
        else {
            System.out.println("ERROR.SPACE IS OCCUPIED.");
        }
    }

    public void move (Piece location, String direction, int steps){
        int x = location.getPositionX();
        int y = location.getPositionY();

        Piece movePiece = boardGame[x][y];
        String directionLower = direction.toLowerCase();

        if (movePiece == null){
            System.out.println("NO GAME PIECE AT (" + x + "," + y + ") SPOT.");
        }

        else{
            if (checkIfEmpty(location,direction,steps)){
                if (movePiece instanceof SlowPiece){
//                    if (movePiece.move(directionLower)){
//                        boardGame[movePiece.getPositionX()] [movePiece.getPositionY()] = movePiece;
                        ((SlowPiece) boardGame[x][y]).move(directionLower);
                        boardGame[x][y] = null;
//                    }
                }
                if (movePiece instanceof SlowFlexible) {
                    ((SlowFlexible) boardGame[x][y]).move(directionLower);
                    boardGame[x][y] = null;
                }

                if (movePiece instanceof FastPiece){
                    if (movePiece.move(directionLower, steps)){
//                        boardGame[movePiece.getPositionX()] [movePiece.getPositionY()] = movePiece;
                        ((FastPiece) boardGame[x][y]).move(directionLower,steps);
                        boardGame[x][y] = null;
                    }
                }
                if (movePiece instanceof FastFlexible) {
                    ((FastFlexible) boardGame[x][y]).move(directionLower,steps);
                    boardGame[x][y] = null;
                }
            }
        }

    }

    public boolean checkIfEmpty(Piece location, String direction, int steps){
        int x = location.getPositionX();
        int y = location.getPositionY();

        Piece movePiece = boardGame[x][y];
        String directionLower = direction.toLowerCase();

        if (directionLower.equals("left")){
            if (x - steps > -1 && boardGame[x - steps][y] == null){
                return true;
            }
            else{
                System.out.println("ERROR. A PIECE ALREADY EXISTS THERE.");
                return false;
            }
        }


        if (directionLower.equals("right")){
            if (x + steps < -1 && boardGame[x + steps][y] == null){
                return true;
            }
            else{
                System.out.println("ERROR. A PIECE ALREADY EXISTS THERE.");
                return false;
            }
        }


        if (directionLower.equals("up")){
            if (y - steps > -1 && boardGame[x][y - steps] == null){
                return true;
            }
            else{
                System.out.println("ERROR. A PIECE ALREADY EXISTS THERE.");
                return false;
            }
        }


        if (directionLower.equals("down")){
            if (y + steps < 8 && boardGame[x][y + steps] == null){
                return true;
            }
            else{
                System.out.println("ERROR. A PIECE ALREADY EXISTS THERE.");
                return false;
            }
        }

        return false;
    }

//    print the whole game board
    public void display(){
        for (int i = 0; i < boardGame.length; i++){
            for (int j = 0; j < boardGame.length; j++){
                Piece game = boardGame[j][i]; //make sure x and y are correct!
                if(game == null)
                    System.out.printf("%-15s" , "-");
                else
                    System.out.printf("%-15s" ,game);
            }
            System.out.println();
        }
    }

}
