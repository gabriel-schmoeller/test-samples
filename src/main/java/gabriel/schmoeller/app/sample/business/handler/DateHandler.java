package gabriel.schmoeller.app.sample.business.handler;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateHandler {

    public LocalDate calculateNextBusinessDay() {
        LocalDate nextDay = LocalDate.now().plusDays(1);
        switch (nextDay.getDayOfWeek()) {
            case SATURDAY:
                nextDay = nextDay.plusDays(1);
            case SUNDAY:
                nextDay = nextDay.plusDays(1);
        }

        return nextDay;
    }
}
