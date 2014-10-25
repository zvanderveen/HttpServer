package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.InvalidHttpResponse;
import HttpServer.Response.ValidHttpResponse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PutRequest implements HttpRequest {
    private static final String WEB_ROOT = "C:\\Users\\zachvan\\Documents\\";
    String fileName;
    char[] data;

    public PutRequest(String fileName, char[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    @Override
    public HttpResponse execute() {
        File fileToWrite = new File(WEB_ROOT + fileName);

        try (
            FileWriter fileWriter = new FileWriter(fileToWrite);
        ) {
            fileWriter.write(data);
            return new ValidHttpResponse(null);
        }
        catch (IOException exception) {
            return new InvalidHttpResponse();
        }
    }
}
