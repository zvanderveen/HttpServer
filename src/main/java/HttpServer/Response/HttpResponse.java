package HttpServer.Response;

import java.io.Writer;

public interface HttpResponse {
    public void write(Writer writer);
}
