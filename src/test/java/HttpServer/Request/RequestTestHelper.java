package HttpServer.Request;

import java.io.File;
import java.io.IOException;

public class RequestTestHelper {
    public static void MakeSureFileExists(String fileName) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void MakeSureFileDoesNotExist(String fileName) throws IOException {
        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
        }
    }
}
