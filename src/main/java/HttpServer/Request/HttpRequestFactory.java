package HttpServer.Request;

import java.io.*;

public class HttpRequestFactory {
    public static HttpRequest parseRequest(BufferedReader bufferedReader) {
        try {
            String readString = bufferedReader.readLine();
            if (readString == null) return new InvalidHttpRequest();
            String[] splitLine = readString.split(" ");

            // logging
            for(String entry : splitLine) {
                System.out.println(entry);
            }

            if (splitLine.length < 3) return new InvalidHttpRequest();

            String fileName = splitLine[1];
            fileName = fileName.substring(1);
            if (fileName.equals("")) return new InvalidHttpRequest();

            String action = splitLine[0];

            switch (action) {
                case "GET":
                    return new GetRequest(fileName);
                case "DELETE":
                    return new DeleteRequest(fileName);
            }
        } catch (IOException exception) {
            return new InvalidHttpRequest();
        }

        return new InvalidHttpRequest();
    }
}
