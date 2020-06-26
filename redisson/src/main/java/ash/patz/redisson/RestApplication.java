package ash.patz.redisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(RestApplication.class, args);
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }
}
