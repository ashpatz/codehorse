package ash.patz.learning.patterns.factorymethod;

public class UIApplication {

    private GuiFactory guiFactory;

    public UIApplication(GuiFactory guiFactory) {
        this.guiFactory = guiFactory;
    }

    public void renderUI() {
        guiFactory.render();
    }


}
