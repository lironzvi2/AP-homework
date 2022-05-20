package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        Random rand = new Random();
        Maze my_maze;
        ArrayList<Position> positions = new ArrayList<Position>();
        Position curr_pos;
        //create maze full of 1's
        int[][] prim_maze = new int[rows][columns];
        generate_maze(prim_maze,rows,columns);
        // random first position and enter array list
        int rand_row = rand.nextInt(rows);
        int rand_column = rand.nextInt(columns);
        curr_pos = new Position(rand_row,rand_column);
        prim_maze[curr_pos.row][curr_pos.column] = 0; //create first part of maze
        add_neighbors_to_list(prim_maze,positions,curr_pos,rows,columns);
        //run while array list isn't empty
        while(!positions.isEmpty()){
            int rand_index = rand.nextInt(positions.size()); // get random in positions array
            curr_pos = positions.get(rand_index);
            //find path to maze and add curr position to maze
            if(prim_maze[curr_pos.row][curr_pos.column]==1){  //if curr pos is wall
                add_neighbors_to_list(prim_maze,positions,curr_pos,rows,columns); //add neighbors to list
                prim_maze[curr_pos.row][curr_pos.column] = 0; //change to passage
                Position route = find_route(prim_maze,curr_pos);
                prim_maze[route.row][route.column] = 0; //create route from maze to current position
                positions.remove(curr_pos); //remove current pos from maze
            }
            else{
                positions.remove(curr_pos); //remove current pos from maze
            }
        }
        // create new maze and make end and start position
        my_maze = new Maze(prim_maze);
        Position[] end_start = getStartAndEndPos(my_maze);
        my_maze.startP = end_start[0];
        my_maze.endP = end_start[1];
        return my_maze;
    }
    // gets curr position the maze and maze's number of rows and numbers adds to array list curr pos neighbors that are walls
    private void add_neighbors_to_list(int[][]prim_maze,ArrayList<Position> positions, Position curr_pos,int rows,int columns){
        // add above the curr_pos
        if (curr_pos.row+2 <rows){
            if(prim_maze[curr_pos.row+2][curr_pos.column]!= 0) //if wall add to walls list
            positions.add(new Position(curr_pos.row+2,curr_pos.column));
        }
        if (curr_pos.row-2 >=0){ //add below curr_pos
            if(prim_maze[curr_pos.row-2][curr_pos.column]!= 0) //if wall add to walls list
            positions.add(new Position(curr_pos.row-2,curr_pos.column));
        }
        if (curr_pos.column-2 >=0){ //add right to curr_pos
            if(prim_maze[curr_pos.row][curr_pos.column-2]!= 0) //if wall add to walls list
                positions.add(new Position(curr_pos.row,curr_pos.column-2));
        }
        if (curr_pos.column+2<columns){
            if(prim_maze[curr_pos.row][curr_pos.column+2]!= 0) //if wall add to walls list
                positions.add(new Position(curr_pos.row,curr_pos.column+2));
        }
    }
    private Position find_route(int[][] maze, Position curr_pos){
        Random rand = new Random();
        Position to_return = null;
        int rand_connect = rand.nextInt(4);
        try{ //if maze above curr position
            if(maze[curr_pos.row-2][curr_pos.column]==0){
                if(rand_connect == 0)
                return new Position(curr_pos.row-1,curr_pos.column );
                to_return = new Position(curr_pos.row-1,curr_pos.column);
                rand_connect--;
            }
        }
        catch (Exception e){ //do nothing

        }
        try{ //if maze below curr position
            if(maze[curr_pos.row+2][curr_pos.column]==0){
                if(rand_connect==0)
                return new Position(curr_pos.row+1,curr_pos.column );
                to_return = new Position(curr_pos.row+1,curr_pos.column);
                rand_connect--;
            }
        }
        catch (Exception e){ //do nothing

        }
        try{ //if maze is right to curr position
            if(maze[curr_pos.row][curr_pos.column+2]==0){
                if(rand_connect == 0)
                return new Position(curr_pos.row,curr_pos.column+1);
                to_return = new Position(curr_pos.row,curr_pos.column+1);
                rand_connect --;
            }
        }
        catch (Exception e){ //do nothing

        }

        try{ //if maze is right to curr position
            if(maze[curr_pos.row][curr_pos.column-2]==0){
                if(rand_connect == 0)
                    return new Position(curr_pos.row,curr_pos.column-1);
                to_return = new Position(curr_pos.row,curr_pos.column-1);
            }
        }
        catch (Exception e){ //do nothing

        }
        if (to_return != null){ //if found path not at the edge of the array
            return to_return;
        }
        // checking edges of array near pos
        if(curr_pos.row-2==-1){
            if(rand_connect == 0)
            {
                return new Position(0,curr_pos.column );
            }
            to_return = new Position(0,curr_pos.column);
            rand_connect--;
        }
        if(curr_pos.row+2== maze.length){
            if(rand_connect == 0)
            {
                return new Position(curr_pos.row+1,curr_pos.column );
            }
            to_return = new Position(curr_pos.row+1,curr_pos.column);
            rand_connect--;
        }
        if(curr_pos.column+2==maze[0].length){
            if(rand_connect == 0)
            {
                return new Position(curr_pos.row,curr_pos.column+1);
            }
            to_return = new Position(curr_pos.row,curr_pos.column+1);
            rand_connect--;
        }
        if(curr_pos.column-2==-1){
            if(rand_connect == 0)
            {
                return new Position(curr_pos.row, 0);
            }
            to_return = new Position(curr_pos.row, 0);
        }
        return to_return;
    }
    private void generate_maze(int[][] maze,int rows,int columns){
        for(int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                maze[i][j] = 1;
            }
        }
    }
    private Position[] getStartAndEndPos(Maze maze){
        int[][] mazeArray = maze.maze;
        ArrayList<Position> edgesInMaze = new ArrayList<>();
        // add top row
        for(int i=0;i<mazeArray[0].length;i++){
            if(mazeArray[0][i] == 1){ //if is part of maze
                edgesInMaze.add(new Position(0,i));
            }
        }
        // add bottom row if has more than one row
        if(mazeArray.length>1){
            for(int i=0;i<mazeArray[0].length;i++){
                if(mazeArray[mazeArray.length-1][i]==1){
                    edgesInMaze.add(new Position(mazeArray.length-1,i));
                }
            }
        }
        // add left edge if has more than one row
        if(mazeArray.length>1){
            for(int i=0;i<mazeArray.length;i++){
                if(mazeArray[i][0]==1){
                    edgesInMaze.add(new Position(i,0));
                }
            }
        }
        // add right edge if has more than one row and more than one column
        if(mazeArray.length>1 && mazeArray[0].length>1){
            for(int i=0;i<mazeArray.length;i++){
                if(mazeArray[i][mazeArray[0].length-1]==1){
                    edgesInMaze.add(new Position(i,mazeArray[0].length-1));
                }
            }
        }
        Random rand = new Random();
        int first_pos = rand.nextInt(edgesInMaze.size());
        int second_pos = rand.nextInt(edgesInMaze.size());
        while(second_pos == first_pos){ //get 2 different positions
            if(edgesInMaze.size() == 1){ //if only one edge is in maze
                break;
            }
            second_pos = rand.nextInt(edgesInMaze.size());
        }
        Position[] to_return = new Position[2];
        to_return[0] = edgesInMaze.get(first_pos);
        to_return[1] = edgesInMaze.get(second_pos);
        return to_return;
    }

}
