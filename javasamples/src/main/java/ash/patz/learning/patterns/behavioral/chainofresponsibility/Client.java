package ash.patz.learning.patterns.behavioral.chainofresponsibility;

public class Client {

    public static void main(String[] args) {

        ATM atm = new ATM();
        atm.withdraw(72);
    }
}
