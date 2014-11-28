package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.InvalidHttpResponse;
import HttpServer.Response.ValidHttpResponse;
import com.google.common.base.Throwables;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PutRequest implements HttpRequest {
    protected String fileName;
    protected char[] data;

    public PutRequest(String fileName, char[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    @Override
    public HttpResponse execute() {
        writeFile();
        return new ValidHttpResponse();
    }

    protected void writeFile() {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Throwables.propagate(e);
        }

        try (
                FileWriter fileWriter = new FileWriter(file);
        ) {
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
            Throwables.propagate(e);
        }
    }
}
