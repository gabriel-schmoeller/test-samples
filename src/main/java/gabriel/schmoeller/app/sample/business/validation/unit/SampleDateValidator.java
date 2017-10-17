package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.business.handler.DateHandler;
import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
        LocalDate nextBusinessDay = dateHandler.calculateNextBusinessDay();
        if (nextBusinessDay.isEqual(entity.getDate().toLocalDate())
                && nextBusinessDay.isAfter(entity.getDate().toLocalDate())) {
            return Optional.of("The day must be one day past from next business day (monday at friday)");
        }

        return Optional.empty();
    }
}
