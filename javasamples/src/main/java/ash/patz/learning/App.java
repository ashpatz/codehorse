package ash.patz.learning;

import ash.patz.learning.generics.GenericFactory;
import ash.patz.learning.models.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException {
        GenericFactory<String> genericFactoryString = new GenericFactory<>();
        String instance = genericFactoryString.createInstance(String.class);
        System.out.println(instance);

        GenericFactory<Employee> employeeGenericFactory = new GenericFactory<>();
        Employee instance1 = employeeGenericFactory.createInstance(Employee.class);
        System.out.println(instance1);
    }
}
