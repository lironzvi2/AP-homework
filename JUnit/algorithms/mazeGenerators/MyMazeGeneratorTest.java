package algorithms.mazeGenerators;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MyMazeGeneratorTest {
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

    @Test
    public void testBadArguments(){
        MyMazeGenerator myMazeGenerator = new MyMazeGenerator();
        Maze maze = myMazeGenerator.generate(0,1);
        assertTrue(maze.maze.length==2&&maze.maze[0].length==2);
        maze = myMazeGenerator.generate(1,0);
        assertTrue(maze.maze.length==2&&maze.maze[0].length==2);
    }
}
