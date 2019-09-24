package ash.patz.learning.patterns.abstractfactory.impl.windows;

import ash.patz.learning.patterns.abstractfactory.Checkbox;

public class WindowsCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering a Windows Checkbox");
    }
}
