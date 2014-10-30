package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.NotFoundHttpResponse;
import HttpServer.Response.ValidHttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PutRequestTest {
    private final String FILE_TO_PUT = "putme.txt";
    private final String FILE_DATA = "put";
    private final String PATH_TO_FILE_THAT_EXISTS = "C:\\Users\\zachvan\\Documents\\";

    @Test
    public void PutFileThatExists() throws IOException {
        String fileName = PATH_TO_FILE_THAT_EXISTS + FILE_TO_PUT;
        RequestTestHelper.MakeSureFileExists(fileName, FILE_DATA);
        PutRequest putRequest = new PutRequest(fileName, FILE_DATA.toCharArray());
        HttpResponse httpResponse = putRequest.execute();
        Assert.assertTrue(httpResponse instanceof ValidHttpResponse);
    }

    @Test
    public void PutFileThatDoesNotExist() throws IOException {
        String fileName = PATH_TO_FILE_THAT_EXISTS + FILE_TO_PUT;
        RequestTestHelper.MakeSureFileDoesNotExist(fileName);
        PutRequest putRequest = new PutRequest(fileName, FILE_DATA.toCharArray());
        HttpResponse httpResponse = putRequest.execute();
        Assert.assertTrue(httpResponse instanceof ValidHttpResponse);
    }
}
