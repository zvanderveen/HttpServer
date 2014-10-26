package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.InvalidHttpResponse;
import HttpServer.Response.NotFoundHttpResponse;
import HttpServer.Response.ValidHttpResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GetRequest implements HttpRequest {
    String fileName;

    public GetRequest(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public HttpResponse execute() {
        File fileToGet = new File(fileName);
        if (!fileToGet.exists()) return new NotFoundHttpResponse();

        try (
            FileInputStream fileInputStream = new FileInputStream(fileToGet);
        ){
            int fileLength = (int)fileToGet.length();
            byte[] fileData = new byte[fileLength];
            fileInputStream.read(fileData);

            return new ValidHttpResponse(fileData);
        }
        catch (IOException exception) {
            return new InvalidHttpResponse();
        }
    }
}
