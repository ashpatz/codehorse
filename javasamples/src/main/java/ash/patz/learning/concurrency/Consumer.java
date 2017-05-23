package ash.patz.learning.concurrency;

/**
 * Created by APatil on 5/21/2017.
 */
public class Consumer implements Runnable {

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    private Drop drop;

    @Override
    public void run() {
        String take = null;
        do {
             take = drop.take();
            System.out.format("%s : Received %s",Thread.currentThread(), take);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (take != "done");

    }
}
