package ash.patz.learning.patterns.behavioral.chainofresponsibility.handlers;

public abstract class AbstractHandler implements Handler {

    private Handler nextHandler;
    protected Integer denomination;

    public AbstractHandler(Integer denomination) {
        this.denomination = denomination;
    }

    @Override
    public void setNext(Handler handler) {
        nextHandler = handler;
    }

    @Override
    public void handle(int amount) {
        int noOfBills = Math.floorDiv(amount, denomination);
        processBills(noOfBills);
        amount -= (noOfBills * denomination);
        if(amount > 0) {
            nextHandler.handle(amount);
        }
    }

    protected void processBills(int noOfBills) {
        if(noOfBills > 0) {
            System.out.println(noOfBills + " bills of  $" + denomination + " have been picked.");
        }
    }
}
