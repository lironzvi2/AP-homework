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
            if(mazeArray[pos.getRow()-1][pos.getColumn()]==0){ //part of maze
                Position upperPos = new Position(pos.getRow()-1, pos.getColumn());
                neighbors.add(new AState(upperPos,1));
            }
        }
        catch (Exception e){ //continue

        }
        // check down position
        try{
            if(mazeArray[pos.getRow()+1][pos.getColumn()]==0){ //part of maze
                Position downPos = new Position(pos.getRow()+1, pos.getColumn());
                neighbors.add(new AState(downPos,1));
            }
        }
        catch (Exception e){ //continue

        }
        // check right position
        try{
            if(mazeArray[pos.getRow()][pos.getColumn()+1]==0){ //part of maze
                Position rightPos = new Position(pos.getRow(), pos.getColumn()+1);
                neighbors.add(new AState(rightPos,1));
            }
        }
        catch (Exception e){ //continue

        }
        // check left position
        try{
            if(mazeArray[pos.getRow()][pos.getColumn()-1]==0){ //part of maze
                Position leftPos = new Position(pos.getRow(), pos.getColumn()-1);
                neighbors.add(new AState(leftPos,1));
            }
        }
        catch (Exception e){ //continue

        }
        // check Diagonals
        //down right diagonal
        try{
            if(mazeArray[pos.getRow()+1][pos.getColumn()+1]==0){
                if(mazeArray[pos.getRow()][pos.getColumn()+1]==0||mazeArray[pos.getRow()+1][pos.getColumn()]==0){
                    Position downDialPos = new Position(pos.getRow()+1,pos.getColumn()+1);
                    neighbors.add(new AState(downDialPos,1.5));
                }
            }
        }
        catch (Exception e){//continue

        }
        //upper right diagonal
        try{
            if(mazeArray[pos.getRow()-1][pos.getColumn()+1]==0){
                if(mazeArray[pos.getRow()][pos.getColumn()+1]==0||mazeArray[pos.getRow()-1][pos.getColumn()]==0){
                    Position upperRightDialPos = new Position(pos.getRow()-1,pos.getColumn()+1);
                    neighbors.add(new AState(upperRightDialPos,1.5));
                }
            }
        }
        catch (Exception e){//continue

        }
        //upper left diagonal
        try{
            if(mazeArray[pos.getRow()-1][pos.getColumn()-1]==0){
                if(mazeArray[pos.getRow()][pos.getColumn()-1]==0||mazeArray[pos.getRow()-1][pos.getColumn()]==0){
                    Position upperLeftDialPos = new Position(pos.getRow()-1,pos.getColumn()-1);
                    neighbors.add(new AState(upperLeftDialPos,1.5));
                }
            }
        }
        catch (Exception e){//continue

        }
        //down left diagonal
        try{
            if(mazeArray[pos.getRow()+1][pos.getColumn()-1]==0){
                if(mazeArray[pos.getRow()][pos.getColumn()-1]==0||mazeArray[pos.getRow()+1][pos.getColumn()]==0){
                    Position downLeftDialPos = new Position(pos.getRow()+1,pos.getColumn()-1);
                    neighbors.add(new AState(downLeftDialPos,1.5));
                }
            }
        }
        catch (Exception e){//continue

        }
        return neighbors;
    }

}
