package ash.patz.learning.patterns.behavioral.command;

import ash.patz.learning.patterns.behavioral.command.commands.CommandStereoNextChannel;
import ash.patz.learning.patterns.behavioral.command.commands.CommandStereoTurnOn;
import ash.patz.learning.patterns.behavioral.command.commands.CommandTvNextChannel;
import ash.patz.learning.patterns.behavioral.command.commands.CommandTvTurnOn;

public class Client {

    public static void main(String[] args) {
        Receiver tv = new ReceiverTv();
        Receiver stereo = new ReceiverStereo();

        CommandTvTurnOn commandTvTurnOn = new CommandTvTurnOn(tv);
        CommandTvNextChannel commandTvNextChannel = new CommandTvNextChannel(tv);
        CommandStereoTurnOn commandStereoTurnOn = new CommandStereoTurnOn(stereo);
        CommandStereoNextChannel commandStereoNextChannel = new CommandStereoNextChannel(stereo);

        InvokerRemoteControl invokerRemoteControl = new InvokerRemoteControl(commandTvTurnOn, commandTvNextChannel);
        invokerRemoteControl.pressPowerButton();
        invokerRemoteControl.pressNextChannelButton();

        invokerRemoteControl = new InvokerRemoteControl(commandStereoTurnOn, commandStereoNextChannel);
        invokerRemoteControl.pressPowerButton();
        invokerRemoteControl.pressNextChannelButton();
    }
}
