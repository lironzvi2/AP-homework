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

    }

