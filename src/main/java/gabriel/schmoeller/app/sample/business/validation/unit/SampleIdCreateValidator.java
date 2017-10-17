package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class SampleIdCreateValidator implements ValidationUnit {

    private static final String VIOLATION_MESSAGE = "The ID must be null";

    @Override
    public Optional<String> validate(SampleEntity entity) {
        if (Objects.nonNull(entity.getId())) {
            return Optional.of(VIOLATION_MESSAGE);
        }

        return Optional.empty();
    }
}
