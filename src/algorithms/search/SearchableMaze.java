package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {
    private Maze maze;
    private final AState goalState;
    private final AState startState;
    public SearchableMaze(Maze maze){
        this.maze = maze;
        goalState = new AState(maze.getGoalPosition(),1);
        startState = new AState(maze.getStartPosition(),1);
    }
    @Override
    public AState getGoalState() {
        return goalState;
    }

    @Override
    public AState getStartState() {
        return startState;
    }

    @Override
    public ArrayList<AState> getAllStates(AState state) {
        ArrayList<AState> neighbors = new ArrayList<>();
        Position pos = (Position)state.getState();
        int[][] mazeArray = maze.getMaze();
        // check upper position
        try{
            if(mazeArray[pos.getRow()-1][pos.getColumn()]==1){ //part of maze
                Position upperPos = new Position(pos.getRow()-1, pos.getColumn());
                neighbors.add(new AState(upperPos,1));
            }
        }
        catch (Exception e){ //continue

        }
        // check down position
        try{
            if(mazeArray[pos.getRow()+1][pos.getColumn()]==1){ //part of maze
                Position downPos = new Position(pos.getRow()+1, pos.getColumn());
                neighbors.add(new AState(downPos,1));
            }
        }
        catch (Exception e){ //continue

        }
        // check right position
        try{
            if(mazeArray[pos.getRow()][pos.getColumn()+1]==1){ //part of maze
                Position rightPos = new Position(pos.getRow(), pos.getColumn()+1);
                neighbors.add(new AState(rightPos,1));
            }
        }
        catch (Exception e){ //continue

        }
        // check left position
        try{
            if(mazeArray[pos.getRow()][pos.getColumn()-1]==1){ //part of maze
                Position leftPos = new Position(pos.getRow(), pos.getColumn()-1);
                neighbors.add(new AState(leftPos,1));
            }
        }
        catch (Exception e){ //continue

        }
        return neighbors;
    }
}
