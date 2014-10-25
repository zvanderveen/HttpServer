package HttpServer.Response;

import java.io.IOException;
import java.io.Writer;

// 400
public class InvalidHttpResponse implements HttpResponse {
    @Override
    public void write(Writer writer) {
        try {
            writer.write("HTTP/1.1 400 Bad Request");
            writer.write("Server: Java HTTP Server 1.0");
            writer.write("Content-type: text/html");
            writer.write("Connection: close");
            writer.write("");
            writer.write("Bad Request");
            writer.flush();
        }
        catch (IOException exception) {
            // what can we do?
        }
    }
}
