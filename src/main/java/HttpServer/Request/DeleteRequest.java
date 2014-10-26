package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.NotFoundHttpResponse;
import HttpServer.Response.ValidHttpResponse;

import java.io.File;

public class DeleteRequest implements HttpRequest {
    String fileName;

    public DeleteRequest(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public HttpResponse execute() {
        File fileToDelete = new File(fileName);
        if (!fileToDelete.exists()) return new NotFoundHttpResponse();

        fileToDelete.delete();
        return new ValidHttpResponse(null);
    }
}
