package ash.patz.learning.patterns.behavioral.chainofresponsibility.handlers;

public interface Handler {
    void setNext(Handler handler);
    void handle(int amount);
}
