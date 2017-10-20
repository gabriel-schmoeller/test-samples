package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.business.handler.DateHandler;
import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BadSampleDateValidatorTest {

    private static final int YEAR = 2017;
    private static final int FRIDAY = 20;
    private static final int SATURDAY = 21;
    private static final int SUNDAY = 22;

    private static final int VALID_HOUR = 12;

    private static final LocalDateTime VALID_DATE_TIME = LocalDateTime.of(YEAR, Month.OCTOBER, FRIDAY, VALID_HOUR, 0);
    private static final LocalDateTime INVALID_SATURDAY_DATE = LocalDateTime.of(YEAR, Month.OCTOBER, SATURDAY, VALID_HOUR, 0);
    private static final LocalDateTime INVALID_SUNDAY_DATE = LocalDateTime.of(YEAR, Month.OCTOBER, SUNDAY, VALID_HOUR, 0);

    @Mock
    private DateHandler dateHandler;

    @InjectMocks
    private SampleDateValidator validator;

    @Test
    public void shouldBeValid() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setDate(VALID_DATE_TIME);

        Mockito.when(dateHandler.isBusinessDay(entity.getDate().toLocalDate())).thenReturn(true);

        // when
        Optional<String> violations = validator.validate(entity);

        // then
        Assert.assertFalse(violations.isPresent());
    }

    @Test
    public void shouldNotBeValidWhenDayIsSaturday() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setDate(INVALID_SATURDAY_DATE);

        Mockito.when(dateHandler.isBusinessDay(entity.getDate().toLocalDate())).thenReturn(false);

        // when
        Optional<String> violations = validator.validate(entity);

        // then
        Assert.assertTrue(violations.isPresent());
    }

    @Test
    public void shouldNotBeValidWhenDayIsSunday() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setDate(INVALID_SUNDAY_DATE);

        Mockito.when(dateHandler.isBusinessDay(entity.getDate().toLocalDate())).thenReturn(false);

        // when
        Optional<String> violations = validator.validate(entity);

        // then
        Assert.assertTrue(violations.isPresent());
    }
}