package ash.patz.learning.patterns.abstractfactory.impl.mac;

import ash.patz.learning.patterns.abstractfactory.Checkbox;

public class MacCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering mac checkbox");
    }
}
