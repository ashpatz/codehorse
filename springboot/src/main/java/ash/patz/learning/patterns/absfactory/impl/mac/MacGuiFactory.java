package ash.patz.learning.patterns.absfactory.impl.mac;

import ash.patz.learning.patterns.absfactory.Button;
import ash.patz.learning.patterns.absfactory.Checkbox;
import ash.patz.learning.patterns.absfactory.GUIFactory;

public class MacGuiFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
