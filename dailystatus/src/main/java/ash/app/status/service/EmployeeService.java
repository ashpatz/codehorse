package ash.app.status.service;

import ash.app.status.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sentinel on 9/17/2015.
 */
public class EmployeeService implements IEmployeeService{

    @Override
    public List<Employee> getEmployees() {
        String csvFile = "employees.csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";
        List<Employee> employeeList = new ArrayList<>();
        try {

            br = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("employees.csv")));
            while ((line = br.readLine()) != null) {
                final Employee employee = new Employee();
                // use comma as separator
                String[] employeeLine = line.split(cvsSplitBy);
                employee.setEmployeeId(Integer.valueOf(employeeLine[0]));
                employee.setName(employeeLine[1]);
                employee.setDesignation(employeeLine[2]);
                employee.setCity(employeeLine[3]);
                employee.setBlogUrl(employeeLine[4]);
                employeeList.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return employeeList;
    }

}
