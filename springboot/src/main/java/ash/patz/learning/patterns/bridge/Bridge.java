package ash.patz.learning.patterns.bridge;

import ash.patz.learning.patterns.bridge.concreteclasses.Product;

/**
 * This can have an abstract method
 */
public class Bridge {

    private IVisualisation visualisation;

    protected Bridge(IVisualisation visualisation) {
        this.visualisation = visualisation;
    }

    public void addProduct(Product product) {
        visualisation.addItemToDisplay(product);
    }

    public void deleteProduct(Product product) {
        visualisation.removeItemFromDisplay(product);
    }
}
