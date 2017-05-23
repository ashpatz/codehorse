package ash.patz.learning.concurrency;

/**
 * Created by APatil on 5/21/2017.
 */
public class Runner {

    public static void main(String[] args) {
        Drop drop = new Drop();

        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}

