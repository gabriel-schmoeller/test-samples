package gabriel.schmoeller.app.sample.business.validation;

import gabriel.schmoeller.app.sample.business.validation.unit.ValidationUnit;
import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ValidationSuiteExecutor {

    public void runUnits(List<ValidationUnit> units, SampleEntity entity, String violationMessage) {
        List<String> violations = units.stream()
                .map(unit -> unit.validate(entity))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        throw new ValidationException(violationMessage, violations);
    }
}
