import algorithms.mazeGenerators.Maze;
import java.lang.System;
public abstract class AMazeGenerator implements IMazeGenerator {
    public abstract Maze generate(int rows, int lines);

    public long measureAlgorithmTimeMillis(int rows, int lines) {
        // save current time before generate, call generate, check time after function and return sub.
        long before_generate = System.currentTimeMillis();
        generate(rows,lines);
        long after_generate = System.currentTimeMillis();
        return after_generate - before_generate;
    }
}
