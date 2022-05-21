package algorithms.search;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.Maze;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BestFirstSearch extends  ASearchingAlgorithm {
    String name;

    public BestFirstSearch(){
        super();
        this.name = "BestFirstSearch";
    }

    public String getName(){
        return this.name;
    }

    public int priorityQueueCompare(AState s1, AState s2){
        return s1.getCost() - s2.getCost();
    }
    public Solution solve(ISearchable maze){
        AState startPosition = maze.getStartState();
        AState endPosition = maze.getGoalState();
        PriorityQueue<AState> begins = new PriorityQueue<>();

        Map<Integer, AState> ending = new HashMap<>();
        Map<Integer, AState> newMap = new HashMap<>();
        ending.put(maze.getStartState().hashCode(), maze.getStartState());




    }
}
