package ash.patz.learning.patterns.bridge.concreteclasses;

import ash.patz.learning.patterns.bridge.IVisualisation;

public class ExecutiveVisualisation implements IVisualisation {
    @Override
    public void addItemToDisplay(Product p) {
        System.out.println("Added product name "+p.getName()+" and sales numbers "+p.getNoOfUnitsSold()+" to display for executive");
    }

    @Override
    public void removeItemFromDisplay(Product p) {
        System.out.println("Removed product name "+p.getName()+" and sales numbers "+p.getNoOfUnitsSold()+"from display for executive");
    }
}
