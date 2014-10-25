package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.NotFoundHttpResponse;
import HttpServer.Response.ValidHttpResponse;

import java.io.File;

public class DeleteRequest implements HttpRequest {
    private static final String WEB_ROOT = "C:\\Users\\zachvan\\Documents\\";
    String fileName;

    public DeleteRequest(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public HttpResponse execute() {
        File fileToDelete = new File(WEB_ROOT + fileName);
        if (!fileToDelete.exists()) return new NotFoundHttpResponse();

        fileToDelete.delete();
        return new ValidHttpResponse(null);
    }
}
