package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        Maze emptyMaze = new Maze(rows, columns);
        return emptyMaze;
    }
}
