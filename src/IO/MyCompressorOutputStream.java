package IO;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class MyCompressorOutputStream extends OutputStream {
    OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        return;
    }

    @Override
    public void write(byte[] b) throws IOException {
        int newSize = (b.length-12)/8+12;
        if((b.length-12)%8>0)
            newSize++;
        byte[] newMaze = new byte[newSize];

        for(int i=0;i<12;i++)
            newMaze[i]=b[i];

        int num , i , j = 12 , k = 12 ;

        while(k+8<b.length) {
            num = 0;
            i = 7;

            while(i >= 0){
                num=num+(int)Math.pow(2,7-i)*b[k+i];
                i--;
            }

            newMaze[j]=(byte)num;
            j++;
            k += 8;
        }

        int rest= b.length-k-1;
        num = 0;
        i = rest;
        while(i >= 0){
            num=num+(int)Math.pow(2,rest-i)*b[k+i];
            i--;
        }
        newMaze[j]=(byte)num;
        out.write(newMaze);
    }
}