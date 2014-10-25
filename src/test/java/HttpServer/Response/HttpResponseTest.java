package HttpServer.Response;

import org.junit.Assert;

import java.io.StringWriter;

public abstract class HttpResponseTest {
    public void ExecuteTest(HttpResponse response, String responseCode) {
        StringWriter writer = new StringWriter();
        response.write(writer);
        Assert.assertTrue(writer.toString().contains(responseCode));
    }
}
