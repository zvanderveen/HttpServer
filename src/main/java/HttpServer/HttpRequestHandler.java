package HttpServer;

import HttpServer.Request.*;
import HttpServer.Response.HttpResponse;

import java.io.*;
import java.net.Socket;

public class HttpRequestHandler implements  IHttpRequestHandler {
    protected String fileName;
    protected String action;

    @Override
    public void parseAndHandleRequest(Socket socket, String baseDir) {
        try (
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        ) {
            HttpRequest httpRequest = parseRequest(bufferedReader, baseDir);
            HttpResponse httpResponse = httpRequest.execute();
            httpResponse.write(outputStreamWriter);
        } catch (IOException exception) {
            System.out.println("Did not process request");
        }
    }

    protected HttpRequest parseRequest(BufferedReader bufferedReader, String baseDir) {
        try {
            parseCommand(bufferedReader);
            ignoreHeaders(bufferedReader);
            return processRequest(bufferedReader, baseDir);
        } catch (IOException exception) {
            return new InvalidHttpRequest();
        }
    }

    protected void parseCommand(BufferedReader bufferedReader) throws IOException {
        String readString = bufferedReader.readLine();
        if (readString == null) throw new IllegalArgumentException();
        String[] splitLine = readString.split(" ");

        if (splitLine.length < 3) throw new IllegalArgumentException();

        this.fileName = splitLine[1];
        fileName = fileName.substring(1);
        if (fileName.equals("")) throw new IllegalArgumentException();

        this.action = splitLine[0];
    }

    protected void ignoreHeaders(BufferedReader bufferedReader) throws IOException {
        for (String readString = bufferedReader.readLine(); readString.length() > 0; readString = bufferedReader.readLine()) {
        }
    }

    protected HttpRequest processRequest(BufferedReader bufferedReader, String baseDir) throws IOException {
        switch (action) {
            case "GET":
                return new GetRequest(baseDir + fileName);
            case "DELETE":
                return new DeleteRequest(baseDir + fileName);
            case "PUT":
                return new PutRequest(baseDir + fileName, parsePutBodyData(bufferedReader).toCharArray());
        }

        return new InvalidHttpRequest();
    }

    protected static String parsePutBodyData(BufferedReader bufferedReader) throws IOException {
        StringBuffer data = new StringBuffer();

        for (String readString = bufferedReader.readLine(); readString.length() > 0; readString = bufferedReader.readLine()) {
            data.append(readString);
        }

        return data.toString();
    }
}
