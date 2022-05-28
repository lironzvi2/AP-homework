package algorithms.search;

        import algorithms.mazeGenerators.Maze;
        import algorithms.mazeGenerators.MyMazeGenerator;
        import algorithms.mazeGenerators.Position;
        import org.junit.Test;

        import java.util.ArrayList;

        import static org.junit.Assert.assertTrue;

public class BestFirstSearchTest {

    @Test
    public void solve() {
        MyMazeGenerator myMazeGenerator = new MyMazeGenerator();
        Maze maze = myMazeGenerator.generate(1000,1000);
        //get start and end position
        Position startP = maze.getStartPosition();
        Position endP = maze.getGoalPosition();
        //create bestSearch solver and solve
        BestFirstSearch BestFirstSearch = new BestFirstSearch();
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        Solution solution = BestFirstSearch.solve(searchableMaze);
        //check we got same start position and end position
        ArrayList<AState> positions = solution.getSolutionPath();
        assertTrue(positions.get(0).getState().equals(startP)&&positions.get(positions.size()-1)
                .getState().equals(endP));
    }
}