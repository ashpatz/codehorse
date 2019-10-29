package ash.patz.learning.patterns.abstractfactory.impl.mac;

import ash.patz.learning.patterns.abstractfactory.Button;
import ash.patz.learning.patterns.abstractfactory.Checkbox;
import ash.patz.learning.patterns.abstractfactory.GUIFactory;

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
