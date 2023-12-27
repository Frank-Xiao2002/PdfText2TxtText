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
        int buf = -1;
        while ((buf = fileReader.read()) != -1) {
            if (buf == 13) {
                fileWriter.write(32);
            } else if (buf != 10) {
                fileWriter.write(buf);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
