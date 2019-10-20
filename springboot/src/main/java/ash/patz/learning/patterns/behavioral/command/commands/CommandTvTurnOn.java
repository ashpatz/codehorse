package ash.patz.learning.patterns.behavioral.command.commands;

import ash.patz.learning.patterns.behavioral.command.Command;
import ash.patz.learning.patterns.behavioral.command.Receiver;

public class CommandTvTurnOn implements Command {

    private Receiver tv;

    public CommandTvTurnOn(Receiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}
