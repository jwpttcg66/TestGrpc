import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaprApplication {

    /**
     * Starts Dapr's callback in a given port.
     * @param port Port to listen to.
     */
    public static void start(int port) {
        SpringApplication app = new SpringApplication(DaprApplication.class);
        app.run(String.format("--server.port=%d", port));
    }

}