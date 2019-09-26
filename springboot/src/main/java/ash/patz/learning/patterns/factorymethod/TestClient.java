package ash.patz.learning.patterns.factorymethod;

import ash.patz.learning.patterns.factorymethod.impl.mac.MacGuiFactory;
import ash.patz.learning.patterns.factorymethod.impl.windows.WindowsGuiFactory;
import org.apache.commons.lang.SystemUtils;

public class TestClient {

    public static void main(String[] args) {
        if(SystemUtils.IS_OS_WINDOWS) {
            new UIApplication(new WindowsGuiFactory()).renderUI();
        } else {
            new UIApplication(new MacGuiFactory()).renderUI();
        }
    }
}
