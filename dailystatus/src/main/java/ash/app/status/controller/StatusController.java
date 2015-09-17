package ash.app.status.controller;

import ash.app.status.model.Employee;
import ash.app.status.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sentinel on 9/12/2015.
 */
@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    IEmployeeService employeeService;

    @RequestMapping(value = "/get", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTest(){
        System.out.println("Inside GET");
        return "{\"key\":\"value\"}";
    }

    @RequestMapping(value = "/get/employees", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
}
