package ash.patz.learning.patterns.absfactory.impl.mac;

import ash.patz.learning.patterns.absfactory.Checkbox;

public class MacCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering mac checkbox");
    }
}
