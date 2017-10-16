package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SampleIdUpdateValidator implements ValidationUnit {

    @Override
    public Optional<String> validate(SampleEntity entity) {
        return null;
    }
}
