package ash.patz.learning.patterns.abstractfactory;


import ash.patz.learning.patterns.abstractfactory.impl.mac.MacGuiFactory;
import ash.patz.learning.patterns.abstractfactory.impl.windows.WindowsGuiFactory;
import org.apache.commons.lang.SystemUtils;

public class TestClient {

    public static void main(String[] args) {
        GUIFactory guiFactory;
        if(SystemUtils.IS_OS_WINDOWS) {
            guiFactory = new WindowsGuiFactory();
        } else {
            guiFactory = new MacGuiFactory();
        }
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();
        button.render();
        checkbox.render();
    }
}
