package ash.patz.learning.patterns.abstractfactory.impl.mac;

import ash.patz.learning.patterns.abstractfactory.Button;

public class MacButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering mac button");
    }
}
