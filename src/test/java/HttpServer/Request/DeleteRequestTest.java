package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.NotFoundHttpResponse;
import HttpServer.Response.ValidHttpResponse;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class DeleteRequestTest {
    private final String FILE_TO_DELETE = "deleteme.txt";
    private final String FILE_DATA = "delete";
    private final String PATH_TO_FILE_THAT_EXISTS = "C:\\Users\\zachvan\\Documents\\";

    @Test
    public void regexTest() {
        String blogPost = "a few lines<br><br/><br>and a few more<br>";
        blogPost = blogPost.replaceFirst("^(?i)(<br>|<br/>)+","");
        System.out.println(blogPost);
    }

    @Test
    public void DeleteFileThatExists() throws IOException {
        String fileName = PATH_TO_FILE_THAT_EXISTS + FILE_TO_DELETE;
        RequestTestHelper.MakeSureFileExists(fileName, FILE_DATA);
        DeleteRequest deleteRequest = new DeleteRequest(fileName);
        HttpResponse httpResponse = deleteRequest.execute();
        Assert.assertTrue(httpResponse instanceof ValidHttpResponse);
    }

    @Test
    public void DeleteFileThatDoesNotExist() throws IOException {
        String fileName = PATH_TO_FILE_THAT_EXISTS + FILE_TO_DELETE;
        RequestTestHelper.MakeSureFileDoesNotExist(fileName);
        DeleteRequest deleteRequest = new DeleteRequest(fileName);
        HttpResponse httpResponse = deleteRequest.execute();
        Assert.assertTrue(httpResponse instanceof NotFoundHttpResponse);
    }
}
