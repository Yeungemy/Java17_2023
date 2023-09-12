package shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileCrud {
    public String readFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        File file = new File(filePath);
        byte[] data = new byte[(int) file.length()];
        
        fis.read(data);
        fis.close();
        
        return new String(data, "UTF-8");
    }
}
