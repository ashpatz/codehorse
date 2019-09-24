package ash.patz.learning.patterns.absfactory.impl.windows;

import ash.patz.learning.patterns.absfactory.Button;
import ash.patz.learning.patterns.absfactory.Checkbox;
import ash.patz.learning.patterns.absfactory.GUIFactory;

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
