package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.util.ArrayList;
import java.util.HashSet;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    public BreadthFirstSearch(){
        nodesEvaluated = 0;
        mazeName = "bfs";
    }
    @Override
    public Solution solve(ISearchable maze) {
        ArrayList<AState> states = new ArrayList<>();
        HashSet<AState> visited = new HashSet<>();
        states.add(maze.getStartState());
        visited.add(maze.getStartState());
        nodesEvaluated +=1;
        while(states.size()!=0) {
            AState curr_state = states.remove(0);
            if(curr_state.equals(maze.getGoalState())){ //if found goal state
                return new Solution(curr_state);
            }
            ArrayList<AState> neighbors = maze.getAllStates(curr_state); //get states
            nodesEvaluated += 1; //add number of states evaluated
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

    @Override
    public String getName() {
        return mazeName;
    }
}
