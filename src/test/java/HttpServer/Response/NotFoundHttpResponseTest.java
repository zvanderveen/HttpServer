package HttpServer.Response;

import org.junit.Test;

public class NotFoundHttpResponseTest extends HttpResponseTest {

    @Test
    public void ExecuteTest() {
        ExecuteTest(new NotFoundHttpResponse(), "404");
    }
}
