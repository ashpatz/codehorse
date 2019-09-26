package ash.patz.learning.patterns.factorymethod.impl.mac;

import ash.patz.learning.patterns.factorymethod.Button;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering mac button");
    }
}
