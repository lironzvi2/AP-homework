package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        if(rows<2 || columns<2){//if parameters are wrong
            rows=2;
            columns=2;
        }
        Maze emptyMaze = new Maze(rows, columns);
        return emptyMaze;
    }
}
