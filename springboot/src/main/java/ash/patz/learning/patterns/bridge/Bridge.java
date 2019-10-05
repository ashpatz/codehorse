package ash.patz.learning.patterns.bridge;

import ash.patz.learning.patterns.bridge.concreteclasses.Product;

public class Bridge {

    private IVisualisation visualisation;

    public Bridge(IVisualisation visualisation) {
        this.visualisation = visualisation;
    }

    public void addProduct(Product product) {
        visualisation.addItemToDisplay(product);
    }

    public void deleteProduct(Product product) {
        visualisation.removeItemFromDisplay(product);
    }
}
