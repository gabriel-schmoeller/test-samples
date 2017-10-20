package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.business.handler.DateHandler;
import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Optional;

@Component
public class SampleDateValidator implements ValidationUnit {

    private final DateHandler dateHandler;

    @Autowired
    public SampleDateValidator(DateHandler dateHandler) {
        this.dateHandler = dateHandler;
    }

    @Override
    public Optional<String> validate(SampleEntity entity) {
        if (!dateHandler.isBusinessDay(entity.getDate().toLocalDate())
                || entity.getDate().toLocalTime().isBefore(LocalTime.NOON)
                ||  entity.getDate().toLocalTime().isAfter(LocalTime.of(18, 0))) {
            return Optional.of("The day must be between monday and friday between 12 and 18 hours of day");
        }

        return Optional.empty();
    }
}
