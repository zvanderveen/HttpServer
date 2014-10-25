package HttpServer.Response;

import org.junit.Test;

public class InvalidHttpResponseTest extends HttpResponseTest {

    @Test
    public void ExecuteTest() {
        ExecuteTest(new InvalidHttpResponse(), "400");
    }
}
