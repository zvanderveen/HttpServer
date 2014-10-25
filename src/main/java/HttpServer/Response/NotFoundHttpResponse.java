package HttpServer.Response;

import java.io.IOException;
import java.io.Writer;

// 404
public class NotFoundHttpResponse implements HttpResponse {
    @Override
    public void write(Writer writer) {
        try {
            writer.write("HTTP/1.1 404 Not Found");
            writer.write("Server: Java HTTP Server 1.0");
            writer.write("Content-type: text/html");
            writer.write("Connection: close");
            writer.write("");
            writer.write("File Not Found");
            writer.flush();
        }
        catch (IOException exception) {

        }
    }
}
