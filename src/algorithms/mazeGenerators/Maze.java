package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class Maze {
    int numRows;
    int numColumns;
    Position startP;
    Position endP;
    int[][] maze;

    public Maze(int rows, int columns, Position startP, Position endP) {
        this.startP = startP;
        this.endP = endP;
        this.numRows = rows;
        this.numColumns = columns;
        this.maze = new int[numRows][numColumns];
    }

    public Maze(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        this.startP = new Position(0, 0);
        this.endP = new Position(0, 0);
        this.maze = new int[numRows][numColumns];
    }

    public Maze(int[][] maze) {
        this.maze = maze;
        this.numRows = maze.length;
        this.numColumns = maze[0].length;
        this.startP = new Position(0, 0);
        this.endP = new Position(0, 0);
    }

    public Maze(byte[] mazeInByte) {
        if (mazeInByte == null)
            return;

        int rows = Byte.toUnsignedInt(mazeInByte[0]) * 256 + Byte.toUnsignedInt(mazeInByte[1]);
        int cols = Byte.toUnsignedInt(mazeInByte[2]) * 256 + Byte.toUnsignedInt(mazeInByte[3]);
        if (rows < 2 || cols < 2){
            rows = 2;
            cols = 2;
        }

        int [][] newMaze = new int[rows][cols];

        int row= Byte.toUnsignedInt(mazeInByte[4])*256+Byte.toUnsignedInt(mazeInByte[5]);
        int col= Byte.toUnsignedInt(mazeInByte[6])*256+Byte.toUnsignedInt(mazeInByte[7]);
        if(row<0 || row>=rows || col<0 || col>=cols)
            return;
        Position s = new Position(row,col);

        row= Byte.toUnsignedInt(mazeInByte[8])*256+Byte.toUnsignedInt(mazeInByte[9]);
        col= Byte.toUnsignedInt(mazeInByte[10])*256+Byte.toUnsignedInt(mazeInByte[11]);
        if(row<0 || row>=rows || col<0 || col>=cols)
            return;
        Position e = new Position(row,col);

        int convertedPosition;
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++) {
                convertedPosition = 12 + j + i * cols;
                newMaze[i][j] = mazeInByte[convertedPosition];
            }
        }

        this.maze = newMaze;
        this.startP = s;
        this.endP = e;
        this.numRows = rows;
        this.numColumns = cols;
}

    /* wall :
     *     0
     *   1   2
     *     3
     * */

    public Position[] GetStartAndEndPosition() {
        Position[] startEndPositions = new Position[2];
        int i;
        int wall = new Random().nextInt(4);

        if (wall == 0) {
            i = new Random().nextInt(this.numColumns);
            startEndPositions[0] = new Position(0, i);
            i = new Random().nextInt(this.numColumns);
            startEndPositions[1] = new Position(this.numRows - 1, i);
        } else if (wall == 3) {
            i = new Random().nextInt(this.numColumns);
            startEndPositions[0] = new Position(this.numRows - 1, i);
            i = new Random().nextInt(this.numColumns);
            startEndPositions[1] = new Position(0, i);
        } else if (wall == 2) {
            i = new Random().nextInt(this.numRows);
            startEndPositions[0] = new Position(i, this.numColumns - 1);
            i = new Random().nextInt(this.numRows);
            startEndPositions[1] = new Position(i, 0);
        } else {
            i = new Random().nextInt(this.numRows);
            startEndPositions[0] = new Position(i, 0);
            i = new Random().nextInt(this.numRows);
            startEndPositions[1] = new Position(i, this.numColumns - 1);
        }
        return startEndPositions;
    }

    public void SetPositionToVal(Position p, int val) {

        this.maze[p.row][p.column] = val;
    }

    public void SetRowColVal(int row, int col, int val) {

        this.maze[row][col] = val;
    }

    public String ToString() {
        String s = "";

        for (int row = 0; row < this.numRows; row++) {
            for (int col = 0; col < this.numColumns; col++) {
                if (startP.row == row && startP.column == col) {
                    s += "S";
                } else if (endP.row == row && endP.column == col) {
                    s += "E";
                } else {
                    s += this.maze[row][col];
                }
            }
            s += "\n";
        }
        return s;
    }

    public void print() {

        System.out.print(this.ToString());
    }

    public Position getStartPosition() {

        return this.startP;
    }

    public Position getGoalPosition() {

        return this.endP;
    }

    public int[][] getMaze() {
        return maze;
    }

    public byte[] toByteArray(){

        ArrayList<Byte> lenArr = new ArrayList<>();
        addToByteList(numRows,lenArr);
        addToByteList(numColumns,lenArr);
        addToByteList(startP.getRowIndex(),lenArr);
        addToByteList(startP.getColumnIndex(),lenArr);
        addToByteList(endP.getRowIndex(),lenArr);
        addToByteList(endP.getColumnIndex(),lenArr);

        int lenBArr = numRows*numColumns+12;
        byte[] byteArray = new byte[lenBArr];
        for(int i=0;i<12;i++){
            byteArray[i]=lenArr.get(i);
        }

        for(int i=0;i<numRows;i++) {
            for(int j=0;j<numColumns;j++) {
                byteArray[i * numColumns + j + 12] = (byte) maze[i][j];
            }
        }
        return byteArray;
    }

    private void addToByteList(int len,ArrayList<Byte> arrLen){
        byte divide = (byte)(len/256);
        byte modulo = (byte)(len%256);
        arrLen.add(divide);
        arrLen.add(modulo);
    }
}