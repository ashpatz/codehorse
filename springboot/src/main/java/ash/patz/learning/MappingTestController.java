package ash.patz.learning;

import ash.patz.learning.service.RemoteService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by APatil on 5/2/2017.
 */
@RestController
public class MappingTestController {

    @Autowired
    private RemoteService service;

    @RequestMapping(value = "/random/delay")
    public String getRandomDelayedResponse() {
        return service.invokeRemoteService();
    }

    @RequestMapping(value = "/hello/{there}")
    public String index(@PathParam("there") String myPathParam) {
        System.out.println("Inside /hello/{there}");
        System.out.println(myPathParam);
        return "Invoked /hello/{there}";
    }

    @RequestMapping(value = "/hello/there")
    public String index() {
        System.out.println("Inside /hello/there");
        return "/hello/there";
    }

    @RequestMapping(value= "/hello/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getJson() {
        return jsonResponse;
    }

    private String jsonResponse = "";

}
