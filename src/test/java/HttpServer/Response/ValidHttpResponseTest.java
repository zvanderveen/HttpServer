package HttpServer.Response;

import org.junit.Test;

public class ValidHttpResponseTest extends HttpResponseTest {

    @Test
    public void ExecuteTest() {
        ExecuteTest(new ValidHttpResponse(new byte[0]), "200");
    }
}
