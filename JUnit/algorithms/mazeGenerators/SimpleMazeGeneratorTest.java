package algorithms.mazeGenerators;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SimpleMazeGeneratorTest {
    @Test
    public void testGenerateInTime(){
        SimpleMazeGenerator SimpleMazeGenerator = new SimpleMazeGenerator();
        long timeGenerated = SimpleMazeGenerator.measureAlgorithmTimeMillis(1000,1000);
        assertTrue(timeGenerated<60*1000);
    }
    @Test
    public void testStartEndPlaceIsOnMaze(){
        SimpleMazeGenerator SimpleMazeGenerator = new SimpleMazeGenerator();
        Maze maze = SimpleMazeGenerator.generate(1000,1000);
        Position startP = maze.startP;
        Position endP = maze.endP;
        assertTrue(maze.maze[startP.row][startP.column]==0&&maze.maze[endP.row][endP.column]==0);
    }

    @Test
    public void testBadArguments(){
        SimpleMazeGenerator SimpleMazeGenerator = new SimpleMazeGenerator();
        Maze maze = SimpleMazeGenerator.generate(0,1);
        assertTrue(maze.maze.length==2&&maze.maze[0].length==2);
        maze = SimpleMazeGenerator.generate(1,0);
        assertTrue(maze.maze.length==2&&maze.maze[0].length==2);
    }
}