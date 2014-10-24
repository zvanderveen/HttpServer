package HttpServer.Response;

import java.io.PrintWriter;

public interface HttpResponse {
    public void write(PrintWriter writer);
}
