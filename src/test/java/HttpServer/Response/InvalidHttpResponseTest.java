package HttpServer.Response;

import org.junit.Test;

public class InvalidHttpResponseTest extends HttpResponseTest {

    @Test
    public void ResponseContains400Code() {
        ResponseContainsCode(new InvalidHttpResponse(), "400");
    }
}
