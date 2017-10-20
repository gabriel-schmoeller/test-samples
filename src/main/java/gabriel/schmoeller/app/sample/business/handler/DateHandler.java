package gabriel.schmoeller.app.sample.business.handler;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateHandler {

    public Boolean isBusinessDay(LocalDate date) {
        switch (date.getDayOfWeek()) {
            case SATURDAY:
            case SUNDAY:
                return false;
            default:
                return true;
        }
    }
}
