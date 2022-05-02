package algorithms.mazeGenerators;

import algorithms.mazeGenerators.Maze;

public interface IMazeGenerator {
    public Maze generate(int rows, int columns);
    public long measureAlgorithmTimeMillis(int rows, int columns);
}