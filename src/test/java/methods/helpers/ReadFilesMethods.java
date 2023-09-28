package methods.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFilesMethods {

    /**
     * Method returns String from txt file with parameter file path
     */
    public String readTxtFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
