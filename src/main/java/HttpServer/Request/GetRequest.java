package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.InvalidHttpResponse;
import HttpServer.Response.NotFoundHttpResponse;
import HttpServer.Response.ValidResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GetRequest implements HttpRequest {
    private static final String WEB_ROOT = "C:\\Users\\zachvan\\Documents\\";
    String fileName;

    public GetRequest(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public HttpResponse execute() {
        File fileToGet = new File(WEB_ROOT + fileName);
        if (!fileToGet.exists()) return new NotFoundHttpResponse();

        try (
            FileInputStream fileInputStream = new FileInputStream(fileToGet);
        ){
            int fileLength = (int)fileToGet.length();
            byte[] fileData = new byte[fileLength];
            fileInputStream.read(fileData);

            return new ValidResponse(fileData);
        }
        catch (IOException exception) {
            return new InvalidHttpResponse();
        }
    }
}