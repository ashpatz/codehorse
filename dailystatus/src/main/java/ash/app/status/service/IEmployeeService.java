package ash.app.status.service;

import ash.app.status.model.Employee;

import java.util.List;

/**
 * Created by Sentinel on 9/17/2015.
 */
public interface IEmployeeService {

    List<Employee> getEmployees();
}
