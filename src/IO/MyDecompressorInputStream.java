package IO;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

    InputStream inputStream;

    public MyDecompressorInputStream(InputStream inputStream) {this.inputStream = inputStream;}

    @Override
    public int read(byte[] byteArr) throws IOException {

        int i =0 ;

        while(i < 12){
            byteArr[i] = (byte) inputStream.read();
            i++;
        }

        int idx=12;

        int n;
        while(idx+8<byteArr.length) {
            n = Byte.toUnsignedInt((byte) inputStream.read());
            i=7;
            while(i >= 0 ){
                byteArr[idx+i]=(byte)(n%2);
                n=n/2;
                i--;
            }
            idx += 8;
        }

        int rest= byteArr.length-idx-1;
        n = Byte.toUnsignedInt((byte) inputStream.read());
        i =rest;
        while(i >= 0 ){
            byteArr[idx+i]=(byte)(n%2);
            n=n/2;
            i--;
        }

        return byteArr.length;
    }

    @Override
    public int read() throws IOException {return 0;}
}