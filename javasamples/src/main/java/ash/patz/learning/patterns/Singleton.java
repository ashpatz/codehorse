package ash.patz.learning.patterns;

import java.util.Date;

public class Singleton {
    private volatile Date dateA;

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        singleton.someMethod();

    }

    public void someMethod() {
        Date dateB;
        dateB = dateA;
        System.out.println(dateB);
        dateA = new Date();
        System.out.println(dateB);
        System.out.println(dateA);
    }
}

