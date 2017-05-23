package ash.patz.learning.concurrency;

/**
 * Created by APatil on 5/21/2017.
 */
public class Drop {

    private String message;
    private boolean empty = true;

    public synchronized void put(String message) {
        if(!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        empty = false;
        this.message = message;
        notifyAll();
    }

    public synchronized String take() {
        if(empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;

        notifyAll();
        return this.message;
    }


}
