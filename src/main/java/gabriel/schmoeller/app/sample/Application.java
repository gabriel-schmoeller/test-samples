package gabriel.schmoeller.app.sample;

import gabriel.schmoeller.app.sample.config.SampleConfiguration;
import org.springframework.boot.SpringApplication;

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(SampleConfiguration.class, args);
    }
}
