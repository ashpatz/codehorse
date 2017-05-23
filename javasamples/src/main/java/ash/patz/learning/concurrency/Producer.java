package ash.patz.learning.concurrency;

/**
 * Created by APatil on 5/21/2017.
 */
public class Producer implements Runnable{

    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            String message = String.valueOf(Math.random());
            System.out.format("%s : Putting value %s", Thread.currentThread(), message);
            drop.put(message);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.put("done");

    }
}
