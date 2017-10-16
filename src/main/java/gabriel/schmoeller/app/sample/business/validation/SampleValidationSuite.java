package gabriel.schmoeller.app.sample.business.validation;

import gabriel.schmoeller.app.sample.business.validation.unit.SampleDateValidator;
import gabriel.schmoeller.app.sample.business.validation.unit.SampleIdCreateValidator;
import gabriel.schmoeller.app.sample.business.validation.unit.SampleIdUpdateValidator;
import gabriel.schmoeller.app.sample.business.validation.unit.SampleNameValidator;
import gabriel.schmoeller.app.sample.business.validation.unit.ValidationUnit;
import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SampleValidationSuite {

    private static final String ERROR_ON_CREATE_A_SAMPLE_ENTITY = "Error on create a Sample Entity: ";
    private static final String ERROR_ON_UPDATE_A_SAMPLE_ENTITY = "Error on update a Sample Entity: ";

    private final SampleDateValidator dateValidator;
    private final SampleNameValidator nameValidator;
    private final SampleIdCreateValidator idCreateValidator;
    private final SampleIdUpdateValidator idUpdateValidator;
    private final ValidationSuiteExecutor executor;

    @Autowired
    public SampleValidationSuite(SampleDateValidator dateValidator, SampleNameValidator nameValidator,
            SampleIdCreateValidator idCreateValidator, SampleIdUpdateValidator idUpdateValidator,
            ValidationSuiteExecutor executor) {
        this.dateValidator = dateValidator;
        this.nameValidator = nameValidator;
        this.idCreateValidator = idCreateValidator;
        this.idUpdateValidator = idUpdateValidator;
        this.executor = executor;
    }

    public void validateToCreate(SampleEntity entity) {
        List<ValidationUnit> units = Arrays.asList(idCreateValidator, nameValidator, dateValidator);

        executor.runUnits(units, entity, ERROR_ON_CREATE_A_SAMPLE_ENTITY + entity);
    }

    public void validateToUpdate(SampleEntity entity) {
        List<ValidationUnit> units = Arrays.asList(idUpdateValidator, nameValidator, dateValidator);

        executor.runUnits(units, entity, ERROR_ON_UPDATE_A_SAMPLE_ENTITY + entity);
    }
}
