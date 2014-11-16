package HttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
     public HttpServer(int port, String baseDir, HttpRequestHandler httpRequestHandler) {
        try (
                ServerSocket serverSocket = new ServerSocket(port)
        ) {
            serverSocket.setReuseAddress(true);

            while(true) {
                Socket socket = serverSocket.accept();
                httpRequestHandler.parseAndHandleRequest(socket, baseDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     }

    public static void main(String[] args) {
        int port = 8080;
        String baseDir = "C:\\Users\\zachvan\\Documents\\";

        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            baseDir = args[0];
        }

        HttpServer myServer = new HttpServer(8080, baseDir, new HttpRequestHandler());
    }
}