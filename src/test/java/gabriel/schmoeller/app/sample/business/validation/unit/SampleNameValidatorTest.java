package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class SampleNameValidatorTest {

    private static final String VALID_NAME = "Pudding";
    private static final String EMPTY_NAME = "";
    private static final String INVALID_NAME = "Pudding!!!!!!!!!!!!!!";

    private SampleNameValidator validator;

    @Before
    public void setUp() {
        validator = new SampleNameValidator();
    }

    @Test
    public void shouldBeValid() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setName(VALID_NAME);

        // when
        Optional<String> violation = validator.validate(entity);

        // then
        Assert.assertFalse(violation.isPresent());
    }

    @Test
    public void shouldBeInvalidWhenNameIsNull() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setName(null);

        // when
        Optional<String> violation = validator.validate(entity);

        // then
        Assert.assertTrue(violation.isPresent());
    }

    @Test
    public void shouldBeInvalidWhenNameIsEmpty() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setName(EMPTY_NAME);

        // when
        Optional<String> violation = validator.validate(entity);

        // then
        Assert.assertTrue(violation.isPresent());
    }

    @Test
    public void shouldBeInvalidWhenNameIsGreaterThanMaxSize() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setName(INVALID_NAME);

        // when
        Optional<String> violation = validator.validate(entity);

        // then
        Assert.assertTrue(violation.isPresent());
    }

}