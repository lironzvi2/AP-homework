package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState {

    private Position p;

    public MazeState(Position p){
        super(null, 0);
        Position pCopy = new Position(p.getRowIndex(), p.getColumnIndex());
        this.p = pCopy;
    }

    public Position getPosition() {
        return p;
    }

    public void setPosition(Position p) {
        if(null != p){
            this.p = p;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MazeState mazeState = (MazeState) o;
        return Objects.equals(p, mazeState.p);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), p);
    }
}
