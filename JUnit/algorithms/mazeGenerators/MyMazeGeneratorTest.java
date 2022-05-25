package algorithms.mazeGenerators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMazeGeneratorTest {
    @Test
    public void testGenerateInTime(){
        MyMazeGenerator myMazeGenerator = new MyMazeGenerator();
        long timeGenerated = myMazeGenerator.measureAlgorithmTimeMillis(1000,1000);
        assertTrue(timeGenerated<60*1000);
    }
    @Test
    public void testStartEndPlaceIsOnMaze(){
        MyMazeGenerator mazeGenerator = new MyMazeGenerator();
        Maze maze = mazeGenerator.generate(1000,1000);
        Position startP = maze.startP;
        Position endP = maze.endP;
        assertTrue(maze.maze[startP.row][startP.column]==0&&maze.maze[endP.row][endP.column]==0);
    }

}