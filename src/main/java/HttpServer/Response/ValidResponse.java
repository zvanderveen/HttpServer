package HttpServer.Response;

import java.io.PrintWriter;

public class ValidResponse implements HttpResponse {
    byte[] data;

    public ValidResponse(byte[] data) {
        if (data != null) {
            this.data = data;
        }
        else {
            this.data = new byte[0];
        }
    }

    @Override
    public void write(PrintWriter headerWriter) {
        headerWriter.println("HTTP/1.1 200 OK");
        headerWriter.println("Server: Java HTTP Server 1.0");
        headerWriter.println("Content-type: text/html");
        headerWriter.println("Content-length: " + data.length);
        headerWriter.println("Connection: close");
        headerWriter.println("");
        headerWriter.println(new String(data));
        headerWriter.flush();
    }
}
