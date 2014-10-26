package HttpServer.Response;

import org.junit.Test;

public class NotFoundHttpResponseTest extends HttpResponseTest {

    @Test
    public void ResponseContains404Code() {
        ResponseContainsCode(new NotFoundHttpResponse(), "404");
    }
}
