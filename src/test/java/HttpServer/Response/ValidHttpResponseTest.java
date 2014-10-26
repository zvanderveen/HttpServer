package HttpServer.Response;

import org.junit.Test;

public class ValidHttpResponseTest extends HttpResponseTest {

    @Test
    public void ResponseContains200Code() {
        ResponseContainsCode(new ValidHttpResponse(new byte[0]), "200");
    }
}
