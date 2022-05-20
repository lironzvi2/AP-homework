package algorithms.search;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {
    public DepthFirstSearch(){
        nodesEvaluated = 0;
        mazeName = "dfs";
    }
    @Override
    public Solution solve(ISearchable maze) {
        Stack<AState> states = new Stack<AState>();
        ArrayList<AState> visited = new ArrayList<>();
        visited.add(maze.getStartState());
        states.push(maze.getStartState());
        nodesEvaluated += 1;
        while (states.size()>0){ //while there are nodes in stack
            AState currState = states.pop(); //get next state
            //get neighbors
            ArrayList<AState> neighbors = maze.getAllStates(currState);
            nodesEvaluated += neighbors.size();
            //foreach neighbor check if found if not set parent to this and enter to stack and visited
            for(AState neighbor:neighbors){
                if(!visited.contains(neighbor)){
                    neighbor.setParent(currState);
                    states.push(neighbor);
                    visited.add(neighbor);
                    //if found goal state finish and return solution
                    if(neighbor.equals(maze.getGoalState())){
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
