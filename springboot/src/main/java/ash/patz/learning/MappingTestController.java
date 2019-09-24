package ash.patz.learning;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

/**
 * Created by APatil on 5/2/2017.
 */
@RestController
public class MappingTestController {
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
