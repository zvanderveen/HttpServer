package HttpServer;

import java.net.Socket;

public interface IHttpRequestHandler {
        public void parseAndHandleRequest(Socket socket, String baseDir);
}
