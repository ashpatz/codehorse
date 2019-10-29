package ash.patz.learning.patterns.bridge;

import ash.patz.learning.patterns.bridge.concreteclasses.Product;

public interface IVisualisation {

    void addItemToDisplay(Product p);

    void removeItemFromDisplay(Product p);

}
