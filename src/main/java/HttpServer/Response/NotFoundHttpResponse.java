package HttpServer.Response;

import java.io.IOException;
import java.io.Writer;

// 404
public class NotFoundHttpResponse implements HttpResponse {
    @Override
    public void write(Writer writer) {
        try {
            writer.write("HTTP/1.1 404 Not Found" + System.lineSeparator());
            writer.write("Server: Java HTTP Server 1.0" + System.lineSeparator());
            writer.write("Content-type: text/html" + System.lineSeparator());
            writer.write("Connection: close" + System.lineSeparator());
            writer.write(System.lineSeparator());
            writer.write("File Not Found" + System.lineSeparator());
            writer.flush();
        }
        catch (IOException exception) {

        }
    }
}
