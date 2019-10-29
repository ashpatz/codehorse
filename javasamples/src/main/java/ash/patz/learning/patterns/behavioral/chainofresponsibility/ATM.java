package ash.patz.learning.patterns.behavioral.chainofresponsibility;

import ash.patz.learning.patterns.behavioral.chainofresponsibility.handlers.*;

public class ATM {

    private Handler handler;

    public ATM() {

        // Initialize individual handlers
        _100Handler _100handler = new _100Handler();
        _50Handler _50handler = new _50Handler();
        _20Handler _20handler = new _20Handler();
        _10Handler _10handler = new _10Handler();
        _5Handler _5handler = new _5Handler();
        _1Handler _1handler = new _1Handler();

        // Chain handlers
        _100handler.setNext(_50handler);
        _50handler.setNext(_20handler);
        _20handler.setNext(_10handler);
        _10handler.setNext(_5handler);
        _5handler.setNext(_1handler);

        this.handler = _100handler;
    }

    public void withdraw(int amount) {
        handler.handle(amount);
    }
}
