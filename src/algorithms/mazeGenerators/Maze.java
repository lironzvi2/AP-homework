package algorithms.mazeGenerators;


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
        maze = new int[rows][columns];
    }

    public Maze(int rows, int columns){
        this.numRows = rows;
        this.numColumns = columns;
        this.startP = new Position(0,0);
        this.endP = new Position(0,0);
        maze = new int[rows][columns];
    }

    public Maze(int[][] maze){
        this.maze = maze;
        this.numRows = maze.length;
        this.numColumns = maze[0].length;
        this.startP = new Position(0,0);
        this.endP = new Position(0,0);
    }
}
