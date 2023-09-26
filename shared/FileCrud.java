package shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileCrud {
    /**
     * Read a file
     * 
     * @param {String} filePath - a path of a file
     * @return {String} content of a file
     * @throws IOException
     */
    public String readFile(String filePath) throws IOException {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or blank!");
        }

        FileInputStream fis = new FileInputStream(filePath);
        File file = new File(filePath);
        byte[] data = new byte[(int) file.length()];

        fis.read(data);
        fis.close();

        return new String(data, "UTF-8");
    }
}
