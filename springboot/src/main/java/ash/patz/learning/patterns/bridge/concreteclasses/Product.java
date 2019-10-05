package ash.patz.learning.patterns.bridge.concreteclasses;

public class Product {

    private String name;
    private int noOfUnitsSold;

    public Product(String name, int noOfUnitsSold) {
        this.name = name;
        this.noOfUnitsSold = noOfUnitsSold;
    }

    public int getNoOfUnitsSold() {
        return noOfUnitsSold;
    }

    public String getName() {
        return name;
    }
}
