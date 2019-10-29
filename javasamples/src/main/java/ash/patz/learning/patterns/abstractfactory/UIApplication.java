package ash.patz.learning.patterns.abstractfactory;

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
