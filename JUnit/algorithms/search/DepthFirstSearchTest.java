package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

class DepthFirstSearchTest {

    @Test
    void solve() {
        MyMazeGenerator myMazeGenerator = new MyMazeGenerator();
        Maze maze = myMazeGenerator.generate(1000,1000);
        //get start and end position
        Position startP = maze.getStartPosition();
        Position endP = maze.getGoalPosition();
        //create dfs solver and solve
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        Solution solution = depthFirstSearch.solve(searchableMaze);
        //check we got same start position and end position
        ArrayList<AState> positions = solution.getSolutionPath();
        assertTrue(positions.get(0).getState().equals(startP)&&positions.get(positions.size()-1)
                .getState().equals(endP));
    }
}