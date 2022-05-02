package algorithms.mazeGenerators;

import algorithms.mazeGenerators.Maze;

public interface IMazeGenerator {
    Maze generate(int rows, int columns);
    long measureAlgorithmTimeMillis(int rows, int columns);
}