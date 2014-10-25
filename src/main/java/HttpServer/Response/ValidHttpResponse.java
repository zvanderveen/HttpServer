package HttpServer.Response;

import java.io.IOException;
import java.io.Writer;

public class ValidHttpResponse implements HttpResponse {
    byte[] data;

    public ValidHttpResponse(byte[] data) {
        if (data != null) {
            this.data = data;
        }
        else {
            this.data = new byte[0];
        }
    }

    @Override
    public void write(Writer writer) {
        try {
            writer.write("HTTP/1.1 200 OK");
            writer.write("Server: Java HTTP Server 1.0");
            writer.write("Content-type: text/html");
            writer.write("Content-length: " + data.length);
            writer.write("Connection: close");
            writer.write("");
            writer.write(new String(data));
            writer.flush();
        }
        catch (IOException exception) {

        }
    }
}
