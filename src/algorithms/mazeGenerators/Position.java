package algorithms.mazeGenerators;

public class Position {
    int column;
    int row;

    public Position(int row, int col){
        this.row = row;
        this.column = col;
    }

    @Override
    public String toString() {
        return "{" + row + "," + column + "}";
    }

    public int getColumnIndex() {
        return column;
    }

    public int getRowIndex() {
        return row;
    }
}
