package ash.patz.learning.patterns.abstractfactory.impl.windows;

import ash.patz.learning.patterns.abstractfactory.Button;
import ash.patz.learning.patterns.abstractfactory.Checkbox;
import ash.patz.learning.patterns.abstractfactory.GUIFactory;

public class WindowsGuiFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
