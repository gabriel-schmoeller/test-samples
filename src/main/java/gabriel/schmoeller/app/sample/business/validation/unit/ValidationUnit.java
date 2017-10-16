package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.persistence.SampleEntity;

import java.util.Optional;

public interface ValidationUnit {

    Optional<String> validate(SampleEntity entity);
}
