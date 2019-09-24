package ash.patz.learning.patterns.absfactory.impl.mac;

import ash.patz.learning.patterns.absfactory.Button;

public class MacButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering mac button");
    }
}
