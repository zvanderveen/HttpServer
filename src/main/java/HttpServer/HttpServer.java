package HttpServer;

import HttpServer.Request.HttpRequest;
import HttpServer.Request.HttpRequestFactory;
import HttpServer.Response.HttpResponse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private static final int PORT = 9000;

     public HttpServer() {
        try (
                ServerSocket serverSocket = new ServerSocket(PORT)
        ) {
            serverSocket.setReuseAddress(true);

            while(true) {
                Socket socket = serverSocket.accept();
                parseAndHandleRequest(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     }

    public void parseAndHandleRequest(Socket socket) throws IOException {
        try (
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter headerWriter = new PrintWriter(outputStream);
        ) {
            HttpRequest httpRequest = HttpRequestFactory.parseRequest(bufferedReader);
            HttpResponse httpResponse = httpRequest.execute();
            httpResponse.write(headerWriter);
        } catch (IOException exception) {
            System.out.println("Did not process request");
        }
    }

    public static void main(String[] args) {
        HttpServer myServer = new HttpServer();
    }
}