package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.*;

import java.io.*;
import java.nio.file.Path;

public class ServerStrategyGenerateMaze implements IServerStrategy,Runnable {

    @Override
    public void applyStrategy(InputStream inputStream, OutputStream outputStream) {
        try{
            ObjectOutputStream outputStream1 = new ObjectOutputStream(outputStream);
            ObjectInputStream fromClient = new ObjectInputStream(inputStream);
            //get dimensions from client
            int[] dimensions;
            dimensions = (int[])fromClient.readObject();

            //create maze
            String mazeGenarator = Configurations.getInstance().getGeneratingAlgorithm();
            IMazeGenerator mazeGeneratorToUse;
            //get from configuration which generator to use
            if(mazeGenarator.equals("MyMazeGenerator")){
                mazeGeneratorToUse = new MyMazeGenerator();
            }
            else if(mazeGenarator.equals("EmptyMazeGenerator")){
                mazeGeneratorToUse = new EmptyMazeGenerator();
            }
            else{
                mazeGeneratorToUse = new SimpleMazeGenerator();
            }

            Maze myMaze = mazeGeneratorToUse.generate(dimensions[0],dimensions[1]);

            //send maze to client
            //create file to write into it compressed maze
            File f = new File("Compress.txt");
            FileOutputStream fileOut = new FileOutputStream(f);
            MyCompressorOutputStream myCompressorOutputStream = new MyCompressorOutputStream(fileOut);
            myCompressorOutputStream.write(myMaze.toByteArray());
            //read from file
            FileInputStream fileInputStream = new FileInputStream(f);
            byte[] mazeToSend = fileInputStream.readAllBytes();

            //send to client
            outputStream1.writeObject(mazeToSend);

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
