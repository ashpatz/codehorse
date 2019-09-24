package ash.patz.learning.patterns.absfactory.impl.windows;

import ash.patz.learning.patterns.absfactory.Button;

public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering a windows button");
    }
}
