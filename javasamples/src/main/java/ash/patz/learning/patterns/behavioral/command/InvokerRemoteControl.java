package ash.patz.learning.patterns.behavioral.command;

public class InvokerRemoteControl {

    private Command powerCommand;
    private Command nextChannelCommand;

    public InvokerRemoteControl(Command powerCommand, Command nextChannelCommand) {
        this.powerCommand = powerCommand;
        this.nextChannelCommand = nextChannelCommand;
    }

    public void pressPowerButton() {
        // take a backup if necessary
        powerCommand.execute();
    }

    public void pressNextChannelButton() {
        // take a backup if necessary
        nextChannelCommand.execute();
    }
}
