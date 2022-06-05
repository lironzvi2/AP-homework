package algorithms.mazeGenerators;

import algorithms.search.AState;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {
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
    @Override
    public boolean equals(Object sec_pos){
        boolean equal;
        if(sec_pos!= null && sec_pos.getClass() == this.getClass())
        {
            Position as = (Position) sec_pos;
            equal = as.row==this.row&&as.column==this.column;
        }
        else if(sec_pos == this){
            equal = true;
        }
        else{
            equal = false;
        }
        return equal;
    }
    public int getColumn(){return column;}
    public int getRow(){return row;}

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }
}
