package ash.patz.learning.patterns.bridge.concreteclasses;

import ash.patz.learning.patterns.bridge.IVisualisation;

public class CustomerVisualisation implements IVisualisation {
    @Override
    public void addItemToDisplay(Product p) {
        System.out.println("Added product name "+p.getName()+" to display for customer");
    }

    @Override
    public void removeItemFromDisplay(Product p) {
        System.out.println("Removed product name "+p.getName()+" from display for customer");
    }
}
