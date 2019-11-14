package ash.patz.learning.patterns.behavioral.command;

public class ReceiverTv extends Receiver {
    @Override
    public void turnOn() {
        System.out.println("Turned on TV");
    }

    @Override
    public void nextChannel() {
        System.out.println("Presenting the next tv channel");
    }
}
