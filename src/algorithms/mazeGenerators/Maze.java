package algorithms.mazeGenerators;

import javax.swing.text.Position;

public class Maze {
    int numRows;
    int numColumns;
    Position startP;
    Position endP;

    public Maze(int rows, int columns, Position startP, Position endP ){
        this.startP =startP;
        this.endP = endP;
        this.numRows = rows;
        this.numColumns = columns;
    }

    public Maze(int rows, int columns){
        this.numRows = rows;
        this.numColumns = columns;
    }
}
