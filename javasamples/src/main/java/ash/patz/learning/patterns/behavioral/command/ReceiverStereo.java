package ash.patz.learning.patterns.behavioral.command;

public class ReceiverStereo extends Receiver {
    @Override
    public void turnOn() {
        System.out.println("Turned on Stereo");
    }

    @Override
    public void nextChannel() {
        throw new RuntimeException("not implemented!");
    }
}
