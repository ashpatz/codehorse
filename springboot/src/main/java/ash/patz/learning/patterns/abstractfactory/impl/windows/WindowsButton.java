package ash.patz.learning.patterns.abstractfactory.impl.windows;

import ash.patz.learning.patterns.abstractfactory.Button;

public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering a windows button");
    }
}
