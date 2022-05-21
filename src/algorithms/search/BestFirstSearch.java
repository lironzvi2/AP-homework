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

    /*public Solution solve(ISearchable maze){
        Map<String, Boolean> beenStates = new HashMap<>();
        this.nodesEvaluated = 0;
        PriorityQueue<AState> priorityQueueStates = new PriorityQueue(new AStatePriorityCompare());
        priorityQueueStates.add(maze.getStartState());
        beenStates.put(maze.getStartState().toString(), true);
        Solution ending = new BreadthFirstSearch().solve(maze, priorityQueueStates);
        return mazeSolution;
    }*/

    public Solution solve(ISearchable maze){
        AState startPosition = maze.getStartState();
        AState endPosition = maze.getGoalState();
        PriorityQueue<AState> begins = new PriorityQueue(new AStatePriorityCompare());
        ArrayList<AState> statesPerents = new ArrayList<>();
        Map<Integer, AState> ending = new HashMap<>();
        Map<Integer, AState> newMap = new HashMap<>();
        ending.put(maze.getStartState().hashCode(), maze.getStartState());
        begins.add(maze.getStartState());
        AState curState;
        while(begins.size() > 0){
            curState = begins.poll();
            ending.put(curState.hashCode(), curState);
            statesPerents = maze.getAllStates(curState);

            if (maze.getStartState().equals(curState)){
                return this.mazeSolution;
            }
            Iterator iteratorToAllParentsStates = statesPerents.iterator();

            while(iteratorToAllParentsStates.hasNext()){
                AState curAdj = (AState) iteratorToAllParentsStates.next();
                if( !ending.containsKey(curAdj.hashCode())){
                    double newCost = curState.getCost() + curAdj.getCost();
                    AState adjFromMap = (AState)newMap.get(curAdj.hashCode());
                    if(adjFromMap.getCost() > newCost){
                        adjFromMap.setParent(curState);
                        adjFromMap.setCost(newCost);
                    }
                    else if(!newMap.containsKey(curAdj.hashCode())){
                        curAdj.setParent((curState));
                        curAdj.setCost(newCost);
                        newMap.put(curAdj.hashCode(), curAdj);
                    }
                }
            }

        }
        return null;
    }
}
