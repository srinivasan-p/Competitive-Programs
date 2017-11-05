package com.programs;

/*
 Chris Poon
 
 Intermediate MineSweeper Assignment -a program to play a game of MineSweeper
 
 As per OO, this assignment contains multiple classes: square, MineBoard, MineSweeper.
 MineBoard is the playing board object that contains a matrix of square objects.
 MineSweeper is the game object that containes MineBoard and has a main().
 
 Note that I allow the user to define the number of rows, cols, and mines as
 command line parameters, defaulting to 5x5, 6 mines if not supplied.
 
*/
import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

class square{
    //the square object, representing a square in the game board.
    // it contains 2 fields, the actual value, and if the square has been revealed.
    
    private boolean revealed;
    private char value;
    
    public square(char v){
        //constructor that sets value to parameter, and revealed to false.
        revealed=false;
        value=v;
    }
    public String toString(){
        //public method to convert object to string for easy output
        // the beauty of this is the square object itself decides what
        // to output because of the _revealed_ field.
        if (revealed)
            return (value+"");
        else
            return "-";
    }
    public char getValue(){
        //public method to return value field.
        return value;
    }
    public void setValue(char v){
        //public method to set the value field.
        value=v;
    }
    public void setRevealed(boolean r){
        //public method to set the revealed flag.
        revealed=r;
    }
    public boolean isRevealed(){
        //public method to return the revealed field.
        return revealed;
    }
    
}
class MineBoard{
    //the MineBoard object that represents the game board, a matrix of squares.
    private square[][] board;
    private int rows, cols, nummines;
    private int uncovered;      //to keep track number of squares uncovered (for win condition)
    
    public MineBoard(int r, int c, int n){
        //public constructor to initialize board size and mine count to parameters.
        rows=r;
        cols=c;
        nummines=n;
        board=new square[rows][cols];
        uncovered=0;
        fillSquares();
 
    }
    public MineBoard(){
        //default constructor to create a 5x5 game with 6 mines.
        this(5,5,6);
    }
    private void fillSquares(){
        //private method to initialize the square objects in the board.
        //instanciates all the squares, and then places the mines randomly.
        
        int r,c;
        int mines=nummines;
        Random rng=new Random();
        for (r=0;r<rows;r++)
            for (c=0;c<cols;c++)
                board[r][c]=new square('?');        //just to instanciate the squares
        
        while (mines>0){                            //loop to place the mines.
            r=rng.nextInt(rows);
            c=rng.nextInt(cols);
            if ((board[r][c]).getValue()!='*'){
                board[r][c]=new square('*');
                mines--;
            }
        }
        
    }
    private int minecount(int r, int c){
        // private method to return an integer for the number of mines
        //  surrounding the square at [r][c].
        int count=0;
        for (int y=-1; y<=1; y++){
            for (int x=-1; x<=1; x++){
                if (y==0 && x==0) continue;
                if (r+y <0 || r+y>=rows) continue;
                if (c+x <0 || c+x>=cols) continue;
                if (board[r+y][c+x].getValue()=='*')
                    count++;
            }
        }
        return count;
    }
    public boolean reveal(int r, int c){
        //public method that reveals the square at [r][c].
        // returns false if a mine is hit
        // returns true otherwise.
        
        //checks to see if i've already been here, or if r,c is out of bounds:
        if (r<0 || r>=rows || c<0 || c>=cols || board[r][c].isRevealed()) return true;
        
        board[r][c].setRevealed(true);          //sets the square to revealed.
   
        if (board[r][c].getValue()=='*') return false;          //hit a mine.
        else{
            //otherwise, compute the mine count on the fly and set the value.
            board[r][c].setValue((char)(minecount(r,c)+'0'));
            uncovered++;                            //increments the count of uncovered.
            if (board[r][c].getValue()=='0'){       //the recursive calls for flood revealing.
                reveal(r-1,c-1); reveal(r-1,c); reveal(r-1,c+1);
                reveal(r,c-1);                  reveal(r,c+1);
                reveal(r+1,c-1); reveal(r+1,c); reveal(r+1,c+1);
            }
            return true;
        }
    }
    public boolean hasWon(){
        //public method that returns true if the game is won,
        // ie., the player has uncovered all the squares that are not mines.
        // returns false otherwise.
        return (uncovered==(rows*cols-nummines));
    }
    public String toString(){
        //public method to convert the game state into a string for output.
        int r, c;
        String out="  |";
        
        for (c=0;c<cols;c++)                    //this section just creates
            out+=Integer.toString(c)+" ";       // the initial heading/top part
        out+="\n==+";                           // of the output
        for (c=0;c<cols;c++)                    //because i wrote this to 
            out+="==";                          // allow user defined game
        out+="\n";                              //parameters (row, cols, # mines).
        
        for (r=0;r<rows; r++){                  //this loop outputs each square object
            out+=(r+" |");                      // of the board.
            for (c=0;c<cols;c++){               //again, this is very concise because
                out+=(board[r][c]+ " ");        // of our OO method, it just calls
            }                                   // square's toString() method.
            out+="\n";
        }
        return out;
    }
}

public class MineSweeper{
    //our public main class that is actually the game and contains the main()
    // which creates a MineSweeper object to play.
    
    MineBoard game;
    
    public MineSweeper(int rows, int cols, int mines) throws IOException{
        //the constructor that plays the game.
        int r,c;
        StringTokenizer strtok;
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        game = new MineBoard(rows,cols,mines);
        boolean won=false;
        
        //this do-while loop takes in user input and reveals the appropriate
        // square, quitting when a mine is hit or win state is achieved
        do{
            System.out.println(game);
            System.out.print("Enter row followed by column (both on this line)>");
            
            //I tokenize the input line since i ask for row and column on one line.
            //the if-else is just for if there is not enough tokens (bad user input).
            // if so, it puts ineffective values into r,c, which reveal() will just
            // disregard, thus continuing the loop for more input.
            strtok=new StringTokenizer(in.readLine(), " ,");
            if (!strtok.hasMoreTokens()) r=-1;
            else r=Integer.parseInt(strtok.nextToken());
            if (!strtok.hasMoreTokens()) c=-1;
            else c=Integer.parseInt(strtok.nextToken());
          
        } while (game.reveal(r,c) && !(won=game.hasWon()));
        
        for (r=0;r<rows;r++)            //just to reveal
             for (c=0;c<cols;c++)       // the rest of the 
                game.reveal(r,c);       // board to show
        System.out.println(game);       // at the end.
        
        if (won){
            System.out.println(" **Congratulations!!**\n    You've won!");
        }
        else{
             System.out.println(" ** Oops! **\n  You LOST!");
        }
    }
    public static void main(String args[])throws IOException{
        //the "main" that is executed.  The default values for number of
        // rows, columns, and mines is assigned and overwritten is supplied
        // via arguments.
        
        int r=5,c=5,n=6;
        if (args.length==3){
            r=Integer.parseInt(args[0]);
            c=Integer.parseInt(args[1]);
            n=Integer.parseInt(args[2]);
            
        }
        new MineSweeper(r,c,n);
    }
}
