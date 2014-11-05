package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.NotFoundHttpResponse;
import HttpServer.Response.ValidHttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GetRequestTest {
    private final String FILE_TO_GET = "getme.txt";
    private final String FILE_DATA = "get";
    private final String PATH_TO_FILE_THAT_EXISTS = "C:\\Users\\zachvan\\Documents\\";

    @Test
    public void GetFileThatExists() throws IOException {
        String fileName = PATH_TO_FILE_THAT_EXISTS + FILE_TO_GET;
        RequestTestHelper.MakeSureFileExists(fileName, FILE_DATA);
        GetRequest getRequest = new GetRequest(fileName);
        HttpResponse httpResponse = getRequest.execute();
        Assert.assertTrue(httpResponse instanceof ValidHttpResponse);
    }

    @Test
    public void GetFileThatDoesNotExist() throws IOException {
        String fileName = PATH_TO_FILE_THAT_EXISTS + "dont" + FILE_TO_GET;
        RequestTestHelper.MakeSureFileDoesNotExist(fileName);
        GetRequest getRequest = new GetRequest(fileName);
        HttpResponse httpResponse = getRequest.execute();
        Assert.assertTrue(httpResponse instanceof NotFoundHttpResponse);
    }
}
