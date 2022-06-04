package IO;

import java.io.IOException;
import java.io.InputStream;

public class SimpleDecompressorInputStream extends InputStream {

    InputStream input;

    public SimpleDecompressorInputStream(InputStream input){
        this.input = input;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] byteArr) throws IOException {
        int i = 0;

        while (i < 12) {
            byte b = (byte) this.input.read();
            byteArr[i] = b;
            i++;
        }
        int len =byteArr.length;

        int n, index = 12, val =0;
        while ( index < len){
            n = Byte.toUnsignedInt((byte) input.read());
            while (n > 0 ){
                byteArr[index] = (byte) val;
                index++;
                n--;
            }
            if (val == 0)
                val = 1;
            else
                val = 0;
        }
        return len;
    }
}


