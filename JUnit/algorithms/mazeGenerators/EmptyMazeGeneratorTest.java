package algorithms.mazeGenerators;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

    public class EmptyMazeGeneratorTest {
        @Test
        public void testGenerateInTime(){
            EmptyMazeGenerator EmptyMazeGenerator = new EmptyMazeGenerator();
            long timeGenerated = EmptyMazeGenerator.measureAlgorithmTimeMillis(1000,1000);
            assertTrue(timeGenerated<60*1000);
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

