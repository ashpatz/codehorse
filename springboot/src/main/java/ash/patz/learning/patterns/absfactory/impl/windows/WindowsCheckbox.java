package ash.patz.learning.patterns.absfactory.impl.windows;

import ash.patz.learning.patterns.absfactory.Checkbox;

public class WindowsCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering a Windows Checkbox");
    }
}
