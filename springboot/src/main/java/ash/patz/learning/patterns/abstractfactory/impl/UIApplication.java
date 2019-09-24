package ash.patz.learning.patterns.abstractfactory.impl;

import ash.patz.learning.patterns.abstractfactory.Button;
import ash.patz.learning.patterns.abstractfactory.Checkbox;
import ash.patz.learning.patterns.abstractfactory.GUIFactory;

public class UIApplication {

    private Button button;
    private Checkbox checkbox;

    public UIApplication(GUIFactory guiFactory) {
        button = guiFactory.createButton();
        checkbox = guiFactory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }


}
