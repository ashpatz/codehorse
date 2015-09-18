package ash.app.status.controller;

import ash.app.status.model.Employee;
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

    @GET
    @Path("/fetch")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setName("Ashish Patil");
        employee.setDesignation("Architect");
        employee.setCity("Switzerland");
        employeeList.add(employee);

        employee = new Employee();
        employee.setEmployeeId(2);
        employee.setName("Ramadhir Singh");
        employee.setDesignation("Mukhiya");
        employee.setCity("Wasseypur");
        employeeList.add(employee);

       // GenericEntity<List<Employee>> jsonEmployeeList = new GenericEntity<List<Employee>>(employeeList){};
        return Response.ok(employeeList).build();
    }

    @GET
    @Path("/fetchone")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setName("Ashish Patil");
        employee.setDesignation("Architect");
        employee.setCity("Switzerland");

        return Response.ok(employee).build();
    }
}
