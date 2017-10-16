package gabriel.schmoeller.app.sample.business;

import gabriel.schmoeller.app.sample.business.validation.SampleValidationSuite;
import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import gabriel.schmoeller.app.sample.persistence.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService {

    private final SampleRepository repository;
    private final SampleValidationSuite validator;

    @Autowired
    public SampleService(SampleRepository repository, SampleValidationSuite validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public List<SampleEntity> listSamples() {
        ArrayList<SampleEntity> sampleEntities = new ArrayList<>();

        repository.findAll().forEach(sampleEntities::add);

        return sampleEntities;
    }

    public SampleEntity create(SampleEntity entity) {
        validator.validateToCreate();
        return repository.save(entity);
    }

    public SampleEntity update(SampleEntity entity) {
        validator.validateToUpdate();
        return repository.save(entity);
    }
}
