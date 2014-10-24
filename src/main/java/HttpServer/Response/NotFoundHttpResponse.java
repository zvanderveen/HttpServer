package HttpServer.Response;

import java.io.PrintWriter;

// 400
public class NotFoundHttpResponse implements HttpResponse {
    @Override
    public void write(PrintWriter writer) {
        writer.println("HTTP/1.1 404 Not Found");
        writer.println("Server: Java HTTP Server 1.0");
        writer.println("Content-type: text/html");
        writer.println("Connection: close");
        writer.println("");
        writer.println("File Not Found");
        writer.flush();
    }
}
