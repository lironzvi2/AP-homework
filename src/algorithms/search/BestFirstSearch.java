package algorithms.search;

import java.util.*;

public class BestFirstSearch extends  ASearchingAlgorithm {
    String name;
    Solution mazeSolution;
    ISearchable maze;

    public BestFirstSearch(){
        super();
        this.name = "BestFirstSearch";
    }

    public String getName(){
        return this.name;
    }

    public Solution solve(ISearchable maze){
        PriorityQueue<AState> states = new PriorityQueue(new AStatePriorityCompare());
        HashSet<AState> visited = new HashSet<>();
        states.add(maze.getStartState());
        visited.add(maze.getStartState());
        nodesEvaluated +=1;
        while(states.size()!=0) {
            AState curr_state = states.poll();
            if(curr_state.equals(maze.getGoalState())){ //if found goal state
                return new Solution(curr_state);
            }
            ArrayList<AState> neighbors = maze.getAllStates(curr_state); //get states
            nodesEvaluated += neighbors.size(); //add number of states evaluated
            for(AState neighbor:neighbors){
                if(!visited.contains(neighbor)){ //if not visited
                    neighbor.setParent(curr_state);
                    visited.add(neighbor);
                    states.add(neighbor);
                    if(neighbor.equals(maze.getGoalState())){ //if got to goal state
                        return new Solution(neighbor);
                    }
                }
            }
        }
        return new Solution(maze.getGoalState());
    }
}
