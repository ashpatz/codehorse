package ash.patz.learning.patterns.behavioral.command.commands;

import ash.patz.learning.patterns.behavioral.command.Command;
import ash.patz.learning.patterns.behavioral.command.Receiver;

public class CommandStereoTurnOn implements Command {

    private Receiver stereo;

    public CommandStereoTurnOn(Receiver stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.turnOn();
    }
}
