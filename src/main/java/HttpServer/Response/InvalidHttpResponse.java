package HttpServer.Response;

import java.io.IOException;
import java.io.Writer;

// 400
public class InvalidHttpResponse implements HttpResponse {
    @Override
    public void write(Writer writer) {
        try {
            writer.write("HTTP/1.1 400 Bad Request" + System.lineSeparator());
            writer.write("Server: Java HTTP Server 1.0" + System.lineSeparator());
            writer.write("Content-type: text/html" + System.lineSeparator());
            writer.write("Connection: close" + System.lineSeparator());
            writer.write(System.lineSeparator());
            writer.write("Bad Request" + System.lineSeparator());
            writer.flush();
        }
        catch (IOException exception) {
            // what can we do?
        }
    }
}
