package ash.app.status.model;

/**
 * Created by Sentinel on 9/17/2015.
 */
public class Employee {

    private int employeeId;
    private String name;
    private String email;
    private String designation;
    private String city;
    private String blogUrl;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", city='" + city + '\'' +
                ", blogUrl='" + blogUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (employeeId != employee.employeeId) return false;
        if (!blogUrl.equals(employee.blogUrl)) return false;
        if (!city.equals(employee.city)) return false;
        if (!designation.equals(employee.designation)) return false;
        if (!email.equals(employee.email)) return false;
        if (!name.equals(employee.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + designation.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + blogUrl.hashCode();
        return result;
    }
}
