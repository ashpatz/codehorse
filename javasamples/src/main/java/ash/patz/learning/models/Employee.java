package ash.patz.learning.models;

/**
 * Created by APatil on 5/20/2017.
 */
public class Employee {

    private String name;
    private int age;
    private String streetAddress;
    private String zipCode;

    public Employee() {
        this.name = String.valueOf(Math.random());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (!name.equals(employee.name)) return false;
        if (!streetAddress.equals(employee.streetAddress)) return false;
        return zipCode.equals(employee.zipCode);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + streetAddress.hashCode();
        result = 31 * result + zipCode.hashCode();
        return result;
    }
}
