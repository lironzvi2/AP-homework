import algorithms.mazeGenerators.Maze;

public interface IMazeGenerator {
    public Maze generate(int rows, int lines);

    public long measureAlgorithmTimeMillis(int rows, int lines);
}