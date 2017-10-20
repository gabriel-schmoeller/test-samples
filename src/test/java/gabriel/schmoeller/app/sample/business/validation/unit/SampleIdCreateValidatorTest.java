package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class SampleIdCreateValidatorTest {

    private static final Long ANY_ID = 1L;

    private SampleIdCreateValidator validator = new SampleIdCreateValidator();

    @Test
    public void shouldPassValidation() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setId(null);

        // when
        Optional<String> violation = validator.validate(entity);


        // then
        Assert.assertFalse(violation.isPresent());
    }

    @Test
    public void shouldFailWhenIdIsNotNull() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setId(ANY_ID);

        // when
        Optional<String> violation = validator.validate(entity);

        // then
        Assert.assertTrue(violation.isPresent());
    }

}