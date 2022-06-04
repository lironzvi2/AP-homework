package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class SimpleCompressorOutputStream  extends OutputStream {
    OutputStream output;

    public SimpleCompressorOutputStream(OutputStream output){
        this.output = output;
    }

    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] byteArr) throws IOException {
        ArrayList<Byte> maze = new ArrayList<>();
        int i=12, c =0;

        boolean cur = false;
        while( i < byteArr.length){
            if (cur){
                if(byteArr[i] == 1){
                    c++;
                }
                else{
                    cur = false;
                    toByte(maze, c);
                    c++;
                }
            }
            else{
                if(byteArr[i] == 0){
                    c++;
                }
                else{
                    cur = true;
                    toByte(maze, c);
                    c++;
                }
            }
            i++;
        }

        toByte(maze, c);
        byte[] newMaze = new byte[maze.size() + 12];
        i = 0;
        while( i < 12){
            newMaze[i] = byteArr[i];
            i++;
        }
        for (int j  =0 ; i < maze.size(); i++){
            newMaze[j + 12] = maze.get(j);
        }

        output.write(newMaze);
    }

    private void toByte(ArrayList<Byte> arr, int len){
        if (len == 0 ){
            arr.add((byte) 0 );
        }
        int i = len;

        while ( i > 0 ){
            if (len < 255){
                arr.add((byte) i);
            }
            else{
                arr.add((byte) 255);
                arr.add((byte) 0);
            }
            i -= 255;
        }

    }

}
