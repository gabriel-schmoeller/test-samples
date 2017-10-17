package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import gabriel.schmoeller.app.sample.persistence.SampleRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class SampleIdUpdateValidator implements ValidationUnit {

    private static final String VIOLATION_MESSAGE = "The ID can not be null and must be from an existing register";
    private final SampleRepository repository;

    public SampleIdUpdateValidator(SampleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<String> validate(SampleEntity entity) {
        if (Objects.isNull(entity.getId()) || !repository.exists(entity.getId())) {
            return Optional.of(VIOLATION_MESSAGE);
        }

        return Optional.empty();
    }
}
