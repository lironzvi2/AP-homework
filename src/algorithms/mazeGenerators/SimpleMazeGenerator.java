package algorithms.mazeGenerators;

import java.util.Random;
    public class SimpleMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        int[][] mazeMatrix = new int[rows][columns];
        Random random = new Random();
        int i, j;
        for (i = 0 ; i < rows ; i++) {
            for (j = 0 ; j < columns ; j++) {
                mazeMatrix[i][j] = 1;
            }
        }
        for (i = 1 ; i < rows - 1 ; i++) {
            for (j = 1 ; j < columns - 1 ; j++) {
                mazeMatrix[i][j] = random.nextInt(2);
            }
        }
        Maze maze = new Maze(mazeMatrix);

        Position[] randomStartAndEndPositions = maze.GetStartAndEndPosition();
        maze.startP = randomStartAndEndPositions[0];
        maze.endP = randomStartAndEndPositions[1];
        maze.SetPositionToVal(maze.startP, 0);
        maze.SetPositionToVal(maze.endP, 0);
        int startX = maze.startP.row;
        int startY = maze.startP.col;

        int endX = maze.endP.row;
        int endY = maze.endP.col;

        while(startX != endX || startY != endY ){
            if (startX > endX)
            {
                if (startX != 0 || startY != 0)
                {
                    maze.SetRowColVal(startX, startY, 0);
                }
                startX--;
            }
            if (startX < startY)
            {
                if (startX != 0 || startY != 0)
                {
                    maze.SetRowColVal(startX, startY, 0);
                }
                startX++;
            }
            if (startY > endY)
            {
                if (startX != 0 || startY != 0)
                {
                    maze.SetRowColVal(startX, startY, 0);
                }
                startY--;
            }
            if (startY < startY)
            {
                if (startX != 0 || startY != 0)
                {
                    maze.SetRowColVal(startX, startY, 0);
                }
                startY++;
            }
        }
        return maze;
    }
}
