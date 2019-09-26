package ash.patz.learning.patterns.factorymethod.impl.windows;

import ash.patz.learning.patterns.factorymethod.Button;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a windows button");
    }
}
