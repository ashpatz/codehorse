package ash.patz.learning.patterns.factorymethod.impl.windows;

import ash.patz.learning.patterns.factorymethod.GuiFactory;
import ash.patz.learning.patterns.factorymethod.Button;

public class WindowsGuiFactory extends GuiFactory {
    @Override
    protected Button getButton() {
        return new WindowsButton();
    }
}
