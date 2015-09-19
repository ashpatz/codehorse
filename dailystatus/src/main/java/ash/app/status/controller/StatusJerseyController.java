package ash.app.status.controller;

import ash.app.status.model.Employee;
import ash.app.status.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sentinel on 9/17/2015.
 */
@Component
@Path("/employee")
public class StatusJerseyController {

    @Autowired
    private IEmployeeService employeeService;

    @GET
    @Path("/fetch/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllEmployees() {
        return Response.ok(employeeService.getEmployees()).build();
    }

    @GET
    @Path("/fetchone")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setName("Ashish Patil");
        employee.setDesignation("Architect");
        employee.setCity("Switzerland");
        employee.setEmail("ashish@codehorsecorp.com");

        return Response.ok(employee).build();
    }
}
