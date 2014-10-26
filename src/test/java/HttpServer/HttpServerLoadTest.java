package HttpServer;

import com.sun.deploy.net.HttpResponse;
import com.sun.jersey.api.client.ClientResponse;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class HttpServerLoadTest {

    @Test
    public void GetLoadTest() throws MalformedURLException, IOException {
        int port = 8080;

        HttpServer httpServer = new HttpServer(port);

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);

        WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:" + port).build());
        //ClientResponse response = webResource.path("restPath").path("resourcePath");
    }
}
