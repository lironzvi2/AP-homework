package algorithms.mazeGenerators;

public class Position {
    int col;
    int row;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
    public boolean isEquals(Position sec_pos){
        return sec_pos.row == this.row && sec_pos.col == this.col;
    }
}
