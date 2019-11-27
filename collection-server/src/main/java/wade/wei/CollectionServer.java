package wade.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableScheduling
public class CollectionServer {
    public static void main(String[] args) {
        SpringApplication.run(CollectionServer.class, args);
    }
}
