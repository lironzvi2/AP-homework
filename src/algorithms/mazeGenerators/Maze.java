package algorithms.mazeGenerators;

import java.util.Random;

public class Maze {
    int numRows;
    int numColumns;
    Position startP;
    Position endP;
    int[][] maze;

    public Maze(int rows, int columns, Position startP, Position endP ){
        this.startP =startP;
        this.endP = endP;
        this.numRows = rows;
        this.numColumns = columns;
        this.maze = new int [numRows][numColumns];
    }

    public Maze(int rows, int columns){
        this.numRows = rows;
        this.numColumns = columns;
        this.startP = new Position(0,0);
        this.endP = new Position(0,0);
        this.maze = new int [numRows][numColumns];
    }

    public Maze(int[][] maze){
        this.maze = maze;
        this.numRows = maze.length;
        this.numColumns = maze[0].length;
        this.startP = new Position(0,0);
        this.endP = new Position(0,0);
    }

/* wall :
*     0
*   1   2
*     3
* */

    public Position[] GetStartAndEndPosition(){
        Position[] startEndPositions = new Position[2];
        int i;
        int wall = new Random().nextInt(4);

        if (wall == 0){
            i = new Random().nextInt(this.numColumns);
            startEndPositions[0] = new Position(0, i);
            i = new Random().nextInt(this.numColumns);
            startEndPositions[1] = new Position(this.numRows - 1, i);
        }
        else if(wall == 3){
            i = new Random().nextInt(this.numColumns);
            startEndPositions[0] = new Position(this.numRows - 1, i);
            i = new Random().nextInt(this.numColumns);
            startEndPositions[1] = new Position(0, i);
        }

        else if(wall == 2){
            i = new Random().nextInt(this.numRows);
            startEndPositions[0] = new Position(i, this.numColumns - 1);
            i = new Random().nextInt(this.numRows);
            startEndPositions[1] = new Position(i, 0);
        }
        else
        {
            i = new Random().nextInt(this.numRows);
            startEndPositions[0] = new Position(i, 0);
            i = new Random().nextInt(this.numRows);
            startEndPositions[1] = new Position(i, this.numColumns - 1);
        }
        return startEndPositions;
    }

    public void SetPositionToVal(Position p, int val){
        this.maze[p.row][p.col] = val;
    }

    public void SetRowColVal(int row, int col, int val){
        this.maze[row][col] = val;
    }

    public String ToString(){
        String s ="";

        for(int row = 0; row < this.numRows ; row++)
        {
            for (int col = 0; col < this.numColumns ; col++)
            {
                if (startP.row == row && startP.col == col)
                {
                    s += "s" ;
                }
                else if (endP.row == row && endP.col == col)
                {
                    s += "e" ;
                }
                else
                {
                    s+= this.maze[row][col];
                }
            }
            s += "\n";
        }
        return s;
    }

    public void print(){
        System.out.print(this.ToString());
    }

    public Position getStartPosition(){
        return this.startP;
    }

    public Position getGoalPosition(){
        return this.endP;
    }
}
