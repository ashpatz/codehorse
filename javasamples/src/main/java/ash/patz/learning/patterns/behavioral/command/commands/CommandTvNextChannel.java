package ash.patz.learning.patterns.behavioral.command.commands;

import ash.patz.learning.patterns.behavioral.command.Command;
import ash.patz.learning.patterns.behavioral.command.Receiver;

public class CommandTvNextChannel implements Command {

    private Receiver tv;

    public CommandTvNextChannel(Receiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.nextChannel();
    }
}
