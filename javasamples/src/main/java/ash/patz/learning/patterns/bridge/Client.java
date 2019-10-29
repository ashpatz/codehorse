package ash.patz.learning.patterns.bridge;

import ash.patz.learning.patterns.bridge.concreteclasses.CustomerVisualisation;
import ash.patz.learning.patterns.bridge.concreteclasses.ExecutiveVisualisation;
import ash.patz.learning.patterns.bridge.concreteclasses.Product;

public class Client {

    private static  Bridge customerBridge;
    private static Bridge executiveBridge;

    public static void main(String[] args) {

        initializeBridges();

        //Add items
        Product lamp = new Product("lamp", 400);
        Product tv = new Product("tv", 200);

        addProduct(lamp);
        addProduct(tv);

        deleteProduct(lamp);
    }

    private static void initializeBridges() {
        CustomerVisualisation customerVisualisation = new CustomerVisualisation();
        customerBridge = new Bridge(customerVisualisation);

        ExecutiveVisualisation executiveVisualisation = new ExecutiveVisualisation();
        executiveBridge = new Bridge(executiveVisualisation);
    }


    private static void addProduct(Product p) {
        customerBridge.addProduct(p);
        executiveBridge.addProduct(p);
    }

    private static void deleteProduct(Product p) {
        customerBridge.deleteProduct(p);
        executiveBridge.deleteProduct(p);
    }
}
