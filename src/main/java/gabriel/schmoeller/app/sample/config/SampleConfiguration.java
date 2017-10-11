package gabriel.schmoeller.app.sample.config;

import gabriel.schmoeller.app.sample.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackageClasses = Application.class)
@EnableJpaRepositories(basePackageClasses = Application.class)
@EntityScan(basePackageClasses = Application.class)
public class SampleConfiguration {
}
