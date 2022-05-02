package algorithms.mazeGenerators;

import java.util.Random;
    public class SimpleMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        int[][] mazeMatrix = new int[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mazeMatrix[i][j] = random.nextInt(2);
            }
        }
        Maze maze = new Maze(mazeMatrix);

        return maze;
    }
}
