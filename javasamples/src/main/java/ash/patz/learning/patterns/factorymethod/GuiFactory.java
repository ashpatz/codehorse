package ash.patz.learning.patterns.factorymethod;

public abstract class GuiFactory {

    public void render() {
        System.out.println("Trying to render a button (platform unknown)");
        Button button = getButton();
        button.render();
    }

    /**
     * Factory method
     * @return
     */
    protected abstract Button getButton();
}
