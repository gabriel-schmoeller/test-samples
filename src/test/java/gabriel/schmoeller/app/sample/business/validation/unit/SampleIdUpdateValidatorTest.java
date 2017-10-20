package gabriel.schmoeller.app.sample.business.validation.unit;

import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import gabriel.schmoeller.app.sample.persistence.SampleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class SampleIdUpdateValidatorTest {

    private static final Long EXISTANT_ID = 1L;
    private static final Long UNEXISTANT_ID = 2L;

    @Mock
    private SampleRepository repository;

    @InjectMocks
    private SampleIdUpdateValidator validator;

    @Test
    public void shouldPassValidation() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setId(EXISTANT_ID);

        Mockito.when(repository.exists(EXISTANT_ID)).thenReturn(true);

        // when
        Optional<String> violation = validator.validate(entity);

        // then
        Assert.assertFalse(violation.isPresent());
    }

    @Test
    public void shouldFailWhenIdIsNull() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setId(null);

        Mockito.when(repository.exists(Matchers.anyLong())).thenReturn(true);

        // when
        Optional<String> violation = validator.validate(entity);

        // then
        Assert.assertTrue(violation.isPresent());
    }

    @Test
    public void shouldFailWhenIdNotExists() {
        // given
        SampleEntity entity = new SampleEntity();
        entity.setId(UNEXISTANT_ID);

        Mockito.when(repository.exists(Matchers.anyLong())).thenReturn(true);
        Mockito.when(repository.exists(UNEXISTANT_ID)).thenReturn(false);

        // when
        Optional<String> violation = validator.validate(entity);

        // then
        Assert.assertTrue(violation.isPresent());
    }
}