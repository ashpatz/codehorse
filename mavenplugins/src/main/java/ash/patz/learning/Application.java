package ash.patz.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by APatil on 5/26/2017.
 */
@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"ash.patz.learning"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
