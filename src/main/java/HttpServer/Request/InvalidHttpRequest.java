package HttpServer.Request;

import HttpServer.Response.HttpResponse;
import HttpServer.Response.InvalidHttpResponse;

public class InvalidHttpRequest implements HttpRequest {
    @Override
    public HttpResponse execute() {
        return new InvalidHttpResponse();
    }
}
