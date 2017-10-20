package gabriel.schmoeller.app.sample.business.validation;

import gabriel.schmoeller.app.sample.business.validation.unit.ValidationUnit;
import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ValidationSuiteExecutorTest {

    @InjectMocks
    private ValidationSuiteExecutor executor;

    @Test(expected = ValidationException.class)
    public void shouldThrowsExceptionWhenUnitFail() {
        // given
        ValidationUnit unit = Mockito.mock(ValidationUnit.class);
        List<ValidationUnit> units = Arrays.asList(unit);
        SampleEntity entity = new SampleEntity();
        String violationMessage = "Any message";

        Mockito.when(unit.validate(entity)).thenReturn(Optional.of("Other message"));

        // when
        executor.runUnits(units, entity, violationMessage);

        // then
        // throws exception
    }

    @Test
    public void shouldNotThrowsExceptionWhenUnitPass() {
        // given
        ValidationUnit unit = Mockito.mock(ValidationUnit.class);
        List<ValidationUnit> units = Arrays.asList(unit);
        SampleEntity entity = new SampleEntity();
        String violationMessage = "Any message";

        Mockito.when(unit.validate(entity)).thenReturn(Optional.empty());

        // when
        executor.runUnits(units, entity, violationMessage);

        // then
        // throws exception
    }

}