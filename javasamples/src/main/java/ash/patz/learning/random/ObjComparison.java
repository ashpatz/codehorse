package ash.patz.learning.random;

import java.text.SimpleDateFormat;
import java.util.*;

public class ObjComparison {

    /*
     * Feel free to add additional data sets for testing/experimenting.
     * Data is formatted 'firstName,lastName,DOB(yyyy-MM-dd)'.
     */
    static final List<String> exampleData = new ArrayList<>();

    static {
        exampleData.add("Meryl,Streep,1949-06-22");
        exampleData.add("Kathrine,Hepburn,1907-05-12");
        exampleData.add("Audrey,Hepburn,1929-05-04");
        exampleData.add("Archie,Panjabi,1972-05-31");
        exampleData.add("Kerry,Washington,1977-01-31");
    }
}

/*
 * Coderpad uses a static Solution.main method as its entry point.
 * See https://coderpad.io/languages#java for available libraries.
 */
class Solution {
    public static void main(final String[] args) {

        List<Person> actorsList = new ArrayList<>();

        // Example use of Data.exampleData
        for (final String record : ObjComparison.exampleData) {

            String[] tokens = record.split(",");
            String firstname = tokens[0];
            String lastname = tokens[1];
            String dateStr = tokens[2];
            Person p = new Person(firstname, lastname, dateStr);
            actorsList.add(p);
            //System.out.println(record);
        }

        Collections.sort(actorsList, new FirstNameComparator());

        for (Person p : actorsList) {
            System.out.println(p);
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");

        Collections.sort(actorsList, new LastNameComparator());

        for (Person p : actorsList) {
            System.out.println(p);
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");

        Collections.sort(actorsList, new FirstNameComparator());

        Date thresholdDate = new GregorianCalendar(1945, Calendar.JANUARY, 1).getTime();
        for (Person p : actorsList) {
            if (p.personDate.getTime() > thresholdDate.getTime()) {
                System.out.println(p);
            }

        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

        Comparator<Person> byFirstName1 = (Person p1, Person p2) -> {
            return p1.firstName.compareTo(p2.firstName);
        };
        Comparator<Person> byFirstName2 = Comparator.comparing(p -> p.firstName);

        Collections.sort(actorsList, byFirstName2);
        for (Person p : actorsList) {
            System.out.println(p);
        }
    }
}

class FirstNameComparator implements Comparator<Person> {

    public int compare(Person p1, Person p) {
        return p1.firstName.compareTo(p.firstName);
    }
}

class LastNameComparator implements Comparator<Person> {

    public int compare(Person p1, Person p) {
        int firstNameComparisonRes = p1.firstName.compareTo(p.firstName);
        int lastNameComparisonRes = p1.lastName.compareTo(p.lastName);
        if (lastNameComparisonRes == 0) {
            return firstNameComparisonRes;
        } else {
            return lastNameComparisonRes;
        }
    }
}

class Person {
    public String firstName;
    public String lastName;
    public Date personDate;

    private SimpleDateFormat fixedDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Person(String firstName, String lastName, String personDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            this.personDate = fixedDateFormat.parse(personDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public String toString() {
        return this.firstName + " "
                + this.lastName + " " + fixedDateFormat.format(personDate);
    }

}
