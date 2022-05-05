package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        Random rand = new Random();
        Maze my_maze = new Maze(rows,columns);
        ArrayList<Position> positions = new ArrayList<Position>();
        Position curr_pos;
        //create maze full of 1's
        int[][] prim_maze = new int[rows][columns];
        generate_maze(prim_maze,rows,columns);
        // random first position and enter array list
        int rand_row = rand.nextInt(rows);
        int rand_column = rand.nextInt(columns);
        curr_pos = new Position(rand_row,rand_column);
        prim_maze[curr_pos.row][curr_pos.col] = 0; //create first part of maze
        add_neighbors_to_list(prim_maze,positions,curr_pos,rows,columns);
        //run while array list isn't empty
        while(!positions.isEmpty()){
            int rand_index = rand.nextInt(positions.size()); // get random in positions array
            curr_pos = positions.get(rand_index);
            //find path to maze and add curr position to maze
            if(prim_maze[curr_pos.row][curr_pos.col]==1){  //if curr pos is wall
                add_neighbors_to_list(prim_maze,positions,curr_pos,rows,columns); //add neighbors to list
                prim_maze[curr_pos.row][curr_pos.col] = 0; //change to passage
                Position route = find_route(prim_maze,curr_pos);
                prim_maze[route.row][route.col] = 0; //create route from maze to current position
                positions.remove(curr_pos); //remove current pos from maze
            }
            else{
                positions.remove(curr_pos); //remove current pos from maze
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(prim_maze[i][j]);
            }
            System.out.print("\n");
        }
        my_maze.maze = prim_maze;
        return my_maze;
    }
    // gets curr position the maze and maze's number of rows and numbers adds to array list curr pos neighbors that are walls
    private void add_neighbors_to_list(int[][]prim_maze,ArrayList<Position> positions, Position curr_pos,int rows,int columns){
        // add above the curr_pos
        if (curr_pos.row+2 <rows){
            if(prim_maze[curr_pos.row+2][curr_pos.col]!= 0) //if wall add to walls list
            positions.add(new Position(curr_pos.row+2,curr_pos.col));
        }
        if (curr_pos.row-2 >=0){ //add below curr_pos
            if(prim_maze[curr_pos.row-2][curr_pos.col]!= 0) //if wall add to walls list
            positions.add(new Position(curr_pos.row-2,curr_pos.col));
        }
        if (curr_pos.col-2 >=0){ //add right to curr_pos
            if(prim_maze[curr_pos.row][curr_pos.col-2]!= 0) //if wall add to walls list
                positions.add(new Position(curr_pos.row,curr_pos.col-2));
        }
        if (curr_pos.col+2<columns){
            if(prim_maze[curr_pos.row][curr_pos.col+2]!= 0) //if wall add to walls list
                positions.add(new Position(curr_pos.row,curr_pos.col+2));
        }
    }
    private Position find_route(int[][] maze, Position curr_pos){
        Position path;
        try{ //if maze above curr position
            if(maze[curr_pos.row-2][curr_pos.col]==0){
                return new Position(curr_pos.row-1,curr_pos.col );
            }
        }
        catch (Exception e){ //do nothing

        }
        try{ //if maze below curr position
            if(maze[curr_pos.row+2][curr_pos.col]==0){
                return new Position(curr_pos.row+1,curr_pos.col );
            }
        }
        catch (Exception e){ //do nothing

        }
        try{ //if maze is right to curr position
            if(maze[curr_pos.row][curr_pos.col+2]==0){
                return new Position(curr_pos.row,curr_pos.col+1);
            }
        }
        catch (Exception e){ //do nothing

        }
        return new Position(curr_pos.row,curr_pos.col-1); //maze got to be left if nothing else
    }
    private void generate_maze(int[][] maze,int rows,int columns){
        for(int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                maze[i][j] = 1;
            }
        }
    }

}
