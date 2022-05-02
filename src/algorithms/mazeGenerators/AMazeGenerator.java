package algorithms.mazeGenerators;

import java.lang.System;
public abstract class AMazeGenerator implements IMazeGenerator {

    public abstract Maze generate(int rows, int columns);

    public long measureAlgorithmTimeMillis(int rows, int columns) {
        // save current time before generate, call generate, check time after function and return sub.
        long before_generate = System.currentTimeMillis();
        generate(rows, columns);
        long after_generate = System.currentTimeMillis();
        return after_generate - before_generate;
    }
}
