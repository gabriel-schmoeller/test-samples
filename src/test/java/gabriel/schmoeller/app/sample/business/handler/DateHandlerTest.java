package gabriel.schmoeller.app.sample.business.handler;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class DateHandlerTest {

    private static final LocalDate MONDAY_DAY = LocalDate.of(2017, Month.OCTOBER, 16);
    private static final LocalDate FRIDAY_DAY = LocalDate.of(2017, Month.OCTOBER, 20);
    private static final LocalDate SATURDAY_DAY = LocalDate.of(2017, Month.OCTOBER, 21);
    private static final LocalDate SUNDAY_DAY = LocalDate.of(2017, Month.OCTOBER, 22);

    private DateHandler handler = new DateHandler();

    @Test
    public void shouldBeABusinessDayWhenDayIsMonday() {
        // given
        LocalDate day = MONDAY_DAY;

        // when
        Boolean isBusinessDay = handler.isBusinessDay(day);

        // then
        Assert.assertTrue(isBusinessDay);
    }

    @Test
    public void shouldBeABusinessDayWhenDayIsFriday() {
        // given
        LocalDate day = FRIDAY_DAY;

        // when
        Boolean isBusinessDay = handler.isBusinessDay(day);

        // then
        Assert.assertTrue(isBusinessDay);
    }

    @Test
    public void shouldNotBeABusinessDayWhenDayIsSaturday() {
        // given
        LocalDate day = SATURDAY_DAY;

        // when
        Boolean isBusinessDay = handler.isBusinessDay(day);

        // then
        Assert.assertFalse(isBusinessDay);
    }

    @Test
    public void shouldNotBeABusinessDayWhenDayIsSunday() {
        // given
        LocalDate day = SUNDAY_DAY;

        // when
        Boolean isBusinessDay = handler.isBusinessDay(day);

        // then
        Assert.assertFalse(isBusinessDay);
    }

}