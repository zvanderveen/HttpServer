package HttpServer.Request;

import java.io.*;

public class HttpRequestFactory {
    private static final String WEB_ROOT = "C:\\Users\\zachvan\\Documents\\";

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
                    return new GetRequest(WEB_ROOT + fileName);
                case "DELETE":
                    return new DeleteRequest(WEB_ROOT + fileName);
                case "PUT":
                    StringBuffer data = new StringBuffer();
                    while (readString != null && readString.length() > 0) {
                        readString = bufferedReader.readLine();
                    }

                    readString = bufferedReader.readLine();

                    while (readString != null && readString.length() > 0) {
                        data.append(readString);
                        readString = bufferedReader.readLine();
                    }

                    return new PutRequest(WEB_ROOT + fileName, data.toString().toCharArray());
            }
        } catch (IOException exception) {
            return new InvalidHttpRequest();
        }

        return new InvalidHttpRequest();
    }
}
