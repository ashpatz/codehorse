package ash.patz.learning.patterns.factorymethod.impl.mac;

import ash.patz.learning.patterns.factorymethod.GuiFactory;
import ash.patz.learning.patterns.factorymethod.Button;

public class MacGuiFactory extends GuiFactory {
    @Override
    protected Button getButton() {
        return new MacButton();
    }
}
