import algorithms.mazeGenerators.Maze;

public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int lines) {
        Maze maze = null;
        return maze;
    }

    @Override
    public long measureAlgorithmTimeMillis(int rows, int lines) {
        return 0;
    }
}
