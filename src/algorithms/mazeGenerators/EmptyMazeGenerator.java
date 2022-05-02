package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        Maze maze = null;
        return maze;
    }

    @Override
    public long measureAlgorithmTimeMillis(int rows, int columns) {
        return 0;
    }
}
