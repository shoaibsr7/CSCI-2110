/**
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 **/
import java.awt.*;
import java.util.Scanner;
public class GameDemo {
//    create a board game object
    static Board board = new Board();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean quit = false; //flag variable

        while (!quit) {
            System.out.println("Enter a command (type help for details): ");
            String input = in.nextLine();
            String command = input.toLowerCase();

            if (command.equals("help")) {
                help();
            }

            if (command.equals("exit")) {
                System.out.println("Done.");
                quit = true;
            }

            if (command.equals("print")) {
                display();
            }

            if (command.equals("create")) {
                if (in.hasNextInt()) { // x pos value
                    int xpos = in.nextInt();

                    if (in.hasNextInt()){ // y pos value
                        int ypos = in.nextInt();

                        if (in.hasNext()){ //check string for type (slow or fast or regular)
                            String speed = in.nextLine().trim();
                            String type = speed.toLowerCase();

                            if (type.equals("fast")){
//                                    no flexibility given, make non-flex fast
                                    buildFast(xpos, ypos);
                            }
                            else if (type.equals("fast flexible")){
//                                make fast flexible
                                buildFastFlexible(xpos, ypos);
                            }
                            else if (type.equals("slow")){
//                                no flexibility given, make slow flexible
                                buildSlow(xpos, ypos);
                            }
                            else if (type.equals("slow flexible")){
//                                make slow flexible
                                buildSlowFlexible(xpos,ypos);
                            }

//                            else no specified type so make a slow non flexible
                            else {
                                System.out.println("No specified type or flexibility. Default to slow non-flexible piece.");
                                buildSlow(xpos, ypos);
                            }

                        }
//                        no specified type
                    }
                    else {
                        System.out.println("ERROR: Give a y-coordinate.");
                    }
                }
                else {
                    System.out.println("ERROR: Give x-coordinate.");
                }
            }

            else if (command.equals("move")){ //move a piece
                if (in.hasNextInt()) { // x pos value
                    int xpos = in.nextInt();

                    if (in.hasNextInt()){ // y pos value
                        int ypos = in.nextInt();

                        if (in.hasNext()){ //take the direction as string
                            String direction = in.nextLine().trim();

                            if (in.hasNextInt()){ //number of steps to move the piece by
                                int steps = in.nextInt();

//                                move the piece aat (x, y) in given direction with given steps
                                board.move(new Piece(xpos,ypos), direction, steps);
                                System.out.println("Piece at (" + xpos + "," + ypos +")" + "moved up by" + steps +" spaces");

                            }
                            else {
//                                move the piece aat (x, y) in given direction with 1 steps
                                board.move(new Piece(xpos, ypos), direction, 1);
                                System.out.println("Piece at (" + xpos + "," + ypos +")" + "moved up by spaces");
                            }
                        }
                        else { //no direction given
                            System.out.println("ERROR: No direction entered.");
                        }
                    }
                    else {
                        System.out.println("ERROR: No y-position entered.");
                    }
                }
                else {
                    System.out.println("ERROR: No x-position given.");
                }
            }
        }

    } //main ends

//    method displays the game board
    public static void display(){
        board.display();
    }

//    method displays the help commands
    public static void help(){
        System.out.println("Possible commands are as follows: ");
        System.out.println("create location [fast][flexible]: Creates a new piece.");
        System.out.println("move location direction [spaces]: Moves a piece.");
        System.out.println("print: Displays the board.");
        System.out.println("help: Displays help.");
        System.out.println("exit: Exits the program.");
    }

//    method makes slow non-flex piece at a given position
    public static void buildSlow(int xpos, int ypos){
        if(!positionCheck(xpos, ypos)){
            System.out.println("Incorrect position given.");
            return;
        }

        Scanner in = new Scanner(System.in);

        System.out.print("Give a name to your slow non-flexible piece: ");
        String name = in.next();

        System.out.print("Enter a colour: ");
        String colour = in.next();

//        create a new slow piece object
        SlowPiece newSlowPiece = new SlowPiece(name, colour, new Point(xpos, ypos));

//        add the created piece to the board
        board.add(newSlowPiece);

        System.out.println("New Slow Piece created.");
    }

//    method makes slow flexible piece at a given position
    public static void buildSlowFlexible(int xpos, int ypos){
        if(!positionCheck(xpos, ypos)){
            System.out.println("Incorrect position given.");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Give a name to your slow non-flexible piece: ");
        String name = in.next();

        System.out.print("Enter a colour: ");
        String colour = in.next();

        SlowFlexible newSlowFlexible = new SlowFlexible(name, colour, new Point(xpos, ypos));
//        add the created piece to the board
        board.add(newSlowFlexible);

//        prints conclusion statement
        System.out.println("New Slow Flexible Piece created.");
    }


//    method makes fast non-flex piece at a given position
    public static void buildFast(int xpos, int ypos){
        if(!positionCheck(xpos, ypos)){
            System.out.println("Incorrect position given.");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Give a name to your Fast piece: ");
        String name = in.next();
        System.out.print("Enter a colour: ");
        String colour = in.next();
//        asks for colour and name

        FastPiece newFastPiece = new FastPiece(name, colour, new Point(xpos, ypos));
        board.add(newFastPiece);
//        add the created piece to the board

        System.out.println("New Fast Piece created.");
//        prints conclusion statement
    }
//    method makes fast flexible piece at a given position
    public static void buildFastFlexible(int xpos, int ypos){
        if(!positionCheck(xpos, ypos)){
            System.out.println("Incorrect position given.");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Give a name to your Fast Flexible piece: ");
        String name = in.next();
        System.out.print("Enter a colour: ");
        String colour = in.next();

        FastFlexible newFastFlexible = new FastFlexible(name, colour, new Point(xpos, ypos));
//        add the created piece to the board
        board.add(newFastFlexible);

//        prints conclusion statement
        System.out.println("New Fast Flexible Piece created.");
    }

    public static Boolean positionCheck(int xpos, int ypos){
//        check if x and y are between 0 and 7
        return (xpos>=0 && xpos<=7) && (ypos>=0 && ypos<=7);
    }

}
