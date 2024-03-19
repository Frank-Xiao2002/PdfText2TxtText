package pack;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteNextline {
    public static void main(String[] args) throws IOException {
        File original = new File("original.txt"), output = new File("output.txt");
        FileReader fileReader = new FileReader(original);
        FileWriter fileWriter = new FileWriter(output, false);
        int buf, buf2;
        /*13 represents \r, 10 represents \n, read out order is 13,10*/
        while ((buf = fileReader.read()) != -1) {
//            System.out.print((char) buf);
            if (buf == 10) {
                buf2 = fileReader.read();
                if (buf2 == 13) {
                    //noinspection ResultOfMethodCallIgnored
                    fileReader.read();
                    fileWriter.write("\n\n");
                } else {
                    fileWriter.write(32);
                    fileWriter.write(buf2);
                }
            } else if (buf != 13) {
                fileWriter.write(buf);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
