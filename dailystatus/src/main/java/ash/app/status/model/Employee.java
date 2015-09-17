package ash.app.status.model;

/**
 * Created by Sentinel on 9/17/2015.
 */
public class Employee {

    private int employeeId;
    private String name;
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
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
        if (blogUrl != null ? !blogUrl.equals(employee.blogUrl) : employee.blogUrl != null) return false;
        if (city != null ? !city.equals(employee.city) : employee.city != null) return false;
        if (designation != null ? !designation.equals(employee.designation) : employee.designation != null)
            return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (blogUrl != null ? blogUrl.hashCode() : 0);
        return result;
    }
}
