package ash.app.status.controller;

import ash.app.status.model.Employee;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by Sentinel on 9/17/2015.
 */
@Path("/status")
public class StatusJerseyController {

    public @ResponseBody
    List<Employee> getEmployees(){
        return null;
    }
}
