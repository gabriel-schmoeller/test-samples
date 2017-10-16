package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class SampleNameValidator implements ValidationUnit {

    private static final int NAME_MAX_SIZE = 20;
    private static final String VIOLATION_MESSAGE = "The Name of can't be null, empty or greater than " + NAME_MAX_SIZE + " characters";

    @Override
    public Optional<String> validate(SampleEntity entity) {
        if (Objects.isNull(entity.getName()) || entity.getName().isEmpty() || isGreaterThanMaxSize(entity)) {
            return Optional.of(VIOLATION_MESSAGE);
        }

        return Optional.empty();
    }

    private boolean isGreaterThanMaxSize(SampleEntity entity) {
        return entity.getName().length() > NAME_MAX_SIZE;
    }
}
