package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServerStrategySolveSearchProblem implements IServerStrategy {
    static int numSolutions = 0;
    @Override
    public void applyStrategy(InputStream inputStream, OutputStream outputStream) {
        try{
            // read maze from client
            ObjectOutputStream toClient = new ObjectOutputStream(outputStream);
            ObjectInputStream fromClient = new ObjectInputStream(inputStream);
            Maze mazeToSolve = (Maze)fromClient.readObject();

            String tempDirectoryPath = System.getProperty("java.io.tmpdir");
            // check if already have same maze
            for(int i=0;i<numSolutions;i++){
                // read every maze and check if already solved maze
                Path stream = Path.of(tempDirectoryPath + "/maze"+i);
                String maze = Files.readString(stream);

                if(mazeToSolve.ToString().equals(maze)){ // if found same maze take solution from solutions
                    FileInputStream fileInputStream = new FileInputStream(tempDirectoryPath + "/solution"+numSolutions);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Solution sol = (Solution)objectInputStream.readObject();

                    //sent solution to client and finish function
                    toClient.writeObject(sol);
                    toClient.flush();
                    objectInputStream.close();
                    return;
                }
            }
            // if didn't find solution solve using best sent to client and save maze and solution

            // first save maze to new file
            Path stream = Path.of(tempDirectoryPath + "/maze"+numSolutions);
            Files.writeString(stream,mazeToSolve.ToString());

            // solve maze
            ISearchingAlgorithm searchingAlgorithm;
            //get from configuration which algorithm to use
            String getSearchingAlgorithm = Configurations.getInstance().getMazeSearchingAlgorithm();
            if(getSearchingAlgorithm.equals("BestFirstSearch")){
                searchingAlgorithm = new BestFirstSearch();
            }
            else if(getSearchingAlgorithm.equals("BreadthFirstSearch")){
                searchingAlgorithm = new BreadthFirstSearch();
            }
            else{
                searchingAlgorithm = new DepthFirstSearch();
            }

            ISearchable searchableMaze = new SearchableMaze(mazeToSolve);
            Solution solution = searchingAlgorithm.solve(searchableMaze);

            //save solution to file
            FileOutputStream fileOutputStream = new FileOutputStream(tempDirectoryPath + "/solution"+numSolutions);
            ObjectOutputStream fileObjectStream = new ObjectOutputStream(fileOutputStream);
            fileObjectStream.writeObject(solution);
            fileObjectStream.close();

            //send solution to client
            toClient.writeObject(solution);
            toClient.flush();

            // increment number of solution saved in disk
            numSolutions += 1;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
